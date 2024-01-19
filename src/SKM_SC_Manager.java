import contracts.SKM_SC;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class SKM_SC_Manager {

    private static SKM_SC_Manager skmSCManager = null;
    private Web3j web3j;
    private ContractGasProvider gasProvider;
    public int gasUsed;
    Scanner sn;
    Random rand;

    public  static SKM_SC_Manager getSKM_SC_Manager(Web3j web3j, ContractGasProvider gasProvider ) {
        if (skmSCManager==null) {
            skmSCManager = new SKM_SC_Manager( web3j, gasProvider );
        }
        return skmSCManager;
    }

    private SKM_SC_Manager(Web3j web3j, ContractGasProvider gasProvider ){
        this.web3j = web3j;
        this.gasProvider = gasProvider;
        sn = new Scanner(System.in);
        rand = new Random();
        gasUsed = 0;
    }

    public SKM_SC newSKM_SC(ClientTransactionManager transactionManager ) {

        try {
            SKM_SC aux = SKM_SC.deploy( web3j, transactionManager, gasProvider ).send();
            System.out.println( "SKM SC Created"
                    + "\n\tTransaction Hash: " + aux.getTransactionReceipt().orElse(null).getTransactionHash()
                    + "\n\tContract address: " + aux.getContractAddress() );
            //Add Transaction Gas to total Gas Used
            gasUsed += aux.getTransactionReceipt().orElse( null ).getGasUsed().intValue();
            return aux;
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public void addDevice( SKM_SC contract, String plugin ){
        try{
            TransactionReceipt receipt = contract.addDevice( plugin ).send();
            System.out.println( "New Device Added"
                    + "\n\tTransaction Hash: " + receipt.getTransactionHash() );
            //Add Transaction Gas to total Gas Used
            gasUsed += receipt.getGasUsed().intValue();
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void removeDevice( SKM_SC contract, String plugin ){
        try{
            TransactionReceipt receipt = contract.removeDevice( plugin ).send();
            System.out.println( "Remove Device"
                    + "\n\tTransaction Hash: " + receipt.getTransactionHash() );
            //Add Transaction Gas to total Gas Used
            gasUsed += receipt.getGasUsed().intValue();
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void storeRefPlugin( SKM_SC contract, BigInteger ipfsRef ){
        try{
            TransactionReceipt receipt = contract.storeRef( ipfsRef ).send();
            System.out.println( "Store new key pair plugin"
                    + "\n\tTransaction Hash: " + receipt.getTransactionHash() );
            //Add Transaction Gas to total Gas Used
            gasUsed += receipt.getGasUsed().intValue();
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void getRefPlugin( SKM_SC contract ){
        try{
            BigInteger ipfsRef = contract.getRef( ).send();
            System.out.println( "\nIPFS Reference:\t" + ipfsRef.toString() );

        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void storeRefSmartphone( SKM_SC contract, String plugin, BigInteger ipfsRef ){
        try{
            TransactionReceipt receipt = contract.storeRef( plugin, ipfsRef ).send();
            //Add Transaction Gas to total Gas Used
            gasUsed += receipt.getGasUsed().intValue();
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void getRefSmartphone( SKM_SC contract, String plugin ){
        try{
            BigInteger ipfsRef = contract.getRef( plugin ).send();
            System.out.println( "\nIPFS Reference:\t" + ipfsRef.toString() );

        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void storeTemp( SKM_SC contract, BigInteger temp ){
        try{
            TransactionReceipt receipt = contract.modTemp( temp ).send();
            //Add Transaction Gas to total Gas Used
            gasUsed += receipt.getGasUsed().intValue();
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void getTemp( SKM_SC contract ){
        try{
            BigInteger ipfsRef = contract.getTemp( ).send();
            System.out.println( "\nTemporal Value:\t" + ipfsRef.toString() );

        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

}
