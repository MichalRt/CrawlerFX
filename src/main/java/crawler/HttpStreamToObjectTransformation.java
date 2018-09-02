package crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpStreamToObjectTransformation {

    private final String patternString=  "\t\t<meta itemprop=\"name\"";
    private final String regexForContent = "([A-Z])\\w+";



    public HttpStreamToObjectTransformation(InputStream connection, List eventListEdited, List eventListRaw) throws IOException {
        createRawArrayList(connection, eventListRaw);
        createFormattedArray(eventListEdited, eventListRaw);

    }

    private void createFormattedArray(List evenetListEdited, List evenetListRaw) {
        Pattern p = Pattern.compile(regexForContent);
        evenetListRaw.stream().filter(s->p.matcher((CharSequence) s).matches()).forEach(e->evenetListEdited.add(e));
        for (int i = 0; i < evenetListRaw.size(); i++) {
            String[] split = evenetListRaw.get(i).toString().split("\"");
            evenetListEdited.add(split[3]);
        }
    }

    private void createRawArrayList(InputStream connection, List evenetListRaw) throws IOException {
        BufferedReader inputReader = new BufferedReader(
                new InputStreamReader(connection));
        String line;

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = null;
        while((line = inputReader.readLine()) != null) {
            matcher = pattern.matcher(line);
            if (matcher.lookingAt()) {
                evenetListRaw.add(line.trim());
            }
        }
        inputReader.close();
    }
}
