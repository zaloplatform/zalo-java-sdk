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
public class SendRequestUserInfoCSMessage {

    public static void main(String[] args) throws APIException {
        ZaloOaClient client = new ZaloOaClient();
        String access_token = "your_access_token";

        Map<String, String> headers = new HashMap<>();
        headers.put("access_token", access_token);
        
        JsonObject element = new JsonObject();
        element.addProperty("image_url", "https://developers.zalo.me/web/static/zalo.png");
        element.addProperty("title", "Official Account");
        element.addProperty("subtitle", "Đang yêu cầu thông tin từ bạn");
        
        JsonArray elements = new JsonArray();
        elements.add(element);
        
        JsonObject payload = new JsonObject();
        payload.add("elements", elements);
        payload.addProperty("template_type", "request_user_info");
        
        JsonObject attachment = new JsonObject();
        attachment.addProperty("type", "template");
        attachment.add("payload", payload);
        
        JsonObject message = new JsonObject();
        message.add("attachment", attachment);

        JsonObject recipient = new JsonObject();
        recipient.addProperty("user_id", "2468458835296197922");

        JsonObject body = new JsonObject();
        body.add("recipient", recipient);
        body.add("message", message);
        System.err.println(body);

        JsonObject excuteRequest = client.excuteRequest("https://openapi.zalo.me/v3.0/oa/message/cs", "POST", null, body, headers, null);

        System.err.println(excuteRequest);

        System.exit(0);
    }
}
