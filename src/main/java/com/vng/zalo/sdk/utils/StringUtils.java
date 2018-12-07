/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nghiadc
 */
public class StringUtils {

    public static Map<String, String> splitQuery(String query) throws UnsupportedEncodingException {
        Map<String, String> query_pairs = new LinkedHashMap<String, String>();
        String[] pairs = query.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
        }
        return query_pairs;
    }

    public static String join(List<?> collection, String parten) {
        StringBuilder result = new StringBuilder();
        if (collection != null) {
            for (int i = 0; i < collection.size(); i++) {
                if (i == 0) {
                    result.append(collection.get(i));
                } else {
                    result.append(parten).append(collection.get(i));
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        List<Long> ads = Arrays.asList(124124121251l, 214124125l);
        String join = join(ads, ",");
        System.out.println(join);

    }
}
