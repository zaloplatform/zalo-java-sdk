package v3;

import com.google.gson.JsonArray;
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
public class SendBroadcastMessage {

    public static void main(String[] args) throws APIException {
        ZaloOaClient client = new ZaloOaClient();
        String access_token = "your_access_token";

        Map<String, String> headers = new HashMap<>();
        headers.put("access_token", access_token);
        
        JsonObject element = new JsonObject();
        element.addProperty("media_type", "article");
        element.addProperty("attachment_id", "4402c73f7e7a9724ce6b");
        
        JsonArray elements = new JsonArray();
        elements.add(element);
        
        JsonObject payload = new JsonObject();
        payload.add("elements", elements);
        payload.addProperty("template_type", "media");
        
        JsonObject attachment = new JsonObject();
        attachment.addProperty("type", "template");
        attachment.add("payload", payload);
        
        JsonObject message = new JsonObject();
        message.add("attachment", attachment);
        
        JsonObject target = new JsonObject();
        target.addProperty("ages", 3);
        target.addProperty("gender", 1);
        target.addProperty("locations", 2);
        target.addProperty("cities", 4);
        target.addProperty("platform", 1);

        JsonObject recipient = new JsonObject();
        recipient.add("target", target);

        JsonObject body = new JsonObject();
        body.add("recipient", recipient);
        body.add("message", message);
        System.err.println(body);

        JsonObject excuteRequest = client.excuteRequest("https://openapi.zalo.me/v2.0/oa/message", "POST", null, body, headers, null);

        System.err.println(excuteRequest);

        System.exit(0);
    }
}
