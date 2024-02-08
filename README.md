# PPMWallet
Privacy Preserving Multiplatform Wallet

[![License](https://img.shields.io/github/license/toful/PPMWallet?style=plastic)](https://github.com/toful/PPMWallet)

Fully decentralized multi-platform wallet that automatically generates and manages asymmetric keys based on the IPFS and blockchain technologies. This wallet allows users to use dApps, while maintaining their privacy against an attacker that wants to identify and extract some sensible information about them.

## Pre-requisites

First version of the project consists of the SKM SCs and the Java code that implements some methods to operate over it. To complie this SC we use Truffle and Ganache is used to emulate the Blockchain where they are tested and evaluated.

* [Truffle](https://www.trufflesuite.com/truffle): A world class development environment, testing framework and asset pipeline for blockchains using the Ethereum Virtual Machine (EVM), aiming to make life as a developer easier.
* [Ganache](https://www.trufflesuite.com/ganache): Quickly fire up a personal Ethereum blockchain which you can use to run tests, execute commands, and inspect state while controlling how the chain operates.

### Install Ganache and Truffle
You can get them using apt-get or download the repositories from the [Official Website](https://www.trufflesuite.com/). 

	sudo apt-get update
	sudo apt-get install nodejs 
	sudo apt-get install npm
	sudo npm install -g ganache-cli truffle


### Get Web3j
Web3j is used to get the SC wrappers and operate with them using Java.

	sudo apt-get install curl
	curl -L get.web3j.io | bash && source ~/.web3j/source.sh  

## Setup
If you are creating a new project you should run the following command and perform some configuration steps:

	truffle init

This command creates the following project structure:
```
/
├─contracts/ 			Directory for Solidity contracts
├─migrations/ 			Directory for scriptable deployment files
├─test/ 				Directory for test files for testing your application and contracts
├─truffle-config.js 	Truffle configuration file
```

### Additional Setup
In the case you want to deploy the SCs using Truffle you must do some additional configuarion steps:

* Specify the network (blockchain) over which the SCs are going to be deployed, by modifying the **truffle-config.js** file, in the case of using Ganache-cli, module.exports module should look like this:
```		
module.exports = {
	networks: {
		development: {
		  host: "Localhost",
		  port: 8545,
		  network_id: '*'
		},
	},
};:
```


## Compile Smart Contracts
To Compile the Contracts using Truffle, execute the following command inside contracts/ directory:

	truffle compile


## Deploy Smart Contract
First you need to init the Blockchain the Contract is going to be deployed on:

	ganache-cli

In order to operate in a comfortable way with the Smart Contracts we have designed a Java app using the web3j library. All dependencies are specified in the pom.xml file, which are imported to your java project using Maven.

Otherwise you can deploy them using truffle.

### Deploy Smart Contracts using the Java app
To Deploy the Contracts using the Java app, first you need to create the Java wrappers to operate with them (these contracts must have been compiled before obtaining the wrappers):

	web3j generate truffle --truffle-json ./build/contracts/$CONTRACT_NAME$.json --outputDir . -p src.main.java.contracts


**Run the app.**

### Deploy Smart Contracts using Truffle
Can deploy the Smart Contracts specified on the migrations/ folder files using:

	truffle migrate

Or interact with them using the truffle console:

	truffle console

## Project Structure
```
/
├─src       			Contains all Java code
│  ├─Main.java
│  ├─aaa.java
│  ├─contracts
│  │    ├─SKM_SC.java
├─contracts/ 			Directory for Solidity contracts
│  ├─SKM_SC.sol 		Secure Key Management Smart Contract
├─migrations/ 			Directory for scriptable deployment files
├─test/ 				Directory for test files for testing your application and contracts
├─truffle-config.js 	Truffle configuration file
├─pom.xml 				Contains Java dependencies
├─LICENSE

```

## Author

* **Cristòfol Daudén Esmel** - [toful](https://github.com/toful)