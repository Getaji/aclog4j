package aclog4j.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * javadoc here.
 *
 * @author Getaji
 */
public class URLUtil {
    public static String createURL(String host, String endpoint, Map<String, Object> params) {
        final StringBuilder builder = new StringBuilder(host);
        builder.append(endpoint);

        if (params.isEmpty()) {
            return builder.toString();
        }

        final String parameters = params.entrySet().stream()
                .map(e -> e.getKey() + ":" + e.getValue())
                .reduce("", (s1, s2) -> s1 + "&" + s2);
        builder.append("?");
        builder.append(parameters);
        return builder.toString();
    }

    public static String urlEncode(String str) {
        final String encode = "UTF-8";
        try {
            String encodedStr = URLEncoder.encode(str, encode);
            encodedStr = encodedStr.replace("*", "%2a");
            encodedStr = encodedStr.replace("-", "%2a");
            encodedStr = encodedStr.replace("+", "%20");

            return encodedStr;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unsupported encoding: " + encode);
        }
    }
}
