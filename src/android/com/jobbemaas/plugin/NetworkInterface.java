package com.jobbemaas.plugin;

import android.test.InstrumentationTestCase;
import android.util.Log;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.NetworkInterface;
import java.util.Enumeration;

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
		private static final String TAG = NetworkInterfaceTest.class.getSimpleName();
		
		Enumeration<NetworkInterface> it_ni = NetworkInterface.getNetworkInterfaces();
		
		while (it_ni.hasMoreElements()) {
		    NetworkInterface ni = it_ni.nextElement();
		    Enumeration<InetAddress> it_ia = ni.getInetAddresses();
		    if (it_ia.hasMoreElements()) {
				Log.i(TAG, "++ NI:   " + ni.getDisplayName());
				while (it_ia.hasMoreElements()) {
				    InetAddress ia = it_ia.nextElement();
				    Log.i(TAG, "-- IA:   " + ia.getCanonicalHostName());
				    Log.i(TAG, "-- host: " + ia.getHostAddress());
				}
		    }
		}

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
