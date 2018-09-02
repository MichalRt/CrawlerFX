package crawler;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EventDTOTest {
private final EventDTO subject = new EventDTO();

    @Test
    void shouldReturnRawArrayList() {
        assertEquals(subject.getEventListEdited(),new ArrayList());
    }

    @Test
    void shouldReturnEditedArrayList() {
        assertEquals(subject.getEventListRaw(),new ArrayList());

    }
}