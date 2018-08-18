package utils;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Common {
    public static File getSpeakerFile(String jsonFileName) throws URISyntaxException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL fileUrl = classLoader.getResource(jsonFileName);
        URI fileUri = new URI(fileUrl.toString());
        File speakerFile = new File(fileUri);

        return speakerFile;
    }
}
