package Calculator;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Calculator implements Parser {
    /**
     * Generowana dokładnie 1 raz na podstawie pliku w katalogu projektu
     */
    private final Map<String, String> currencies;
    private static Calculator instance;
    /**
     * Mapa generowana na stworzenie obiektu typu kalkulator
     */
    private Calculator() throws ParserConfigurationException, IOException, SAXException {
        currencies = generateCurrenciesList();
    }

    /**
     * @param name Nazwa pliku
     * @return Zwraca obiekt typu Document
     * @throws ParserConfigurationException Informuje o błędzie w wywołaniu metod na obiekcie DocumentBuilderFactory.
     * @throws IOException Informuje o błędzie odczytu-zapisu (np. w przypadku nieodnalezienia pliku)
     * @throws SAXException Informuje o błędzie parsera
     *
     */

    @Override
    public Document getXMLDoc(String name) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

        DocumentBuilder db = dbf.newDocumentBuilder();
        return db.parse(new File(name));

    }

    /**
     * @return Zwaraca mapę gdzie kluczem jest 3-znakowy kod waluty, a wartością kurs. Mapa generowana jest na podstawie
     * pliku currencies.xml
     * @throws ParserConfigurationException Informuje o błędzie w wywołaniu metod na obiekcie DocumentBuilderFactory w
     * metodzie getXMLDoc
     * @throws SAXException Informuje o błędzie parsera w metodzie getXMLDoc
     * @throws IOException Informuje o błędzie odczytu-zapisu (np. w przypadku nieodnalezienia pliku) metodzie getXMLDoc
     */
    @Override
    public Map<String, String> generateCurrenciesList() throws ParserConfigurationException, IOException, SAXException {
        Map<String, String> currencies = new HashMap<>();
        Document doc = getXMLDoc("currencies.xml");
        NodeList l = doc.getElementsByTagName("Cube");
        for (int i = 0; i < l.getLength(); i++) {
            Node cube = l.item(i);
            if (cube.getAttributes().getNamedItem("rate") != null && cube.hasAttributes()) {
                String currency = String.valueOf(cube.getAttributes().getNamedItem("currency").getNodeValue());
                String rate = String.valueOf(cube.getAttributes().getNamedItem("rate").getNodeValue());
                currencies.put(currency, rate);
            }

        }
        return currencies;
    }

    /**
     * @param euroValue Liczba, którą metoda przeliczy na podstawie kursu pobranego z Mapy.
     * @param currencyCode Kod waluty
     * @return Zwraca wynik w formie stringa do 2 miejsc po przecinku
     */
    @Override
    public Double calculateCurrencies(Double euroValue, String currencyCode) {
        if(euroValue < 0){
            throw new NumberFormatException("Zły format kwoty: "+ euroValue);
        }
        if(!currencyCode.matches("^[A-Z]{3}$")){
            throw new NumberFormatException("Zły format kodu waluty: "+ currencyCode);

        }
        double preRoundResult = Double.parseDouble(currencies.get(currencyCode)) * euroValue;
        return Math.round(preRoundResult * 100.0)/100.0;
    }

    /**
     * @return Getter do wygenerowanej mapy
     */
    public Map<String, String> getCurrencies() {
        return currencies;
    }
    public static Calculator getInstance() throws ParserConfigurationException, IOException, SAXException {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }
}
