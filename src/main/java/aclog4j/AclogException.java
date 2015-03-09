package aclog4j;

import lombok.Getter;

/**
 * javadoc here.
 *
 * @author Getaji
 */
public class AclogException extends Exception {
    @Getter
    private final int statusCode;

    @Getter
    private final String responseBody;

    public AclogException(int statusCode, String responseBody) {
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    @Override
    public String toString() {
        return "RequestException{" +
                "statusCode=" + statusCode +
                ", responseBody='" + responseBody + '\'' +
                '}';
    }
}
