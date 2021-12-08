
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
 * @author hien
 */
public class GetListFollower {

    public static void main(String[] args) throws APIException {
        ZaloOaClient client = new ZaloOaClient();
        String access_token = "your_access_token";
        
        Map<String, String> headers = new HashMap<>();
        headers.put("access_token", access_token);

        JsonObject data = new JsonObject();
        data.addProperty("offset", 0);
        data.addProperty("count", 5);
        
        Map<String, Object> params = new HashMap<>();
        params.put("data", data.toString());

        JsonObject excuteRequest = client.excuteRequest("https://openapi.zalo.me/v2.0/oa/getfollowers", "GET", params, null, headers, null);
        
        System.err.println(excuteRequest);
        
        System.exit(0);
    }
}
