package crawler;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EventDTOTest {
private final EventDTO subject = new EventDTO();
    private List testList = new ArrayList();
    private List expected = new ArrayList();

    @Test
    void shouldSaveAndReturnRawData() {
        subject.saveRawData(testList);
        assertEquals(subject.getRawData(), expected);
    }

    @Test
    void shouldSaveAndReturnEditedData() {
        subject.saveTransformedData(testList);
        assertEquals(subject.getResultOfTransformation(), expected);

    }
}