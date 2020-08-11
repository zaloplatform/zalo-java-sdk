/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.oa;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.vng.zalo.sdk.APIConfig;
import com.vng.zalo.sdk.APIException;
import com.vng.zalo.sdk.ZContentType;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import com.vng.zalo.sdk.ZaloBaseClient;
import org.apache.http.entity.ContentType;

/**
 *
 * @author hienhh
 */
public class ZaloOaClient extends ZaloBaseClient {

    public ZaloOaClient() {
    }

    public JsonObject excuteRequest(String endPoint, String method, Map<String, Object> params, JsonObject bodyData) throws APIException {
        File file = null;
        Map<String, String> sortedMap = new TreeMap<>();
        if (params == null) {
            params = new HashMap<>();
        }
        for (Map.Entry<String, Object> entrySet : params.entrySet()) {
            String key = entrySet.getKey();
            Object value = entrySet.getValue();
            if (value instanceof File) {
                file = (File) value;
            } else {
                sortedMap.put(key, value.toString());
            }
        }

        String response;
        if (file != null) {
            response = sendHttpUploadRequest(endPoint, file, sortedMap, APIConfig.DEFAULT_HEADER);
        } else {
            if ("GET".equals(method.toUpperCase())) {
                response = sendHttpGetRequest(endPoint, sortedMap, APIConfig.DEFAULT_HEADER);
            } else {
                response = sendHttpPostRequest(endPoint, sortedMap, bodyData, APIConfig.DEFAULT_HEADER);
            }
        }
        JsonObject result = null;
        try {
            JsonParser parser = new JsonParser();
            result = parser.parse(response).getAsJsonObject();
        } catch (JsonSyntaxException e) {
            throw new APIException("Response is not json: " + response);
        }
        return result;
    }

    /**
     * Support upload file with content-type
     * @param contentType
     * @param endPoint
     * @param method
     * @param params
     * @param bodyData
     * @return
     * @throws APIException 
     */
    public JsonObject excuteRequest(ZContentType contentType, String endPoint, String method, Map<String, Object> params, JsonObject bodyData) throws APIException {
        File file = null;
        Map<String, String> sortedMap = new TreeMap<>();
        if (params == null) {
            params = new HashMap<>();
        }
        for (Map.Entry<String, Object> entrySet : params.entrySet()) {
            String key = entrySet.getKey();
            Object value = entrySet.getValue();
            if (value instanceof File) {
                file = (File) value;
            } else {
                sortedMap.put(key, value.toString());
            }
        }

        String response;
        if (file != null) {
            ContentType ctype = ContentType.MULTIPART_FORM_DATA;
            if (contentType != ZContentType.MULTIPART_FORMDATA) {
                ctype = ContentType.create(contentType.getValue());
            }
            response = sendHttpUploadRequest(ctype, endPoint, file, sortedMap, APIConfig.DEFAULT_HEADER);
        } else {
            if ("GET".equals(method.toUpperCase())) {
                response = sendHttpGetRequest(endPoint, sortedMap, APIConfig.DEFAULT_HEADER);
            } else {
                response = sendHttpPostRequest(endPoint, sortedMap, bodyData, APIConfig.DEFAULT_HEADER);
            }
        }
        JsonObject result = null;
        try {
            JsonParser parser = new JsonParser();
            result = parser.parse(response).getAsJsonObject();
        } catch (JsonSyntaxException e) {
            throw new APIException("Response is not json: " + response);
        }
        return result;
    }
}
