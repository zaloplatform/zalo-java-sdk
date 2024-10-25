
import com.vng.zalo.sdk.APIException;
import com.vng.zalo.sdk.ZaloBaseClient;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lap
 */
public class GetAccessTokenByRefreshToken {

    public static void main(String[] args) throws APIException {

        ZaloBaseClient client = new ZaloBaseClient();

        CloseableHttpClient httpclient = HttpClients.createDefault();

        try {
            try {
                CloseableHttpClient httpClient = HttpClients.createDefault();
                URIBuilder builder = new URIBuilder("https://oauth.zaloapp.com/v4/oa/access_token");

                HttpPost sendMethodPost = new HttpPost(builder.toString());
                Map<String, String> header = new HashMap<>();
                header.put("secret_key", "<your_secret_key>");
                header.put("Content-Type", "application/x-www-form-urlencoded");

                if (header != null) {
                    for (Map.Entry<String, String> entry : header.entrySet()) {
                        sendMethodPost.addHeader(entry.getKey(), entry.getValue());
                    }
                }

                Map<String, String> body = new HashMap<>();
                body.put("refresh_token", "<your_refresh_token>");
                body.put("app_id", "<your_app_id>");
                body.put("grant_type", "refresh_token");

                List<NameValuePair> params = new ArrayList<>();
                for (String key : body.keySet()) {
                    params.add(new BasicNameValuePair(key, body.get(key)));
                }

                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(params);
                sendMethodPost.setEntity(urlEncodedFormEntity);
                CloseableHttpResponse response = httpClient.execute(sendMethodPost);
                try {
                    HttpEntity entity = response.getEntity();
                    System.err.println(EntityUtils.toString(entity));
                } finally {
                    response.close();
                }

            } catch (IOException ex) {
                throw new APIException(ex);
            } catch (URISyntaxException ex) {
                throw new APIException(ex);
            } finally {
                httpclient.close();
            }
        } catch (APIException | IOException | ParseException ex) {
            throw new APIException(ex);
        }

        System.exit(0);
    }
}
