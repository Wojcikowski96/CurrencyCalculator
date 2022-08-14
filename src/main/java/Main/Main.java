package Main;

import Utils.Util;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        TextField preCalculatedCurrency = new TextField();
        Label calculatedCurrencyLabel = new Label("Podaj kwotę w EUR:");
        TextField currencyCode = new TextField();
        Label currencyCodeLabel = new Label("3-literowy kod waluty docelowej:");
        TextField result = new TextField();
        Label messageUnderCode = new Label();
        Label messageUnderValue = new Label();
        Label resultLabel = new Label("Wynik:");
        VBox root = new VBox();

        primaryStage.setTitle("Prosty kalkulator walut");
        messageUnderValue.setVisible(false);
        messageUnderCode.setVisible(false);
        result.setEditable(false);
        btn.setText("Przelicz");

        btn.setOnAction(event -> {
            try {
                Calculator c = Calculator.getInstance();
                String currencyCodeInput = currencyCode.getText();
                String preCalcCurr = preCalculatedCurrency.getText();
                String preCalcCurrForm = preCalcCurr.replace(',','.');

                if (!Util.isNumeric(preCalcCurrForm)) {
                    messageUnderValue.setVisible(true);
                    messageUnderValue.setText("Kwota: " + preCalcCurr + " ma niepoprawny format");
                } else if (!Util.checkIfCurrencyCodeExists(c, currencyCodeInput)) {
                    messageUnderCode.setVisible(true);
                    messageUnderCode.setText("Nie znaleziono kodu waluty: " + currencyCodeInput);
                } else {
                    Double calculationResult = c.calculateCurrencies(Double.valueOf(preCalcCurrForm),
                            currencyCodeInput);
                    String resultText = calculationResult.toString();
                    messageUnderCode.setVisible(false);
                    messageUnderValue.setVisible(false);
                    result.setText(resultText);
                }

            } catch (ParserConfigurationException | IOException | SAXException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }

        });

        root.alignmentProperty().set(Pos.CENTER);
        root.getChildren().addAll(calculatedCurrencyLabel, preCalculatedCurrency, messageUnderValue, currencyCodeLabel,
                currencyCode, messageUnderCode, resultLabel, result, btn);
        primaryStage.setScene(new Scene(root, 300, 190));
        primaryStage.show();
    }
}
