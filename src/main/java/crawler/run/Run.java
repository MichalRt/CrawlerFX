package crawler.run;

import crawler.*;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.MalformedURLException;

public class Run implements Launch {
    private static final Logger logger = LogManager.getLogger(Run.class);

    @Override
    public void run(TextField url, TextField fileNameInput, Text notification) {
        ContentDTO dataManager = new EventDTO();
        notification.setText("IN PROGRESS");
        try {
            new Crawler(url.getText(), dataManager);
            TransformData.createFormattedArray(dataManager);
            FileEditor.saveToFile(fileNameInput.getText(), dataManager.getResultOfTransformation());
        } catch (MalformedURLException e) {
            logger.error("Malformed URL error: " + e.getMessage());
            notification.setText("URL ERROR");
        } catch (IOException e) {
            logger.error("IOException:" + e.getMessage());
            notification.setText("FILE ERROR");
        }
    }
}
