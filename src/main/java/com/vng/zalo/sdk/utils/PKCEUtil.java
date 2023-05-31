/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 *
 * @author hienhh
 */
public class PKCEUtil {

    private PKCEUtil() {
    }
    
    public static final PKCEUtil Instance = new PKCEUtil();

    public String genCodeVerifier() {
        SecureRandom sr = new SecureRandom();
        byte[] code = new byte[32];
        sr.nextBytes(code);
        String verifier = Base64.getUrlEncoder().withoutPadding().encodeToString(code);
        return verifier;
    }

    public String genCodeChallenge(String codeVerifier) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String result = null;

        byte[] bytes = codeVerifier.getBytes("US-ASCII");
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(bytes, 0, bytes.length);
        byte[] digest = md.digest();
        result = Base64.getUrlEncoder().withoutPadding().encodeToString(digest);

        return result;
    }
}
