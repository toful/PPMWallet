package contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.5.0.
 */
@SuppressWarnings("rawtypes")
public class SKM_SC extends Contract {
    public static final String BINARY = "0x608060405234801561001057600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550610ca0806100606000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c8063952525601161005b5780639525256014610113578063ad70dd5b14610131578063b111cb841461014d578063bf2892161461016957610088565b80631d6d32ba1461008d5780631f3a2ae2146100ab5780631f7b6324146100c75780635a7db533146100e3575b600080fd5b610095610185565b6040516100a29190610bd4565b60405180910390f35b6100c560048036038101906100c091906109f4565b61025e565b005b6100e160048036038101906100dc91906109cb565b6103c6565b005b6100fd60048036038101906100f891906109cb565b610541565b60405161010a9190610bd4565b60405180910390f35b61011b6106ab565b6040516101289190610bd4565b60405180910390f35b61014b60048036038101906101469190610a30565b6106b5565b005b610167600480360381019061016291906109cb565b61078e565b005b610183600480360381019061017e9190610a30565b610909565b005b6000600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900460ff16610216576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161020d90610bb4565b60405180910390fd5b600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010154905090565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146102ec576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016102e390610b74565b60405180910390fd5b600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900460ff1661037b576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161037290610bb4565b60405180910390fd5b80600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101819055505050565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610454576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161044b90610b74565b60405180910390fd5b600160008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900460ff166104e3576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016104da90610bb4565b60405180910390fd5b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160006101000a81548160ff02191690831515021790555050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146105d2576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016105c990610b74565b60405180910390fd5b600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900460ff16610661576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161065890610bb4565b60405180910390fd5b600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101549050919050565b6000600254905090565b600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900460ff16610744576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161073b90610bb4565b60405180910390fd5b80600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001018190555050565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461081c576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161081390610b74565b60405180910390fd5b600160008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900460ff16156108ac576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016108a390610b94565b60405180910390fd5b60018060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160006101000a81548160ff02191690831515021790555050565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610997576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161098e90610b74565b60405180910390fd5b8060028190555050565b6000813590506109b081610c3c565b92915050565b6000813590506109c581610c53565b92915050565b6000602082840312156109dd57600080fd5b60006109eb848285016109a1565b91505092915050565b60008060408385031215610a0757600080fd5b6000610a15858286016109a1565b9250506020610a26858286016109b6565b9150509250929050565b600060208284031215610a4257600080fd5b6000610a50848285016109b6565b91505092915050565b6000610a66603183610bef565b91507f4f6e6c792074686520736d61727470686f6e6520697320616c6c6f776564207460008301527f6f20646f207468697320616374696f6e2e0000000000000000000000000000006020830152604082019050919050565b6000610acc602983610bef565b91507f5468697320706c75672d696e2068617320616c7265616479206265656e20636f60008301527f6e666967757265642e00000000000000000000000000000000000000000000006020830152604082019050919050565b6000610b32601f83610bef565b91507f5468697320706c75672d696e206973206e6f7420636f6e666967757265642e006000830152602082019050919050565b610b6e81610c32565b82525050565b60006020820190508181036000830152610b8d81610a59565b9050919050565b60006020820190508181036000830152610bad81610abf565b9050919050565b60006020820190508181036000830152610bcd81610b25565b9050919050565b6000602082019050610be96000830184610b65565b92915050565b600082825260208201905092915050565b6000610c0b82610c12565b9050919050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000819050919050565b610c4581610c00565b8114610c5057600080fd5b50565b610c5c81610c32565b8114610c6757600080fd5b5056fea26469706673582212205714da28d3e9924e622236ddaf565a568bc657a77f6c575f1e7d5168fef7542a64736f6c63430008000033";

    public static final String FUNC_ADDDEVICE = "addDevice";

    public static final String FUNC_REMOVEDEVICE = "removeDevice";

    public static final String FUNC_storeRef = "storeRef";

    public static final String FUNC_getRef = "getRef";

    public static final String FUNC_MODTEMP = "modTemp";

    public static final String FUNC_GETTEMP = "getTemp";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected SKM_SC(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SKM_SC(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SKM_SC(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SKM_SC(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addDevice(String deviceID) {
        final Function function = new Function(
                FUNC_ADDDEVICE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(deviceID)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> removeDevice(String deviceID) {
        final Function function = new Function(
                FUNC_REMOVEDEVICE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(deviceID)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> storeRef(String deviceID, BigInteger IPFSref) {
        final Function function = new Function(
                FUNC_storeRef, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(deviceID), 
                new org.web3j.abi.datatypes.generated.Uint256(IPFSref)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> storeRef(BigInteger IPFSref) {
        final Function function = new Function(
                FUNC_storeRef, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(IPFSref)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getRef() {
        final Function function = new Function(FUNC_getRef, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getRef(String deviceID) {
        final Function function = new Function(FUNC_getRef, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(deviceID)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> modTemp(BigInteger newTemp) {
        final Function function = new Function(
                FUNC_MODTEMP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(newTemp)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getTemp() {
        final Function function = new Function(FUNC_GETTEMP, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static SKM_SC load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SKM_SC(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SKM_SC load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SKM_SC(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SKM_SC load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SKM_SC(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SKM_SC load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SKM_SC(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SKM_SC> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SKM_SC.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<SKM_SC> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SKM_SC.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SKM_SC> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SKM_SC.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SKM_SC> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SKM_SC.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
