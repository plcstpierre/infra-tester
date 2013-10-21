package pl.tools;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Pier-Luc Caron St-Pierre <pierluc.caronstpierre@gmail.com>
 */
public class HttpTester {
    private final URL url;

    public HttpTester(URL url) {
        this.url = url;
    }

    public boolean execute() {
        HttpURLConnection httpURLConnection = null;

        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            return httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK;

        } catch (IOException e) {
            return false;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }
}
