package Calculator;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;

public interface Parser {
    Document getXMLDoc(String name) throws ParserConfigurationException, IOException, SAXException;

    Map<String, String> generateCurrenciesList() throws ParserConfigurationException, IOException, SAXException;

    Double calculateCurrencies(Double euroValue, String currencyCode) throws ParserConfigurationException, IOException,
            SAXException;
}
