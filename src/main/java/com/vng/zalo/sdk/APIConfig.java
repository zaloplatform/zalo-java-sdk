/**
 * Copyright (c) 2017-present, VNG Zalo, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary form
 * for use in connection with the web services and APIs provided by Zalo.
 *
 * As with any software that integrates with the Zalo platform, your use of this
 * software is subject to the Zalo Developer Principles and Policies
 * [http://developers.zaloapp.com/policy/]. This copyright notice shall be included
 * in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */
/**
 *
 * @author nghiadc@vng.com.vn
 */
package com.vng.zalo.sdk;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class APIConfig {

    public static final String DEFAULT_OA_API_VERSION = "v2.0";
    public static final String DEFAULT_3RDAPP_API_VERSION = "v2.0";
    public static final String DEFAULT_OA_API_BASE = "https://openapi.zaloapp.com/";

    public static final String USER_AGENT = "zalosdk/4.0 Zalo Open API Java SDK";
    public static final String SDK_VERSION = "Java 4.0";
    public static final String SDK_SOURCE = "JavaSDK-4.0";
    public static final Map<String, String> DEFAULT_HEADER = createDefaultHeader();
    public static String TEMPORARY_DIR = null;

    public static Map<String, String> createDefaultHeader() {
        Map<String, String> map = new HashMap<>();
        map.put("User-Agent", USER_AGENT);
        map.put("SDK_VERSION", SDK_VERSION);
        map.put("SDK-Source", SDK_SOURCE);
        return map;
    }

    public static void setTempDir(String dir) throws APIException {
        File file = new File(dir);
        if (file.isDirectory()) {
            try {
                TEMPORARY_DIR = file.getCanonicalPath();
                return;
            } catch (IOException ex) {
                throw new APIException(ex);
            }
        }
        throw new APIException(String.format("%s is not directory", dir));
    }
};
