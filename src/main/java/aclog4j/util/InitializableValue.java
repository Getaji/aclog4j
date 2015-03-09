package aclog4j.util;

import java.util.function.Consumer;

/**
 * <p>値の初期化状態を管理するコンテナクラスです。
 * 一度でも{@link #setValue(E)}が呼ばれると初期化完了となり、{@link #isInitialized}はtrueを返します。
 *
 * <p>もうちょっといい名前がある気がしないでもない。
 *
 * @author Getaji
 */
public class InitializableValue<E> {
    private E value = null;
    private boolean isInitialized = false;

    public void setValue(E value) {
        this.value = value;
    }

    public boolean isInitialized() {
        return isInitialized;
    }

    public void ifInitialized(Consumer<E> consumer) {
        if (isInitialized) {
            consumer.accept(value);
        }
    }
}
