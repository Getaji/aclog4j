package aclog4j.request;

import aclog4j.AclogException;
import lombok.Getter;

import java.io.IOException;
import java.util.Arrays;

/**
 * javadoc here.
 *
 * @author Getaji
 */
public abstract class SkeletonRequest<E> implements Request<E> {

    @Getter
    protected final URLParameters params = new URLParameters();

    protected void addParam(String key, Object value) {
        params.addParam(key, value);
    }

    protected void checkParam(String key) {
        if (!params.containsParam(key)) {
            throw new IllegalStateException(key + " is not set");
        }
    }

    protected void checkParamAny(String... keys) {
        if (keys.length == 0) return;

        for (String key : keys) {
            if (params.containsParam(key)) return;
        }

        throw new IllegalStateException("any " + Arrays.toString(keys) + " is not set");
    }

    protected abstract void checkPreConditions();

    protected abstract Request<E> getInstance();

    @Override
    public URLParameters getParameters() {
        return params;
    }

    /**
     * リクエストを行う。
     * IOExceptionは内部エラーであるため、スタックトレースを出力してnullを返す。
     *
     * @return 結果
     * @throws aclog4j.AclogException ステータスコードが200以外を返した場合
     */
    @Override
    public E request() throws AclogException {
        //checkParams(getCheckParams());
        checkPreConditions();
        try {
            return RequestExecutor.executeGET(getInstance());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
