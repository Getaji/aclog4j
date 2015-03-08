package aclog4j.request;

import java.util.*;

/**
 * javadoc here.
 *
 * @author Getaji
 */
public class URLParameters {
    private final Map<String, Object> params = new LinkedHashMap<>();

/*    private final List<Set<String>> keysPatterns = new ArrayList<>();

    public void addPattern(final String... pattern) {
        final Set<String> set = new HashSet<>(pattern.length);
        Collections.addAll(set, pattern);
        keysPatterns.add(set);

    }

    public void addPattern(Set<String> pattern) {
        keysPatterns.add(new HashSet<>(pattern));
    }*/

    public void addParam(String key, Object value) {
        params.put(key, value);
    }

    public boolean containsParam(String key) {
        return params.containsKey(key);
    }

    public boolean containsParamAny(String... keys) {
        for (String key : keys) {
            if (containsParam(key)) return true;
        }
        return false;
    }

    public boolean containsParamEvery(String... keys) {
        for (String key : keys) {
            if (!containsParam(key)) return false;
        }
        return true;
    }

/*    public boolean isEnoughParams() {
        if (keysPatterns.size() == 0) return true;

        boolean isAllEmpty = true;
        for (Set<String> keysPattern : keysPatterns) {
            isAllEmpty = keysPattern.isEmpty();
            if (containsAllKey(keysPattern)) {
                return true;
            }
        }

        if (isAllEmpty) return true;

        return false;
    }

    //public boolean getNotEnoughParams()

    private boolean containsAllKey(Set<String> keysPattern) {
        for (String key : keysPattern) {
            if (!params.containsKey(key)) {
                return false;
            }
        }
        return true;
    }*/

    public String toURLString() {
        if (params.size() == 0) return "";

        return "?" + params.entrySet().stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .reduce((s1, s2) -> s1 + "&" + s2).get();
    }
}
