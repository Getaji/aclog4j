package aclog4j.request;

import aclog4j.AclogException;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * javadoc here.
 *
 * @author Getaji
 */
public class RequestExecutor {

    private static final String baseUrl = "http://aclog.koba789.com/api/";
    private static final Gson gson = new Gson();
    private static final RequestConfig requestConfig;

    static {
        requestConfig = RequestConfig.custom()
                .setConnectTimeout((int) TimeUnit.SECONDS.toMillis(10))
                .setConnectionRequestTimeout((int) TimeUnit.SECONDS.toMillis(10))
                .build();
    }

    public static <T> T executeGET(Request<T> request)
            throws IOException, AclogException {
        final String url = baseUrl + request.getEndpoint() + request.getParameters().toURLString();
        final HttpGet get = new HttpGet(url);
        get.setConfig(requestConfig);
        final CloseableHttpClient httpClient = HttpClients.createMinimal();
        final HttpResponse response = httpClient.execute(get);
        httpClient.close();

        final int statusCode = response.getStatusLine().getStatusCode();
        final String responseBody = EntityUtils.toString(response.getEntity());
        if (statusCode != 200) {
            throw new AclogException(statusCode, responseBody);
        }

        if (request.isUseTypeToken()) {
            return gson.fromJson(responseBody, request.getTypeToken().getType());
        } else {
            return gson.fromJson(responseBody, request.getResponseClass());
        }
    }
}
