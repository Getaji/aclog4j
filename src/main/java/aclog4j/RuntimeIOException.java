package aclog4j;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * {@link java.io.IOException}を非チェック例外として扱うための例外クラスです。
 *
 * コンストラクタで{@link java.io.IOException}のインスタンスを受け取り、すべてのメソッド呼び出しを委譲します。
 *
 * @author Getaji
 */
public class RuntimeIOException extends RuntimeException {
    private final IOException ioexception;

    public RuntimeIOException(IOException ioexception) {
        this.ioexception = ioexception;
    }

    @Override
    public String getMessage() {
        return ioexception.getMessage();
    }

    @Override
    public String getLocalizedMessage() {
        return ioexception.getLocalizedMessage();
    }

    @Override
    public Throwable getCause() {
        return ioexception.getCause();
    }

    @Override
    public Throwable initCause(Throwable cause) {
        return ioexception.initCause(cause);
    }

    @Override
    public String toString() {
        return ioexception.toString();
    }

    @Override
    public void printStackTrace() {
        ioexception.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        ioexception.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        ioexception.printStackTrace(s);
    }

    @Override
    public Throwable fillInStackTrace() {
        return ioexception.fillInStackTrace();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return ioexception.getStackTrace();
    }

    @Override
    public void setStackTrace(StackTraceElement[] stackTrace) {
        ioexception.setStackTrace(stackTrace);
    }
}
