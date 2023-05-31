package v3;


import com.google.gson.JsonObject;
import com.vng.zalo.sdk.APIException;
import com.vng.zalo.sdk.oa.ZaloOaClient;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hien
 */
public class UploadFile {

    public static void main(String[] args) throws APIException {
        ZaloOaClient client = new ZaloOaClient();
        String access_token = "your_access_token";

        Map<String, String> headers = new HashMap<>();
        headers.put("access_token", access_token);

        Map<String, File> files = new HashMap<>();
        File file = new File("/home/lap13561/Pictures/Screenshot from 2022-08-09 15-04-06.png");
        files.put("file", file);

        JsonObject excuteRequest = client.excuteRequest("https://dev-openapi.zalo.me/v2.0/oa/upload/file", "POST", null, null, headers, files);

        System.err.println(excuteRequest);

        System.exit(0);

    }
}
