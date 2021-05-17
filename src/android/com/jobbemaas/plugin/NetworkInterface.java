package com.jobbemaas.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkInterface extends CordovaPlugin {

	private static final String GET_IP_ADDRESS = "";
	private static final String GET_HOSTNAME = "";

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		
		if ("getIPAddress".equals(action)) {
			getIPAddress(callbackContext);
			return true;
		} else if ("getHostName".equals(action)) {
			getHostName(callbackContext);
			return true;
		}

		return false;
	}

	public void getIPAddress() {

		final CallbackContext _callbackContext = callbackContext;

		InetAddress ip;

		try {
            ip = InetAddress.getLocalHost();
            _callbackContext.success(ip);
        } catch (UnknownHostException e) {
        	_callbackContext.error("Error while calling ''" + action + "' '" + e.getMessage());
        }
	}

	public void getHostName() {

		final CallbackContext _callbackContext = callbackContext;

		InetAddress ip;
		String hostname;

		try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            _callbackContext.success(hostname);
        } catch (UnknownHostException e) {
        	_callbackContext.error("Error while calling ''" + action + "' '" + e.getMessage());
        }
	}
}
