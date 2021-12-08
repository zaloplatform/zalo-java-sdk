
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
public class SendListMessage {

    public static void main(String[] args) throws APIException {
        ZaloOaClient client = new ZaloOaClient();
        String access_token = "your_access_token";
        
        Map<String, String> headers = new HashMap<>();
        headers.put("access_token", access_token);

        JsonObject default_action3 = new JsonObject();
        default_action3.addProperty("type", "oa.open.url");
        default_action3.addProperty("url", "https://media.zalo.me/detail/579745863508352884?zl3rd=815789662550058820&id=7befc604ed41041f5d50&zarsrc=4");

        JsonObject element3 = new JsonObject();
        element3.addProperty("title", "Zalo Hackathon 2017");
        element3.addProperty("subtitle", "your_description");
        element3.addProperty("image_url", "https://zalo-article-photo-td.zadn.vn/3627ee9529d0c08e99c1#16472239");
        element3.add("default_action", default_action3);

        JsonObject default_action2 = new JsonObject();
        default_action2.addProperty("type", "oa.open.url");
        default_action2.addProperty("url", "https://media.zalo.me/detail/579745863508352884?zl3rd=815789662550058820&id=155afc84d9c1309f69d0&zarsrc=4");

        JsonObject element2 = new JsonObject();
        element2.addProperty("title", "Zalo SDK - Tích hợp để phát triển !");
        element2.addProperty("subtitle", "your_description");
        element2.addProperty("image_url", "https://zalo-article-photo-td.zadn.vn/bbef0e611225fb7ba234#18900249");
        element2.add("default_action", default_action2);

        JsonObject default_action1 = new JsonObject();
        default_action1.addProperty("type", "oa.query.show");
        default_action1.addProperty("payload", "Huynh Hong hien");

        JsonObject element1 = new JsonObject();
        element1.addProperty("title", "ZALO API: Cập nhật API phiên bản mới");
        element1.addProperty("subtitle", "Zalo đang cập nhật một số API mới để hỗ trợ các đối tác và lập trình viên tốt hơn trong việc tích hợp với nền tảng Zalo & kinh doanh trên Zalo Shop.");
        element1.addProperty("image_url", "https://zalo-article-photo-td.zadn.vn/70d8db827dc69498cdd7#26915261");
        element1.add("default_action", default_action1);

        JsonArray elements = new JsonArray();
        elements.add(element1);
        elements.add(element2);
        elements.add(element3);

        JsonObject payload = new JsonObject();
        payload.addProperty("template_type", "list");
        payload.add("elements", elements);

        JsonObject attachment = new JsonObject();
        attachment.addProperty("type", "template");
        attachment.add("payload", payload);

        JsonObject message = new JsonObject();
        message.addProperty("text", "your_message");
        message.add("attachment", attachment);

        JsonObject recipient = new JsonObject();
        recipient.addProperty("user_id", "user_id");

        JsonObject body = new JsonObject();
        body.add("recipient", recipient);
        body.add("message", message);

        JsonObject excuteRequest = client.excuteRequest("https://openapi.zalo.me/v2.0/oa/message", "POST", null, body, headers, null);
        
        System.err.println(excuteRequest);
        
        System.exit(0);
    }
}
