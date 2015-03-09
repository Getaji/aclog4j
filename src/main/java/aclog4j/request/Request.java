package aclog4j.request;

import aclog4j.AclogException;
import com.google.gson.reflect.TypeToken;

/**
 * javadoc here.
 *
 * @author Getaji
 */
public interface Request<E> {
    public E request() throws AclogException;

    /**
     * URLエンコードは自前でしてね
     * @return
     */
    String getURLParameter();
    String getEndpoint();
    boolean isUseTypeToken();
    TypeToken<E> getTypeToken();
    Class<E> getResponseClass();
}
