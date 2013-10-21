package pl.tools;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Pier-Luc Caron St-Pierre <pierluc.caronstpierre@gmail.com>
 */
public class HttpGoogleTest {

    @Test
    public void testHttp() throws MalformedURLException {
        HttpTester httpTester = new HttpTester(new URL("http://google.com"));
        Assert.assertTrue(httpTester.execute());
    }

    @Test
    public void testHttps() throws MalformedURLException {
        HttpTester httpTester = new HttpTester(new URL("https://google.com"));
        Assert.assertTrue(httpTester.execute());
    }
}
