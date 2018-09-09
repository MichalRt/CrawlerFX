package crawler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class EventDTO implements ContentDTO {
    private List eventListEdited;
    private List eventListRaw;

    public EventDTO() {
        this.eventListEdited = new ArrayList();
        this.eventListRaw = new ArrayList();
    }

    @Override
    public void saveRawData(List dataToSave) {
        eventListRaw = Collections.unmodifiableList(dataToSave);
    }

    @Override
    public void saveTransformedData(List dataToSave) {
        eventListEdited = Collections.unmodifiableList(dataToSave);

    }

    @Override
    public List getRawData() {
        return Collections.unmodifiableList(eventListRaw);
    }

    @Override
    public List getResultOfTransformation() {
        return Collections.unmodifiableList(eventListEdited);
    }

}
