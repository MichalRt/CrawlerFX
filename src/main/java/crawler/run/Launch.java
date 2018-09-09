package crawler.run;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public interface Launch {
    void run(TextField url, TextField fileNameInput, Text notification);
}
