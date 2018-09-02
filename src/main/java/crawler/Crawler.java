package crawler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Crawler {

    private final HttpURLConnection connection;
    private final int responseCode;
    private final Logger logger = LogManager.getLogger(Crawler.class);


    public Crawler(String page) throws IOException {
        URL url = new URL(page);
        connection = getHttpURLConnection(url);
        responseCode= connection.getResponseCode();
    }

    public int getResponseCode() {
        return  responseCode;
    }

    private HttpURLConnection getHttpURLConnection(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Chrome");
        connection.setReadTimeout(30000);
        return connection;
    }

    public InputStream returnInputStream() throws IOException {
        return connection.getInputStream();
    }
}
