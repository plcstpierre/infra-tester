package pl.tools;

/**
 * @author Pier-Luc Caron St-Pierre <pierluc.caronstpierre@gmail.com>
 */
public class InfraTesterBooter {

    public static void main(String[] args) {
        InfraTester infraTester = new InfraTester(args);
        infraTester.execute();
    }
}
