
var Contract = artifacts.require("SKM_SC");

module.exports = function( deployer, network, accounts ) {
	const smartphoneApp = accounts[0];
	const data = 4294967295;
	
	deployer.deploy(Contract, {from: smartphoneApp});
}
