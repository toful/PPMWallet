import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class EntitiesManager {
    String smartphoneApp;
    String[] plugins;
    ClientTransactionManager transactionManagerSmartphoneApp;
    ClientTransactionManager[] transactionManagerPlugins;
    Web3j web3j;

    public EntitiesManager(String[] accounts, Web3j web3j){
        smartphoneApp = accounts[0];
        plugins = Arrays.copyOfRange(accounts, 1, 10);

        this.web3j = web3j;
        transactionManagerSmartphoneApp = new ClientTransactionManager( web3j, smartphoneApp );
        transactionManagerPlugins = Arrays.stream( plugins ).map( n -> new ClientTransactionManager( web3j, n ) ).toArray( ClientTransactionManager[]::new );
    }

    public void getBalance( String account) throws IOException {
        //Get balance of an account.
        EthGetBalance balanceWei = web3j.ethGetBalance( account, DefaultBlockParameterName.LATEST).send();
        System.out.println("Balance in ether: " + Convert.fromWei(balanceWei.getBalance().toString(), Convert.Unit.ETHER) );
    }


}
