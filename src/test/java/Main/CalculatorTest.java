package Main;

import Calculator.Calculator;
import Utils.Util;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator c = Calculator.getInstance();

    CalculatorTest() throws ParserConfigurationException, IOException, SAXException {
    }


    @Test
    void checkIfFileExists() {
        assertThrows(IOException.class, ()->
                c.getXMLDoc("WrongName.xml"));
    }

    @Test
    void checkIfCurrencyMapExists() {
        assertNotNull(c.getCurrencies());
        assertEquals(c.getCurrencies().size(),31);
    }

    @Test
    void calculateCurrenciesArgHandling() {
        assertThrows(NumberFormatException.class, ()->
                c.calculateCurrencies(-123.2, "PLN"));

        assertThrows(NumberFormatException.class, ()->
                c.calculateCurrencies(12.0, "Incorrect string"));
        assertThrows(NumberFormatException.class, ()->
                c.calculateCurrencies(12.0, ""));

    }
    @Test
    void calculateCurrenciesFixedTests() {
        assertThrows(NumberFormatException.class, ()->
                c.calculateCurrencies(-123.2, "PLN"));

        assertThrows(NumberFormatException.class, ()->
                c.calculateCurrencies(12.0, "Incorrect string"));
        assertEquals(c.calculateCurrencies(134.235, "PLN"), 628.60);
        assertEquals(c.calculateCurrencies(13.18, "PLN"), 61.72);
        assertEquals(c.calculateCurrencies(13.5, "PLN"), 63.22);

    }

    @Test
    void calculateCurrenciesAll() {
        Map<String, String> currencies = c.getCurrencies();
        List<Double> amounts = new ArrayList<>(Arrays.asList(134.235, 13.18, 63.5, 0.23));
        int i = 0;
        System.out.println(currencies);
        for (Map.Entry<String, String> entry : currencies.entrySet()) {
            for(Double amount: amounts){
                Double actualResult = Util.generatedCalculations.get(i);
                assertEquals(c.calculateCurrencies(amount, entry.getKey()), actualResult
                        );
                i++;
            }
        }

    }

}