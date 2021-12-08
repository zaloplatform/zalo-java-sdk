
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
public class UpdateVideoArticle {

    public static void main(String[] args) throws APIException {
        ZaloOaClient client = new ZaloOaClient();
        String access_token = "your_access_token";

        Map<String, String> headers = new HashMap<>();
        headers.put("access_token", access_token);

        JsonObject videoArticle = new JsonObject();
        videoArticle.addProperty("id", "article_id");
        videoArticle.addProperty("type", "video");
        videoArticle.addProperty("title", "article test");
        videoArticle.addProperty("description", "description");
        videoArticle.addProperty("video_id", "video_id");
        videoArticle.addProperty("avatar", "https://developers.zalo.me/web/static/zalo.png");
        videoArticle.addProperty("comment", "show");

        JsonObject excuteRequest = client.excuteRequest("https://openapi.zalo.me/v2.0/article/update", "POST", null, videoArticle, headers, null);

        System.err.println(excuteRequest);

        System.exit(0);
    }
}
