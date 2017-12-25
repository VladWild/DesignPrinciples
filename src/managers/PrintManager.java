package managers;

public class PrintManager extends ResourceManager {
    private static final String NAME_FILE_PRINT = "print";

    private static final String INPUT_DATA = "input_data";
    private static final String MEDIUM_DATA = "medium_data";
    private static final String OUTPUT_DATA = "output_data";


    public PrintManager(){
        fileName = NAME_FILE_PRINT;
    }

    public String getInputData(){
        return getValue(INPUT_DATA);
    }

    public String getMediumData(){
        return getValue(MEDIUM_DATA);
    }

    public String getOutputData(){
        return getValue(OUTPUT_DATA);
    }

}
