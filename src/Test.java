import contracts.SKM_SC;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.io.File;
import java.io.FileWriter;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Test {


    private static Web3j web3j;
    private static ClientTransactionManager transactionManager = null;
    private static StaticGasProvider gasProvider;
    private static EntitiesManager entities;
    private static SKM_SC_Manager skmSCManager;

    private static MessageDigest digest;
    private static FileWriter csvWriter;

    public static void main(String args[])  throws Exception {

        File f = new File("./results");
        // check if directory exists
        if (!f.isDirectory()) {
            try{
                if(f.mkdir()) {
                    System.out.println("Results Directory Created");
                } else {
                    System.out.println("Directory is not created");
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }

        //create a Web3j instance to our local Ethereum node (Ganache)
        web3j = Web3j.build( new HttpService("http://localhost:8545") );
        gasProvider = new StaticGasProvider( BigInteger.valueOf(1), BigInteger.valueOf(6721974) );

        entities = new EntitiesManager( web3j.ethAccounts().send().getAccounts().toArray( new String[0] ), web3j );
        skmSCManager = SKM_SC_Manager.getSKM_SC_Manager( web3j, gasProvider );

        digest = MessageDigest.getInstance("SHA-256");

        csvWriter = new FileWriter("results/results.csv", true);
        csvWriter.append( "Method,Iterations,TotalGasUsed,AverageGasUsed\n");

        evaluateSKMSmartContract( 10 );


        csvWriter.flush();
        csvWriter.close();
        web3j.shutdown();
    }

    public static void evaluateSKMSmartContract( int numIterations ) throws Exception {
        SKM_SC contract;
        List<SKM_SC> SKM_SC_list = new ArrayList<>();

        //New consent
        System.out.println("Creating new SKM SC");
        skmSCManager.gasUsed = 0;
        for ( int i = 0; i < numIterations; i++) {
            contract = skmSCManager.newSKM_SC(entities.transactionManagerSmartphoneApp);
            SKM_SC_list.add( contract );
        }
        csvWriter.append( "NewSKM_SC," + numIterations + "," + skmSCManager.gasUsed + "," + skmSCManager.gasUsed / numIterations + "\n" );
        System.out.println( "NewSKM_SC," + numIterations + "," + skmSCManager.gasUsed + "," + skmSCManager.gasUsed / numIterations + "\n" );

        List<Integer> repeats = Arrays.asList(1, 2, 3, 6 ,9);
        List<Integer> numKeys = Arrays.asList(1, 5, 10, 20);

        for ( int j=0; j < repeats.size(); j++ ){
            evaluateAddDevice( SKM_SC_list.get( j ), repeats.get( j ) );
            csvWriter.append( "AddDevice," + repeats.get( j ) + "," + skmSCManager.gasUsed + "," + skmSCManager.gasUsed / repeats.get( j ) + "\n" );
            System.out.println( "AddDevice," + repeats.get( j ) + "," + skmSCManager.gasUsed + "," + skmSCManager.gasUsed / repeats.get( j ) + "\n" );
        }

        for ( int i = 0; i < repeats.size(); i++ ){
            evaluateModTemp( SKM_SC_list.get( i ), 10 );
            csvWriter.append( "ModTemp" + repeats.get(i) + "Devices," + 10 + "," + skmSCManager.gasUsed + "," + skmSCManager.gasUsed / 10 + "\n" );
            System.out.println( "ModTemp" + repeats.get(i) + "Devices," + 10 + "," + skmSCManager.gasUsed + "," + skmSCManager.gasUsed / 10 + "\n" );
        }


        for ( int i=0; i < repeats.size(); i++ ){ //5 vegades, en funcio del nombre de dispositius
            for (int k = 0; k < numKeys.size(); k++) {
                skmSCManager.gasUsed = 0;
                for ( int j=0; j < repeats.get(i); j++ ) { // per cada dispositu, repetri pel nombre de claus totals
                    contract = SKM_SC.load(SKM_SC_list.get(i).getContractAddress(),
                        web3j, entities.transactionManagerPlugins[j], gasProvider);
                    evaluateStoreRef(contract, numKeys.get(k));
                }
                csvWriter.append("StoreRef" + repeats.get(i) + "Devices," + numKeys.get(k) * repeats.get(i) + "," + skmSCManager.gasUsed + "," + skmSCManager.gasUsed / ( numKeys.get(k) * repeats.get(i) ) + "\n");
                System.out.println("StoreRef" + repeats.get(i) + "Devices," + numKeys.get(k) * repeats.get(i) + "," + skmSCManager.gasUsed + "," + skmSCManager.gasUsed / ( numKeys.get(k) * repeats.get(i) ) + "\n");
            }
        }



        for ( int j=0; j < repeats.size(); j++ ){
            evaluateRemoveDevice( SKM_SC_list.get( j ), repeats.get( j ) );
            csvWriter.append( "RemoveDevice," + repeats.get( j ) + "," + skmSCManager.gasUsed + "," + skmSCManager.gasUsed / repeats.get( j ) + "\n" );
            System.out.println( "RemoveDevice," + repeats.get( j ) + "," + skmSCManager.gasUsed + "," + skmSCManager.gasUsed / repeats.get( j ) + "\n" );
        }





    }


    public static void evaluateAddDevice( SKM_SC contract, int numIterations ) throws Exception {

        System.out.println("Add "+ numIterations + " device/s to SKM SC");
        skmSCManager.gasUsed = 0;
        for (int i = 0; i < numIterations; i++ ) {
            skmSCManager.addDevice( contract, entities.plugins[i] );
        }
    }

    public static void evaluateRemoveDevice( SKM_SC contract, int numIterations ) throws Exception {

        System.out.println("Remove "+ numIterations + " device/s from SKM SC");
        skmSCManager.gasUsed = 0;
        for (int i = 0; i < numIterations; i++ ) {
            skmSCManager.removeDevice( contract, entities.plugins[i] );
        }
    }

    public static void evaluateStoreRef( SKM_SC contract, int numIterations ) throws Exception {
        System.out.println("Store new Reference Plug-in");
        for (int i = 0; i < numIterations; i++ ) {
            skmSCManager.storeRefPlugin( contract, new BigInteger( randomHash(), 16 ) );
        }
    }

    public static void evaluateModTemp(  SKM_SC contract, int numIterations ){
        System.out.println("Mod Temporal value");
        for (int i = 0; i < numIterations; i++ ) {
            skmSCManager.storeTemp( contract, new BigInteger( randomHash(), 16 ) );
        }
    }






    private static String randomHash() {

        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        byte[] encodedhash = digest.digest( generatedString.getBytes( StandardCharsets.UTF_8 ) );


        StringBuilder hexString = new StringBuilder(2 * encodedhash.length);
        for (int i = 0; i < encodedhash.length; i++) {
            String hex = Integer.toHexString(0xff & encodedhash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
