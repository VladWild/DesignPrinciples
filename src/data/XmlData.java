package data;

import managers.ConfigManager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class XmlData implements DataSource {
    private static final String ELEMENT = "element";
    private static final String VALUE = "value";
    private static final String RANGE = "range";
    private static final String HI_LIMIT = "hilimit";
    private static final String LOW_LIMIT = "lowlimit";

    private ConfigManager manager;

    private Document doc;
    private NodeList nodeList;
    private Node node;
    private Element element;

    public XmlData(){
        manager = new ConfigManager();
    }

    private Document getDocument() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(manager.getXMLFilePath()));

        return doc;
    }

    private Element getElementOfRange() throws IOException, SAXException, ParserConfigurationException {
        doc = getDocument();
        nodeList = doc.getElementsByTagName(RANGE);
        node = nodeList.item(0);
        return  (Element) node;
    }

    @Override
    public double getHilimit() throws ParserConfigurationException, SAXException, IOException {
        return Double.valueOf(getElementOfRange().getElementsByTagName(HI_LIMIT).item(0).getTextContent());
    }

    @Override
    public double getLowlimit() throws ParserConfigurationException, SAXException, IOException {
        return Double.valueOf(getElementOfRange().getElementsByTagName(LOW_LIMIT).item(0).getTextContent());
    }

    @Override
    public List<Double> getValue() throws IOException, SAXException, ParserConfigurationException {
        List<Double> list = new LinkedList<>();

        doc = getDocument();
        nodeList = doc.getElementsByTagName(ELEMENT);

        for (int i = 0; i < nodeList.getLength(); i++){
            node = nodeList.item(i);
            element = (Element) node;
            if (Node.ELEMENT_NODE == node.getNodeType()){
                list.add(Double.valueOf(element.getElementsByTagName(VALUE).item(0).getTextContent()));
            }
        }

        return list;
    }
}
