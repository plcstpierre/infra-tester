package pl.tools;

import java.net.URL;

/**
 * @author Pier-Luc Caron St-Pierre <pierluc.caronstpierre@gmail.com>
 */
public class InfraTester {

    private final String[] args;

    public InfraTester(String[] args) {
        this.args = args;
    }

    public void execute() {

        URL url;

        try {
            ArgParser argParser = new ArgParser(args);
            url = argParser.parse();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());

            printHelp();
            System.exit(-2);
            return;
        }


        HttpTester httpTester = new HttpTester(url);

        if (! httpTester.execute()) {
            System.out.println("Test failed for url " + url);
            System.exit(-1);
        } else {
            System.out.println("Test succeeded for url " + url);
        }

    }

    private void printHelp() {
        System.out.println("Usage: infratester <url>");
        System.out.println("Sample: infratester http://google.com");
    }
}
