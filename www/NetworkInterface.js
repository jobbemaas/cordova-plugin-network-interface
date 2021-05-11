var exec = require('cordova/exec');

function createGetIPAddress(funcName) {
	return function(success, error) {
		success = success || function(){};
		error = error || function(){};
		exec(success, error, 'NetworkInterface', funcName, []);
	}
}

function createGetHostName(funcName) {
	return function(success, error) {
		success = success || function(){};
		error = error || function(){};
		exec(success, error, 'NetworkInterface', funcName, []);
	}
}

exports.getIPAddress = createGetIPAddress('getIPAddress');
exports.getHostName  = createGetHostName('getHostName');