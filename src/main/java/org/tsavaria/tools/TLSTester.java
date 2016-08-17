package org.tsavaria.tools;

import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

/**
 * Tests the connection to an HTTPS service using different SSL Protocols
 * Refer to https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#SSLContext for the list of valid protocols you can use
 * If an exception is thrown, prints the exception and the message in the error stream
 * If the request has been completed, prints the status of the requests in the output stream
 * 
 * @author Tommy Savaria
 */
public class TLSTester {
	private final URL url;
	private final String[] protocols;
	
	public TLSTester(String[] args) throws MalformedURLException, IllegalArgumentException
	{
		if(args.length != 2)
			throw new IllegalArgumentException("Invalid argument count");
		
		url = new URL(args[0]);
		protocols = args[1].split(":");
	}
	
	public void execute()
	{
		for(String protocol: protocols)
			tlsTest(protocol);
	}
	
	private void tlsTest(String protocol)
	{
		HttpsURLConnection httpsURLConnection = null;        
        
        try
		{
        	SSLContext ctx = SSLContext.getInstance(protocol);
        	ctx.init(null, null, null);
			HttpsURLConnection.setDefaultSSLSocketFactory(ctx.getSocketFactory());
			httpsURLConnection = (HttpsURLConnection) url.openConnection();
			System.out.println(protocol + ": " + httpsURLConnection.getResponseCode() + ": " + httpsURLConnection.getResponseMessage());
		} catch (Exception e) {
			System.err.println(protocol + ": " + "Error opening connection: " + e.getMessage());
			return;
		} finally {
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            } 
		}
	}
}
