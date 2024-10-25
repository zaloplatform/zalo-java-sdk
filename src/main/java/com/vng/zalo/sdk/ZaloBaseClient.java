/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk;

import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author nghiadc
 */
public class ZaloBaseClient {

    protected boolean isUseProxy = false;
    protected static final int CONNECTION_TIMEOUT = 2000;
    protected static final int READ_TIMEOUT = 15000;
    protected RequestConfig config = null;

    public void setIsUseProxy(boolean useProxy) {
        this.isUseProxy = useProxy;
    }

    public void setProxy(String host, int port) {
        this.isUseProxy = true;
        HttpHost proxy = new HttpHost(host, port);
        config = RequestConfig.custom().setSocketTimeout(READ_TIMEOUT + CONNECTION_TIMEOUT)
                .setConnectTimeout(CONNECTION_TIMEOUT)
                .setConnectionRequestTimeout(READ_TIMEOUT)
                .setProxy(proxy)
                .build();
    }

    protected String sendHttpGetRequest(String enpointUrl, Map<String, String> params, Map<String, String> header) throws APIException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            try {

                URIBuilder builder = new URIBuilder(enpointUrl);
                if (params != null) {
                    for (Map.Entry<String, String> entry : params.entrySet()) {
                        builder.addParameter(entry.getKey(), entry.getValue());
                    }
                }
                HttpGet httpget = new HttpGet(builder.toString());
                if (isUseProxy) {
                    httpget.setConfig(config);
                }
                if (header != null) {
                    for (Map.Entry<String, String> entry : header.entrySet()) {
                        httpget.addHeader(entry.getKey(), entry.getValue());
                    }
                }
                CloseableHttpResponse response = httpclient.execute(httpget);
                try {
                    HttpEntity entity = response.getEntity();
                    String rs = EntityUtils.toString(entity);

                    StatusLine statusLine = response.getStatusLine();

                    return rs;
                } finally {
                    response.close();
                }
            } catch (IOException ex) {
                throw new APIException(ex);
            } finally {
                httpclient.close();
            }
        } catch (Exception ex) {
            throw new APIException(ex);
        }
    }

    protected String sendHttpPostRequest(String enpointUrl, Map<String, String> params, JsonObject data, Map<String, String> header) throws APIException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            try {
                URIBuilder builder = new URIBuilder(enpointUrl);

                if (params != null) {
                    for (Map.Entry<String, String> entry : params.entrySet()) {
                        builder.addParameter(entry.getKey(), entry.getValue());
                    }
                }
                HttpPost httpPost = new HttpPost(builder.toString());
                if (isUseProxy) {
                    httpPost.setConfig(config);
                }
                if (header != null) {
                    for (Map.Entry<String, String> entry : header.entrySet()) {
                        httpPost.addHeader(entry.getKey(), entry.getValue());
                    }
                }

                if (data != null) {
                    httpPost.setEntity(new StringEntity(data.toString(), ContentType.APPLICATION_JSON));
                }
                CloseableHttpResponse response = httpclient.execute(httpPost);
                try {
                    HttpEntity entity = response.getEntity();
                    return EntityUtils.toString(entity);
                } finally {
                    response.close();
                }
            } catch (IOException ex) {
                throw new APIException(ex);
            } finally {
                httpclient.close();
            }
        } catch (APIException | IOException | ParseException | URISyntaxException ex) {
            throw new APIException(ex);
        }
    }

    protected String sendHttpUploadRequest(String enpointUrl, File file, Map<String, String> params, Map<String, String> header) throws APIException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            try {
                CloseableHttpClient httpClient = HttpClients.createDefault();
                URIBuilder builder = new URIBuilder(enpointUrl);

                if (params != null) {
                    for (Map.Entry<String, String> entry : params.entrySet()) {
                        builder.addParameter(entry.getKey(), entry.getValue());
                    }
                }
                HttpPost uploadFile = new HttpPost(builder.toString());

                if (isUseProxy) {
                    uploadFile.setConfig(config);
                }
                if (header != null) {
                    for (Map.Entry<String, String> entry : header.entrySet()) {
                        uploadFile.addHeader(entry.getKey(), entry.getValue());
                    }
                }

                MultipartEntityBuilder Mulbuilder = MultipartEntityBuilder.create();
//                for (Map.Entry<String, String> entry : params.entrySet()) {
//                    builder.addTextBody(entry.getKey(), entry.getValue(), ContentType.TEXT_PLAIN);
//                }
                // This attaches the file to the POST:
                Mulbuilder.addBinaryBody(
                        "file",
                        new FileInputStream(file),
                        ContentType.MULTIPART_FORM_DATA,
                        file.getName()
                );
                HttpEntity multipart = Mulbuilder.build();
                uploadFile.setEntity(multipart);
                CloseableHttpResponse response = httpClient.execute(uploadFile);
                try {
                    HttpEntity entity = response.getEntity();
                    return EntityUtils.toString(entity);
                } finally {
                    response.close();
                }

            } catch (IOException ex) {
                throw new APIException(ex);
            } catch (URISyntaxException ex) {
                throw new APIException(ex);
            } finally {
                httpclient.close();
            }
        } catch (APIException | IOException | ParseException ex) {
            throw new APIException(ex);
        }
    }

    protected String sendHttpUploadRequest(String enpointUrl, Map<String, File> files, Map<String, String> params, Map<String, String> header) throws APIException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            try {
                CloseableHttpClient httpClient = HttpClients.createDefault();
                URIBuilder builder = new URIBuilder(enpointUrl);

                if (params != null) {
                    for (Map.Entry<String, String> entry : params.entrySet()) {
                        builder.addParameter(entry.getKey(), entry.getValue());
                    }
                }
                HttpPost uploadFile = new HttpPost(builder.toString());

                if (isUseProxy) {
                    uploadFile.setConfig(config);
                }
                if (header != null) {
                    for (Map.Entry<String, String> entry : header.entrySet()) {
                        uploadFile.addHeader(entry.getKey(), entry.getValue());
                    }
                }

                MultipartEntityBuilder Mulbuilder = MultipartEntityBuilder.create();
//                for (Map.Entry<String, String> entry : params.entrySet()) {
//                    builder.addTextBody(entry.getKey(), entry.getValue(), ContentType.TEXT_PLAIN);
//                }
                // This attaches the file to the POST:
                for (String key : files.keySet()) {
                    File value = files.getOrDefault(key, null);
                    if (value != null) {
                        Mulbuilder.addBinaryBody(
                                key,
                                new FileInputStream(value),
                                ContentType.MULTIPART_FORM_DATA,
                                value.getName()
                        );
                    }
                }

                HttpEntity multipart = Mulbuilder.build();
                uploadFile.setEntity(multipart);
                CloseableHttpResponse response = httpClient.execute(uploadFile);
                try {
                    HttpEntity entity = response.getEntity();
                    return EntityUtils.toString(entity);
                } finally {
                    response.close();
                }

            } catch (IOException ex) {
                throw new APIException(ex);
            } catch (URISyntaxException ex) {
                throw new APIException(ex);
            } finally {
                httpclient.close();
            }
        } catch (APIException | IOException | ParseException ex) {
            throw new APIException(ex);
        }
    }

    protected String sendHttpPostWithUrlencodedRequest(String enpointUrl, Map<String, String> params, Map<String, String> header, Map<String, String> body) throws APIException {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        try {
            try {
                CloseableHttpClient httpClient = HttpClients.createDefault();
                URIBuilder builder = new URIBuilder(enpointUrl);

                HttpPost sendMethodPost = new HttpPost(builder.toString());

                if (header != null) {
                    for (Map.Entry<String, String> entry : header.entrySet()) {
                        sendMethodPost.addHeader(entry.getKey(), entry.getValue());
                    }
                }

                List<NameValuePair> bodyList = new ArrayList<>();
                for (String key : body.keySet()) {
                    bodyList.add(new BasicNameValuePair(key, body.get(key)));
                }

                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(bodyList);
                sendMethodPost.setEntity(urlEncodedFormEntity);
                CloseableHttpResponse response = httpClient.execute(sendMethodPost);
                try {
                    HttpEntity entity = response.getEntity();
                    return EntityUtils.toString(entity);
                } finally {
                    response.close();
                }

            } catch (IOException ex) {
                throw new APIException(ex);
            } catch (URISyntaxException ex) {
                throw new APIException(ex);
            } finally {
                httpclient.close();
            }
        } catch (APIException | IOException | ParseException ex) {
            throw new APIException(ex);
        }
    }
}
