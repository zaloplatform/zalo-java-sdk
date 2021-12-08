
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
public class GetArticleId {

    public static void main(String[] args) throws APIException {
        ZaloOaClient client = new ZaloOaClient();
        String access_token = "-4Mu8v7-2Y_zJxWjdVWEBlH8iIAQvM5Pd1IJC-ZUBK744Cq_-iKcLS8UbHlPz65nqHMK9Fdc85l3K_uAxgP9T_HVjIIQf6HDb1NI4xcYEaMcJ-jCYU4l9ECZtsICrs4Jf025UR_aRJMkBTr1slbs7kWpadx7mI0Gt73SG_6_61tITEjYnS816wKAonIJ_YKNW3B7OE7Q9G2C6ljNcQmG9_XQ-YNecXfTstNOAkREFNhwAz4BnPbdTCvEX1tIlZDkkdhiUTJC4Zh_ECTQzD0iJTeMooxvunH5x3R66Vo21nLjMOE6EfBe3Iy";
        
        Map<String, String> headers = new HashMap<>();
        headers.put("access_token", access_token);

        JsonObject body = new JsonObject();
        body.addProperty("token", "fvXiHxFn+7lOd2E1LxOxh3cs2cu0KqwwKCQhbSE06b4XwSqinw7F8uwrSPt4fWAkwnloDVzM07tk0KiqvLudSA==");
        
        JsonObject excuteRequest = client.excuteRequest("https://openapi.zalo.me/v2.0/article/verify", "POST", null, body, headers, null);
        
        System.err.println(excuteRequest);
        
        System.exit(0);
    }
}
