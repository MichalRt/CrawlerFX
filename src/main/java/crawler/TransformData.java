package crawler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TransformData {

    private static final String regexForContent = "([A-Z])\\w+";

    public static void createFormattedArray(ContentDTO contentManger) {
        Pattern p = Pattern.compile(regexForContent);
        List rawData = contentManger.getRawData();
        List temporaryEditedList = new ArrayList();

        rawData.stream().filter(s -> p.matcher((CharSequence) s).matches()).forEach(e -> temporaryEditedList.add(e));
        for (int i = 0; i < rawData.size(); i++) {
            String[] split = rawData.get(i).toString().split("\"");
            temporaryEditedList.add(split[3]);
        }
        contentManger.saveTransformedData(temporaryEditedList);
    }
}
