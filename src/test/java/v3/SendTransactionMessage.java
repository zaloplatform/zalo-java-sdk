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
public class SendTransactionMessage {

    public static void main(String[] args) throws APIException {
        ZaloOaClient client = new ZaloOaClient();
        String access_token = "your_access_token";

        Map<String, String> headers = new HashMap<>();
        headers.put("access_token", access_token);
        
        JsonObject element1 = new JsonObject();
        element1.addProperty("type", "banner");
        element1.addProperty("image_url", "https://stc-developers.zdn.vn/images/bg_1.jpg");
        
        JsonObject element2 = new JsonObject();
        element2.addProperty("type", "header");
        element2.addProperty("align", "left");
        element2.addProperty("content", "Trạng thái đơn hàng");
        
        JsonObject element3 = new JsonObject();
        element3.addProperty("type", "text");
        element3.addProperty("align", "left");
        element3.addProperty("content", "• Cảm ơn bạn đã mua hàng tại cửa hàng.<br>• Thông tin đơn hàng của bạn như sau:");
        
        JsonObject content1 = new JsonObject();
        content1.addProperty("key", "Mã khách hàng");
        content1.addProperty("value", "F-01332973223");
        
        JsonObject content2 = new JsonObject();
        content2.addProperty("key", "Trạng thái");
        content2.addProperty("value", "Đang giao");
        content2.addProperty("style", "yellow");
        
        JsonObject content3 = new JsonObject();
        content3.addProperty("key", "Giá tiền");
        content3.addProperty("value", "250,000đ");
        
        JsonArray content = new JsonArray();
        content.add(content1);
        content.add(content2);
        content.add(content3);
        
        JsonObject element4 = new JsonObject();
        element4.addProperty("type", "table");
        element4.add("content", content);
        
        JsonObject element5 = new JsonObject();
        element5.addProperty("type", "text");
        element5.addProperty("align", "center");
        element5.addProperty("content", "Lưu ý điện thoại. Xin cảm ơn!");
        
        JsonArray elements = new JsonArray();
        elements.add(element1);
        elements.add(element2);
        elements.add(element3);
        elements.add(element4);
        elements.add(element5);
        
        JsonObject payloadButton1 = new JsonObject();
        payloadButton1.addProperty("url", "https://oa.zalo.me/home");
        
        JsonObject button1 = new JsonObject();
        button1.add("payload", payloadButton1);
        button1.addProperty("image_icon", "https://stc-developers.zdn.vn/images/bg_1.jpg");
        button1.addProperty("title", "Kiểm tra lộ trình - default icon");
        button1.addProperty("type", "oa.open.url");
        
        JsonObject button2 = new JsonObject();
        button2.addProperty("payload", "kiểm tra giỏ hàng");
        button2.addProperty("image_icon", "https://stc-developers.zdn.vn/images/bg_1.jpg");
        button2.addProperty("title", "Xem lại giỏ hàng");
        button2.addProperty("type", "oa.query.show");
        
        JsonObject payloadButton3 = new JsonObject();
        payloadButton3.addProperty("phone_code", "84123456789");
        
        JsonObject button3 = new JsonObject();
        button3.add("payload", payloadButton3);
        button3.addProperty("image_icon", "https://stc-developers.zdn.vn/images/bg_1.jpg");
        button3.addProperty("title", "Liên hệ tổng đài");
        button3.addProperty("type", "oa.open.phone");
        
        JsonArray buttons = new JsonArray();
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        
        JsonObject payload = new JsonObject();
        payload.add("elements", elements);
        payload.add("buttons", buttons);
        payload.addProperty("template_type", "transaction_order");
        payload.addProperty("language", "VI");
        
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

        JsonObject excuteRequest = client.excuteRequest("https://openapi.zalo.me/v3.0/oa/message/transaction", "POST", null, body, headers, null);

        System.err.println(excuteRequest);

        System.exit(0);
    }
}
