package printers;

import businesslogic.Result;
import managers.PrintManager;

import java.util.List;


public class ConsolePrinter implements Printer {
    private PrintManager printManager;

    public ConsolePrinter(){
        printManager = new PrintManager();
    }

    private StringBuilder getStringBuilder(List<Double> elements, double hilimit, double lowlimit, Result result){
        StringBuilder str = new StringBuilder();

        str.append(String.format(printManager.getInputData(), elements, lowlimit, hilimit));
        str.append(String.format(printManager.getMediumData(), result.getCount(), result.getAvarage()));
        str.append(String.format(printManager.getOutputData(), result.getList()));

        return str;
    }

    @Override
    public void print(List<Double> elements, double hilimit, double lowlimit, Result result) {
        System.out.println(getStringBuilder(elements, hilimit, lowlimit, result));
    }

}
