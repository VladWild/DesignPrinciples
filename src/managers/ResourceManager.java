package managers;

import java.util.ResourceBundle;

public abstract class ResourceManager {
    protected String PROP_FILE_PATH = "properties.";
    protected String fileName;

    protected String getValue(String key) {
        return ResourceBundle.getBundle(PROP_FILE_PATH + fileName).getString(key);
    }

}
