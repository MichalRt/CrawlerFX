package crawler;

import java.util.List;

public interface ContentDTO {

    void saveRawData(List dataToSave);

    void saveTransformedData(List dataToSave);

    List getRawData();

    List getResultOfTransformation();
}
