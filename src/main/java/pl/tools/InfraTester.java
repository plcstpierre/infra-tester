/*
 *
 *  * (C) Copyright 2013 Pier-Luc Caron St-Pierre
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *  *
 */

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
