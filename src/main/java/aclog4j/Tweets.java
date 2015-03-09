package aclog4j;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * javadoc here.
 *
 * @author Getaji
 */
public class Tweets {

    @Getter
    private final List<Tweet> tweets;

    public Tweets(Tweet[] tweets) {
        List<Tweet> list = new ArrayList<>(tweets.length);
        Collections.addAll(list, tweets);
        this.tweets = Collections.unmodifiableList(list);
    }
}
