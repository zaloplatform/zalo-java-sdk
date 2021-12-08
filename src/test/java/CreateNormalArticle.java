
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
public class CreateNormalArticle {

    public static void main(String[] args) throws APIException {
        ZaloOaClient client = new ZaloOaClient();
        String access_token = "-4Mu8v7-2Y_zJxWjdVWEBlH8iIAQvM5Pd1IJC-ZUBK744Cq_-iKcLS8UbHlPz65nqHMK9Fdc85l3K_uAxgP9T_HVjIIQf6HDb1NI4xcYEaMcJ-jCYU4l9ECZtsICrs4Jf025UR_aRJMkBTr1slbs7kWpadx7mI0Gt73SG_6_61tITEjYnS816wKAonIJ_YKNW3B7OE7Q9G2C6ljNcQmG9_XQ-YNecXfTstNOAkREFNhwAz4BnPbdTCvEX1tIlZDkkdhiUTJC4Zh_ECTQzD0iJTeMooxvunH5x3R66Vo21nLjMOE6EfBe3Iy";
        
        Map<String, String> headers = new HashMap<>();
        headers.put("access_token", access_token);

        JsonObject photoCover = new JsonObject();
        photoCover.addProperty("cover_type", "photo");
        photoCover.addProperty("photo_url", "https://stc-developers.zdn.vn/images/bg_1.jpg");
        photoCover.addProperty("status", "show");

        JsonObject textParagraph = new JsonObject();
        textParagraph.addProperty("type", "text");
        textParagraph.addProperty("content", "content");

        JsonObject imageParagraph = new JsonObject();
        imageParagraph.addProperty("type", "image");
        imageParagraph.addProperty("url", "https://stc-developers.zdn.vn/images/bg_1.jpg");
        imageParagraph.addProperty("caption", "caption");

        JsonObject videoParagraph = new JsonObject();
        videoParagraph.addProperty("type", "video");
        videoParagraph.addProperty("url", "https://www.youtube.com/watch?v=mY4l5C5DDEE");
        videoParagraph.addProperty("thumb", "https://stc-developers.zdn.vn/images/bg_1.jpg");

        JsonArray body = new JsonArray();
        body.add(textParagraph);
        body.add(imageParagraph);
        body.add(videoParagraph);

        JsonObject normalArticle = new JsonObject();
        normalArticle.addProperty("type", "normal");
        normalArticle.addProperty("title", "article test");
        normalArticle.addProperty("author", "Huỳnh Hồng Hiển");
        normalArticle.add("cover", photoCover);
        normalArticle.addProperty("description", "article test");
        normalArticle.add("body", body);
        normalArticle.addProperty("status", "hide");
        normalArticle.addProperty("comment", "show");

        JsonObject excuteRequest = client.excuteRequest("https://openapi.zalo.me/v2.0/article/create", "POST", null, normalArticle, headers, null);
        
        System.err.println(excuteRequest);
        
        System.exit(0);
    }
}
