package aclog4j.request;

import aclog4j.Tweet;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * javadoc here.
 *
 * @author Getaji
 */
public class AclogLookupRequest extends SkeletonRequest<List<Tweet>> {


    @Override
    protected void checkPreConditions() {
    }

    @Override
    protected Request<List<Tweet>> getInstance() {
        return this;
    }

    @Override
    public String getEndpoint() {
        return "tweets/lookup";
    }

    @Override
    public Class<List<Tweet>> getResponseClass() {
        return null;
    }

    @Override
    public boolean isUseTypeToken() {
        return true;
    }

    @Override
    public TypeToken<List<Tweet>> getTypeToken() {
        return new TypeToken<List<Tweet>>() {};
    }
}
