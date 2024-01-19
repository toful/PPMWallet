######################################################################
#                           PPMWallet 
#                        Cristòfol Daudén Esmel
#                            Makefile
######################################################################

# General defines

JSON = build/contracts
JAVA = src/contracts
BIN = target/

######################################################################
all : 	
	cd contracts/;	truffle compile; \
	cd ..; mkdir $(JAVA); \
	/home/crises/.web3j/web3j generate truffle --truffle-json ./build/contracts/SKM_SC.json --outputDir . -p src.contracts

	

clean :
	rm -rf $(BIN) $(JSON) $(JAVA)


run : clean all
