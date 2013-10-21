package pl.tools;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/**
 * @author Pier-Luc Caron St-Pierre <pierluc.caronstpierre@gmail.com>
 */
public class InexistentUrlTest {
    @Test
    public void testInexistentUrl() throws MalformedURLException {
        HttpTester httpTester = new HttpTester(new URL("http://" + UUID.randomUUID() + ".com"));
        Assert.assertFalse(httpTester.execute());
    }
}
