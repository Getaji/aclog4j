package aclog4j.request;

import aclog4j.Tweet;
import com.google.gson.reflect.TypeToken;

/**
 * tweets/showリクエスト。
 *
 * @author Getaji
 */
public class AclogShowRequest extends SkeletonRequest<Tweet> {

    /**
     * The numerical ID of the desired Tweet.
     *
     * @param id tweet id
     * @return this
     */
    public AclogShowRequest id(long id) {
        addParam("id", id);
        return this;
    }

    @Override
    protected void checkPreConditions() {
        checkParam("id");
    }

    @Override
    protected Request<Tweet> getInstance() {
        return this;
    }

    @Override
    public String getEndpoint() {
        return "tweets/show";
    }

    @Override
    public Class<Tweet> getResponseClass() {
        return Tweet.class;
    }

    @Override
    public boolean isUseTypeToken() {
        return false;
    }

    @Override
    public TypeToken<Tweet> getTypeToken() {
        return null;
    }
}
