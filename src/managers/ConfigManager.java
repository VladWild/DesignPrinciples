package managers;

public class ConfigManager extends ResourceManager {
    private static final String NAME_FILE_CONFIG = "config";

    private static final String OUTPUT_FILE_PATH = "output_file_path";
    private static final String XML_FILE_PATH = "xml_file_path";

    public ConfigManager(){
        fileName = NAME_FILE_CONFIG;
    }

    public String getOutputFilePath(){
        return getValue(OUTPUT_FILE_PATH);
    }

    public String getXMLFilePath(){
        return getValue(XML_FILE_PATH);
    }
}
