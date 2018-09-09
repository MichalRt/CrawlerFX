package crawler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler {

    private final HttpURLConnection connection;
    private final Logger logger = LogManager.getLogger(Crawler.class);
    private static final String PATTERN_TO_STRING = "\t\t<meta itemprop=\"name\"";


    public Crawler(String page, ContentDTO dataStore) throws IOException {
        URL url = new URL(page);
        connection = getHttpURLConnection(url);
        createRawArrayList(connection.getInputStream(), dataStore);
    }

    public int getResponseCode() {
        try {
            return connection.getResponseCode();
        } catch (IOException e) {
            logger.error("Connection problems with server", e);
        }
        return 500;
    }

    private HttpURLConnection getHttpURLConnection(URL url) {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");
            connection.setReadTimeout(30000);
        } catch (ProtocolException e) {
            logger.error("Problem with protocol", e);
        } catch (IOException e) {
            logger.error("Input international error", e);
        }
        return connection;
    }

    private static void createRawArrayList(InputStream connection, ContentDTO dataStore) throws IOException {
        BufferedReader inputReader = new BufferedReader(
                new InputStreamReader(connection));
        String line;
        List temporaryList = new ArrayList();

        Pattern pattern = Pattern.compile(PATTERN_TO_STRING);
        Matcher matcher = null;
        while ((line = inputReader.readLine()) != null) {
            matcher = pattern.matcher(line);
            if (matcher.lookingAt()) {
                temporaryList.add(line.trim());
            }
        }
        inputReader.close();
        dataStore.saveRawData(temporaryList);
    }
}
