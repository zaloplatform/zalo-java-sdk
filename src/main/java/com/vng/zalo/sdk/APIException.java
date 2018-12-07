/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk;

/**
 *
 * @author nghiadc
 */
public class APIException extends Exception {

    int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public APIException(int code, String message) {
        super(message);
        this.code = code;
    }

    public APIException() {
        super();
    }

    public APIException(Throwable e) {
        super(e);
    }

    public APIException(String message) {
        super(message);
    }

    public APIException(String message, Throwable e) {
        super(message, e);
    }

    public String toString() {
        return "error: " + code + " | " + super.getMessage();
    }
}
