package crawler;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
class CrawlerTest {
    public static final String HTTPS_WWW_TIPICO_COM = "https://www.tipico.com/en/online-sports-betting/";
    public static final int RETURN_ERROR_CODE = 404;
    public static final int RESPONSE_OK_CODE = 200;
    public static final int BAD_RESPONSE_CODE = 404;

    Crawler subject;

    @Test
    void shouldConnectToTipicoSite() throws IOException {
        ContentDTO contentDTO = new EventDTO();
        subject = new Crawler(HTTPS_WWW_TIPICO_COM, contentDTO);
        assertEquals(subject.getResponseCode(), RESPONSE_OK_CODE);
    }

//    @Test
//    void shouldReturnErrorCode() throws IOException {
//
//        subject = new Crawler(HTTPS_WWW_TIPICO_COM,contentDTO);
//    }
//
//    @Test
//    void returnInputStream() throws IOException {
//
//        Crawler spy = Mockito.spy(new Crawler(HTTPS_WWW_TIPICO_COM,contentDTO));
//
//    }
}