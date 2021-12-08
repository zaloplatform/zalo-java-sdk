
import com.google.gson.JsonObject;
import com.vng.zalo.sdk.APIException;
import com.vng.zalo.sdk.oa.ZaloOaClient;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hienhh
 */
public class CheckStatusVideo {
    public static void main(String[] args) throws APIException {
        ZaloOaClient client = new ZaloOaClient();
        String access_token = "your_access_token";
        
        Map<String, String> headers = new HashMap<>();
        headers.put("access_token", access_token);
        headers.put("token", "video_token_get_by_upload_video");
        
        JsonObject excuteRequest = client.excuteRequest("https://openapi.zalo.me/v2.0/article/upload_video/verify", "GET", null, null, headers, null);
        
        System.err.println(excuteRequest);
        
        System.exit(0);
    }
}
