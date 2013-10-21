package pl.tools;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;

/**
 * @author Pier-Luc Caron St-Pierre <pierluc.caronstpierre@gmail.com>
 */
public class ValidUrlBuilderTest {

    @Test
    public void validHttpUrl() {
        URL url = UrlBuilder.from("http://google.com");

        Assert.assertEquals(url.getProtocol(), "http");
        Assert.assertEquals(url.getHost(), "google.com");
        Assert.assertEquals(url.getPort(), -1);
        Assert.assertEquals(url.getDefaultPort(), 80);
    }

    @Test
    public void validHttpsUrl() {
        URL url = UrlBuilder.from("https://google.com");

        Assert.assertEquals(url.getProtocol(), "https");
        Assert.assertEquals(url.getHost(), "google.com");
        Assert.assertEquals(url.getPort(), -1);
        Assert.assertEquals(url.getDefaultPort(), 443);
    }

    @Test
    public void otherPort() {
        URL url = UrlBuilder.from("http://google.com:754");

        Assert.assertEquals(url.getProtocol(), "http");
        Assert.assertEquals(url.getHost(), "google.com");
        Assert.assertEquals(url.getPort(), 754);
        Assert.assertEquals(url.getDefaultPort(), 80);
    }
}
