package printers;

import businesslogic.Result;

import java.io.IOException;
import java.util.List;

public interface Printer {
    void print(List<Double> elements, double hilimit, double lowlimit, Result result) throws IOException;
}
