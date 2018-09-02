package crawler;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileEditorTest {

    private static final String TEST_FILE_NAME_TO_READ = "TestRead";
    private static final String TEST_FILE_NAME_TO_SAVE = "TestSave";
    private static final String FC_GRONINGEN = "[FC Groningen]";

    @AfterAll
    private static void destroyData(){
        try {
            Files.deleteIfExists(Paths.get(TEST_FILE_NAME_TO_SAVE));
            Files.deleteIfExists(Paths.get(TEST_FILE_NAME_TO_READ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        @BeforeAll
    private static void init(){
        try {
            Files.deleteIfExists(Paths.get(TEST_FILE_NAME_TO_SAVE));
            Files.deleteIfExists(Paths.get(TEST_FILE_NAME_TO_READ));
            FileEditor.saveToFile(TEST_FILE_NAME_TO_READ, Arrays.asList("FC Groningen"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void shouldSaveDataToFile() {
        FileEditor.saveToFile(TEST_FILE_NAME_TO_SAVE, Arrays.asList("Test"));
    assertTrue(Files.exists(Paths.get(TEST_FILE_NAME_TO_SAVE)));
    }
    @Test
    void shouldReturnArrayFromFile() {
        ArrayList subject = FileEditor.readFile(TEST_FILE_NAME_TO_READ);
        List resultArray = Arrays.asList(FC_GRONINGEN);
        assertEquals(subject,resultArray);
    }
}