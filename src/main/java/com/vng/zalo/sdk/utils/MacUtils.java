/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author nghiadc
 */
public class MacUtils {

    public static String buildMac(Object... args) {
        StringBuilder sb = new StringBuilder();
        for (Object p : args) {
            sb.append(p);
        }
        String mac = DigestUtils.sha256Hex(sb.toString());
        return mac;
    }
}
