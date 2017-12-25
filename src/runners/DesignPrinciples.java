package runners;

import businesslogic.Service;
import data.DataSource;
import businesslogic.Result;
import data.FactoryDataSource;
import managers.ExeptionManager;
import org.xml.sax.SAXException;
import printers.FactoryPrinter;
import printers.Printer;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Подсчитать количество элементов, значения которых лежат в диапазоне от
 * lowLimit до hiLimit. Если среднее арифметическое значений элементов, которые
 * лежат в этом диапазоне, превышает количество таких элементов, то обнулить
 * элементы с положительными значениями.
 */

public class DesignPrinciples {

    private void run() throws ParserConfigurationException, SAXException, IOException {
        DataSource dataSource = FactoryDataSource.getDataSource(FactoryDataSource.PROPERTIES);

        Service service = new Service();
        Result result = service.startProcessingData(dataSource.getValue(), dataSource.getHilimit(), dataSource.getLowlimit());

        Printer printer = FactoryPrinter.getTypePrinter(FactoryPrinter.CONSOLE);
        printer.print(dataSource.getValue(), dataSource.getHilimit(), dataSource.getLowlimit(), result);
    }

    public static void main(String[] arg){
        DesignPrinciples designPrinciples = new DesignPrinciples();
        ExeptionManager exeptionManager = new ExeptionManager();
        try {
            designPrinciples.run();
        } catch (ParserConfigurationException e) {
            System.err.println(exeptionManager.getParserConfExeption());
        } catch (SAXException e) {
            System.err.println(exeptionManager.getSaxExeption());
        } catch (IOException e) {
            System.err.println(exeptionManager.getIOExeption());
        }
    }
}
