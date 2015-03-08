package aclog4j.util;

import java.util.function.Consumer;

/**
 * javadoc here.
 *
 * @author Getaji
 */
public class InitializableLong {

    public static InitializableLong ofEmpty() {
        return new InitializableLong();
    }

    /**
     * 初期値を渡してインスタンスを生成します。
     * この初期値渡しは初期化とはなんちゃらかんちゃら
     * @param init
     * @return
     */
    public static InitializableLong ofValue(long init) {
        return new InitializableLong(init);
    }

    private long value = 0;
    private boolean isInitialized = false;

    public InitializableLong() {}

    public InitializableLong(long init) {
        value = 0;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public boolean isInitialized() {
        return isInitialized;
    }

    public void ifInitialized(Consumer<Long> consumer) {
        if (isInitialized) {
            consumer.accept(value);
        }
    }

    public long getValue() {
        return value;
    }
}
