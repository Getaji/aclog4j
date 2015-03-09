package aclog4j;

import aclog4j.request.AclogLookupRequest;
import aclog4j.request.AclogShowRequest;
import aclog4j.request.RequestExecutor;
import lombok.Getter;

/**
 * javadoc here.
 *
 * @author Getaji
 */
public final class Aclog {

    @Getter
    private static final RequestExecutor requestExecutor = new RequestExecutor();

    private Aclog() {
        throw new UnsupportedOperationException("class Aclog is Utility class");
    }

    // ========================================================================
    // Tweets
    // ------------------------------------------------------------------------
    public static AclogShowRequest show() {
        return new AclogShowRequest();
    }

    public static AclogLookupRequest lookup() {
        return new AclogLookupRequest();
    }
}
