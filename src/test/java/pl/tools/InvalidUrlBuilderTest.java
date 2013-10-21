package pl.tools;

import org.testng.annotations.Test;

/**
 * @author Pier-Luc Caron St-Pierre <pierluc.caronstpierre@gmail.com>
 */
public class InvalidUrlBuilderTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void noProtocol() {
        UrlBuilder.from("google.com");
    }
}
