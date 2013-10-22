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
