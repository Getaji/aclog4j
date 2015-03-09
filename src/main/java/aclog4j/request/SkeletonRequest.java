package aclog4j.request;

import aclog4j.AclogException;
import lombok.Getter;

import java.io.IOException;
import java.util.Arrays;

/**
 * {@link Request}クラスの実装を補助するスケルトンクラスです。
 *
 * @author Getaji
 */
public abstract class SkeletonRequest<E> implements Request<E> {

    @Getter
    protected final URLParameters params = new URLParameters();

    /**
     * 内部にある{@link #params#addParam(String, Object)}を用いてパラメータを追加する。
     * 直接呼び出しても違いはない。
     *
     * @param key キー
     * @param value 値
     */
    protected void addParam(String key, Object value) {
        params.addParam(key, value);
    }

    /**
     * <p>内部にある{@link #params#containsParam(String)}を用いてパラメータがセットされているかチェックする。
     * セットされていない場合、以下のフォーマットで文字列を渡して{@link IllegalStateException}を送出する。
     *
     * <p>&lt;key&gt; is not set
     *
     * @param key チェックするパラメータのキー
     */
    protected void checkParam(String key) {
        if (!params.containsParam(key)) {
            throw new IllegalStateException(key + " is not set");
        }
    }

    /**
     * <p>内部にある{@link #params#containsParam(String)}を用いて
     * 最低ひとつのパラメータがセットされているかチェックする。
     * ひとつもセットされていない場合、以下のフォーマットで文字列を渡して{@link IllegalStateException}を送出する。
     *
     * <p>&lt;keys&gt; is not set
     * <p>example: any [foo, bar] is not set
     *
     * @param keys チェックする複数のキー
     */
    protected void checkParamAny(String... keys) {
        if (keys.length == 0) return;

        for (String key : keys) {
            if (params.containsParam(key)) return;
        }

        throw new IllegalStateException("any " + Arrays.toString(keys) + " is not set");
    }

    /**
     * <p>事前条件を検査する。
     * このメソッドは{@link #request}手続きの最初に呼び出される。
     *
     * <p>このクラスを実装したクラスは、このメソッドをオーバーライドして
     * {@link #checkParam}や{@link #checkParamAny}を呼び出し、値などの事前条件の検査をすることができる。
     */
    protected abstract void checkPreConditions();

    /**
     * <p>自身のインスタンスを返す。
     *
     * <p>このメソッドは{@link #request}手続きで呼び出され、
     * 渡されたインスタンスが{@link RequestExecutor#executeGET}に渡される。
     *
     * <p>このクラスを実装したクラスは、このメソッドをオーバーライドして自身のインスタンスを返さなければならない。
     *
     * @return インスタンス
     */
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
