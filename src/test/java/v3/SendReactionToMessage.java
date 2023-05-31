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
public class SendReactionToMessage {

    public static void main(String[] args) throws APIException {
        ZaloOaClient client = new ZaloOaClient();
        String access_token = "your_access_token";

        Map<String, String> headers = new HashMap<>();
        headers.put("access_token", access_token);

        JsonObject recipient = new JsonObject();
        recipient.addProperty("user_id", "2468458835296197922");

        JsonObject sender_action = new JsonObject();
        sender_action.addProperty("react_message_id", "6d3771b5c7f5d0a889e7");
        sender_action.addProperty("react_icon", "/-strong");

        JsonObject body = new JsonObject();
        body.add("recipient", recipient);
        body.add("sender_action", sender_action);
        System.err.println(body);

        JsonObject excuteRequest = client.excuteRequest("https://openapi.zalo.me/v2.0/oa/message", "POST", null, body, headers, null);

        System.err.println(excuteRequest);

        System.exit(0);
    }
}
