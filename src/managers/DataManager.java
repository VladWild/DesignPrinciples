package managers;

public class DataManager extends ResourceManager {
    private static final String INPUT_DATA_FILE_PATH = "inputdata.";
    private static final String NAME_FILE_DATA = "data";

    private static final String ELEMENTS = "elements";
    private static final String HI_LIMIT = "hilimit";
    private static final String LOW_LIMIT = "lowlimit";

    private static final String DELIMITER = ",";

    public DataManager(){
        fileName = NAME_FILE_DATA;
        PROP_FILE_PATH = INPUT_DATA_FILE_PATH;
    }

    public String[] getElements(){
        return getValue(ELEMENTS).split(DELIMITER);
    }

    public String getHiLimit(){
        return getValue(HI_LIMIT);
    }

    public String getLowlimit(){
        return getValue(LOW_LIMIT);
    }
}
