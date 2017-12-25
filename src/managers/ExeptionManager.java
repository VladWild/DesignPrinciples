package managers;

public class ExeptionManager extends ResourceManager{
    private static final String NAME_FILE_EXEPTIONS = "exeptions";

    private static final String PARSER_CONF_EXEPTION = "parser_conf_exception";
    private static final String SAX_EXEPTION = "sax_exeption";
    private static final String IO_EXEPTION = "io_exeption";

    public ExeptionManager(){
        fileName = NAME_FILE_EXEPTIONS;
    }

    public String getParserConfExeption(){
        return getValue(PARSER_CONF_EXEPTION);
    }

    public String getSaxExeption(){
        return getValue(SAX_EXEPTION);
    }

    public String getIOExeption(){
        return getValue(IO_EXEPTION);
    }


}
