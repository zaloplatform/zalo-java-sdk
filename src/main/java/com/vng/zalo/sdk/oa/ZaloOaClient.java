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
import com.vng.zalo.sdk.ZaloBaseClient;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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

    public JsonObject excuteRequest(String endPoint, String method, Map<String, Object> params, JsonObject bodyData, Map<String, String> headers, Map<String, File> files) throws APIException {

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

        Map<String, String> headerMap = APIConfig.DEFAULT_HEADER;
        if (headers != null && headers.keySet() != null && headers.keySet().isEmpty() == false) {
            for (String key : headers.keySet()) {
                String value = headers.getOrDefault(key, "");
                headerMap.put(key, value);
            }
        }

        if (files != null && files.keySet() != null && files.keySet().isEmpty() == false) {
            response = sendHttpUploadRequest(endPoint, files, sortedMap, headerMap);
        } else if (file != null) {
            response = sendHttpUploadRequest(endPoint, file, sortedMap, headerMap);
        } else {
            if ("GET".equals(method.toUpperCase())) {
                response = sendHttpGetRequest(endPoint, sortedMap, headerMap);
            } else {
                response = sendHttpPostRequest(endPoint, sortedMap, bodyData, headerMap);
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
