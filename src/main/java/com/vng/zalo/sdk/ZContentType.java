/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk;

/**
 *
 * @author linhndh
 */
public enum ZContentType {

    APPLICATION_PDF("application/pdf"),
    APPLICATION_DOC("application/msword"),
    APPLICATION_XLS("application/vnd.ms-excel"),
    APPLICATION_XLSX("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
    APPLICATION_DOCX("application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
    MULTIPART_FORMDATA("multipart/form-data");

    private String value;

    private ZContentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public ZContentType findByValue(String type) {
        for (ZContentType ctype : ZContentType.values()) {
            if (type.equals(ctype)) {
                return ctype;
            }
        }
        return MULTIPART_FORMDATA;
    }
}
