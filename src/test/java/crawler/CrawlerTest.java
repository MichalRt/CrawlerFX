package crawler;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CrawlerTest {
    public static final String HTTPS_WWW_TIPICO_COM = "https://www.tipico.com/en/online-sports-betting/";
    public static final int RETURN_ERROR_CODE = 404;
    public static final int RESPONSE_OK_CODE = 200;
    public static final int BAD_RESPONSE_CODE = 404;
    Crawler subject;
    @Mock
    InputStream stream;


    @Test
    void shouldConnectToTipicoSite() throws IOException {
        subject = new Crawler(HTTPS_WWW_TIPICO_COM);
        assertEquals(subject.getResponseCode(), RESPONSE_OK_CODE);
    }

    @Test
    void shouldReturnErrorCode() throws IOException {

        Crawler spy = Mockito.spy(new Crawler(HTTPS_WWW_TIPICO_COM));
        Mockito.when(spy.getResponseCode()).thenReturn(RETURN_ERROR_CODE);

        assertEquals(spy.getResponseCode(), BAD_RESPONSE_CODE);
    }

    @Test
    void returnInputStream() throws IOException {

        Crawler spy = Mockito.spy(new Crawler(HTTPS_WWW_TIPICO_COM));
        Mockito.when(spy.returnInputStream()).thenReturn(stream);

        assertEquals(spy.returnInputStream(),stream);

    }
}