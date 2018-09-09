package crawler;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileEditor {
    private static final Logger logger = LogManager.getLogger(FileEditor.class);
    public static final String EXTENSION = ".txt";

    public static List readFile(String fileName) {
        List eventList = new ArrayList();
        try (Stream<String> stream = Files.lines(Paths.get(fileName + ".txt"))) {
            eventList = stream.collect(Collectors.toCollection((Supplier<ArrayList>) ArrayList::new));
        } catch (IOException e) {
            logger.error("Can't read from file",e);
        }
        return eventList;
    }

    public static void saveToFile(String fileName, Collection objectToSave) {
        try {
            FileUtils.writeLines(new File(fileName + EXTENSION), objectToSave, true);
        } catch (IOException e) {
            logger.error("Can't save to file", e);

        }

    }
}
