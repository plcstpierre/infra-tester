package pl.tools;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;

/**
 * @author Pier-Luc Caron St-Pierre <pierluc.caronstpierre@gmail.com>
 */
public class ArgParserTest {
    @Test
    public void testUrl() {
        ArgParser argParser = new ArgParser(new String[]{"http://google.com"});
        URL url = argParser.parse();

        Assert.assertNotNull(url);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNull(){
        ArgParser argParser = new ArgParser(null);
        argParser.parse();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testEmpty() {
        ArgParser argParser = new ArgParser(new String[0]);
        argParser.parse();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testMultiple(){
        ArgParser argParser = new ArgParser(new String[]{"http://google.com", "http://google.com"});
        argParser.parse();
    }
}
