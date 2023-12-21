/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author hienhh
 */
public class AppSecretProofUtil {

    private AppSecretProofUtil() {
    }

    public static final AppSecretProofUtil Instance = new AppSecretProofUtil();
    
    public static final String ALGORITHM = "HmacSHA256";

    public static String calculateHMacSHA256(String key, String data) throws Exception {
        Mac sha256_HMAC = Mac.getInstance(ALGORITHM);

        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), ALGORITHM);
        sha256_HMAC.init(secret_key);

        return Hex.encodeHexString(sha256_HMAC.doFinal(data.getBytes("UTF-8")));
    }

    public static void main(String[] args) throws Exception {
        String appSecretKey = "appSecretKey";
        String accessToken = "accessToken";
        
        System.out.println(calculateHMacSHA256(appSecretKey, accessToken));
        
        System.exit(0);
    }
    
}
