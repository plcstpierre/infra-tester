package pl.tools;

import com.google.common.base.Preconditions;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Pier-Luc Caron St-Pierre <pierluc.caronstpierre@gmail.com>
 */
public class UrlBuilder {
    public static URL from(String arg){
        Preconditions.checkNotNull(arg);

        try {
            return new URL(arg);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid url specified: " + arg, e);
        }
    }
}
