# Cordova Plugin Network Interface

Very self-explanatory. Allows you to get the ip address and hostname of an Android device via Cordova.

# API

## Get Functions

`success` is a callback called to return the response.

`error` is a callback called if anything goes wrong. (Optional)

```js
// Get the client IP Address
window.networkInterface.getIPAddress(success, error);

// Get the client Hostname
window.networkInterface.getHostName(success, error);
```
