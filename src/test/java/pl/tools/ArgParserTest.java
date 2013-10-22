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
