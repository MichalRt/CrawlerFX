package crawler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileEditor {
    private static final Logger logger = LogManager.getLogger(Crawler.class);

    public static ArrayList readFile(String fileName) {
        ArrayList eventList = new ArrayList();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            eventList = stream.collect(Collectors.toCollection((Supplier<ArrayList>) ArrayList::new));
        } catch (IOException e) {
            logger.error("Can't read from file",e);
        }
        return eventList;
    }
    public static void saveToFile(String fileName,Object objectToSave) {
        try {
            Files.write(Paths.get(fileName),(objectToSave + System.lineSeparator()).getBytes(UTF_8),appendOrCreateNewFile(fileName));
        } catch (IOException e) {
            logger.error("Ca't save to file",e);

        }

    }
    private static StandardOpenOption appendOrCreateNewFile(String fileName){
        boolean existFile = new File(Paths.get(fileName).toUri()).isFile();
        if (existFile) {
            return StandardOpenOption.APPEND;
        }else
            return StandardOpenOption.CREATE;

    }
}
