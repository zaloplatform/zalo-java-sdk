package v3;

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
public class SendTextCSMessage {

    public static void main(String[] args) throws APIException {
        ZaloOaClient client = new ZaloOaClient();
        String access_token = "your_access_token";

        Map<String, String> headers = new HashMap<>();
        headers.put("access_token", access_token);

        JsonObject recipient = new JsonObject();
        recipient.addProperty("user_id", "2468458835296197922");

        JsonObject text = new JsonObject();
        text.addProperty("text", "text_message");

        JsonObject body = new JsonObject();
        body.add("recipient", recipient);
        body.add("message", text);
        System.err.println(body);

        JsonObject excuteRequest = client.excuteRequest("https://openapi.zalo.me/v3.0/oa/message/cs", "POST", null, body, headers, null);

        System.err.println(excuteRequest);

        System.exit(0);
    }
}
