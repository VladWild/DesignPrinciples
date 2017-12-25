package printers;

import businesslogic.Result;
import managers.ConfigManager;
import managers.PrintManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FilePrinter implements Printer{
    private PrintManager printManager;
    private ConfigManager configManager;

    public FilePrinter(){
        printManager = new PrintManager();
        configManager = new ConfigManager();
    }

    private StringBuilder getStringBuilder(List<Double> elements, double hilimit, double lowlimit, Result result){
        StringBuilder str = new StringBuilder();

        str.append(String.format(printManager.getInputData(), elements, lowlimit, hilimit));
        str.append(String.format(printManager.getMediumData(), result.getCount(), result.getAvarage()));
        str.append(String.format(printManager.getOutputData(), result.getList()));

        return str;
    }

    @Override
    public void print(List<Double> elements, double hilimit, double lowlimit, Result result) throws IOException {
        File file = new File(configManager.getOutputFilePath());
        FileWriter writer = new FileWriter(file);
        writer.write(String.valueOf(getStringBuilder(elements, hilimit, lowlimit, result)));
        writer.close();
    }
}
