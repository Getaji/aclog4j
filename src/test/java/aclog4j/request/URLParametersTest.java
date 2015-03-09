package aclog4j.request;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class URLParametersTest {
/*    @Test
    public void isEnoughParams_何もパターンを登録していないとtrue() {
        final URLParameters urlParameters = new URLParameters();
        assertThat(urlParameters.isEnoughParams(), is(true));
        urlParameters.addParam("foo", "bar");
        assertThat(urlParameters.isEnoughParams(), is(true));
    }

    @Test
    public void isEnoughParams_パターンと同じキーとそのペアの値を登録するとtrue() {
        final URLParameters urlParameters = new URLParameters();
        urlParameters.addPattern("foo");
        urlParameters.addParam("foo", "bar");
        assertThat(urlParameters.isEnoughParams(), is(true));
    }

    @Test
    public void isEnoughParams_いずれかのパターンに一致すればtrue() {
        final URLParameters urlParameters = new URLParameters();
        urlParameters.addPattern("foo");
        urlParameters.addPattern("ping");
        urlParameters.addParam("ping", "pong");
        assertThat(urlParameters.isEnoughParams(), is(true));
    }*/

    @Test
    public void toURLString_何もパラメータを追加していないと空文字() {
        final URLParameters urlParameters = new URLParameters();
        assertThat(urlParameters.toURLString(), is(""));
    }

    @Test
    public void toURLString_何かパラメータを追加しているとイコールで繋がれる() {
        final URLParameters urlParameters = new URLParameters();
        urlParameters.addParam("foo", "bar");
        assertThat(urlParameters.toURLString(), is("foo=bar"));
    }

    @Test
    public void toURLString_複数のパラメータを追加しているとイコールで繋がれたものをアンドで繋がれる() {
        final URLParameters urlParameters = new URLParameters();
        urlParameters.addParam("foo", "bar");
        urlParameters.addParam("ping", "pong");
        assertThat(urlParameters.toURLString(), is("foo=bar&ping=pong"));
    }
}