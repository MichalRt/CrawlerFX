package crawler;

import java.util.ArrayList;
import java.util.List;

public class EventDTO {
    private List eventListEdited;
    private List eventListRaw;

    public EventDTO() {
        this.eventListEdited = new ArrayList();
        this.eventListRaw = new ArrayList();
    }

    public List getEventListEdited() {
        return eventListEdited;
    }

    public List getEventListRaw() {
        return eventListRaw;
    }

}
