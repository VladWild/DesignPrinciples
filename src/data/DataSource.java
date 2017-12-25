package data;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface DataSource {
    double getHilimit() throws ParserConfigurationException, SAXException, IOException;
    double getLowlimit() throws ParserConfigurationException, SAXException, IOException;

    List<Double> getValue() throws IOException, SAXException, ParserConfigurationException;
}
