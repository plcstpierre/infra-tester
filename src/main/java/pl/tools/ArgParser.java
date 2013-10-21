package pl.tools;

import java.net.URL;

/**
 * @author Pier-Luc Caron St-Pierre <pierluc.caronstpierre@gmail.com>
 */
public class ArgParser {
    private final String[] args;

    public ArgParser(String[] args) {
        this.args = args;
    }

    public URL parse() {
        if (args == null || args.length != 1 ){
            throw new IllegalArgumentException("Invalid argument count!");
        }

        return UrlBuilder.from(args[0]);
    }
}
