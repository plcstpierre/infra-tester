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
