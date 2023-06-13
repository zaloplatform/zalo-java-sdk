package v3;


import com.google.gson.JsonObject;
import com.vng.zalo.sdk.APIException;
import com.vng.zalo.sdk.oa.ZaloOaClient;
import java.io.File;
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
public class UploadFile {

    public static void main(String[] args) throws APIException {
        ZaloOaClient client = new ZaloOaClient();
        String access_token = "DlZc09wi6pCm_kGEdwiQFpBxwGAGjGzbKe610-MLBJGvXhDTvDGoFpJcjs_FxYm55lcKRTkjDp1u-RLZkEiA86VVzswgqGqGQUA0HPhF37OmcwOj_OiRIWMAw3hqW5DtNRJV4VACNaGRdziwnQSa23sik3Jejbu0EQF3DVcnRGSKa9LQri0O2dhJaLotzGugGEQTMEhP9cyHtwaYkFSGV7FoY4c4vWSuUkEARfApSGbFdDjXWPfw4NcGXo3EjI1f0kNR1AtoTKDH_lC0WCTIQapIxHoEynLt9yFf7zME555tiUyQtB1TMnAKtc_0atiR5yVASRp-E1OVxRvRlCOP6LGpcc3B19Ys6JK";

        Map<String, String> headers = new HashMap<>();
        headers.put("access_token", access_token);

        Map<String, File> files = new HashMap<>();
        File file = new File("/home/lap13561/Downloads/A21402.pdf");
        files.put("file", file);

        JsonObject excuteRequest = client.excuteRequest("https://dev-openapi.zalo.me/v2.0/oa/upload/file", "POST", null, null, headers, files);

        System.err.println(excuteRequest);

        System.exit(0);

    }
}
