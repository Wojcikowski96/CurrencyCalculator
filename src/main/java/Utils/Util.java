package Utils;

import Main.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {
    /**
     * Dla każdej waluty wygenerowane zostały wyniki przeliczeń dla 4 kwot w pliku XML
     */
    public static List<Double> generatedCalculations = new ArrayList<>(Arrays.asList(
            130.37,12.80,61.67,0.22,
    1008.78,99.05,477.20,1.73,
    2770.58,272.03,1310.63,4.75,
    2242.84,220.22,1060.98,3.84,
    11045.46,1084.51,5225.07,18.93,
    935.19,91.82,442.39,1.60,
    4878.50,479.00,2307.78,8.36,
    195.07,19.15,92.28,0.33,
    449.75,44.16,212.76,0.77,
    180495.07,17722.09,85383.37,309.26,
    18332.47,1799.99,8672.20,31.41,
    628.60,61.72,297.36,1.08,
    113.53,11.15,53.71,0.19,
    2042510.36,200545.96,966211.56,3499.66,
    52912.75,5195.29,25030.43,90.66,
    7681.60,754.23,3633.79,13.16,
    2492.39,244.72,1179.03,4.27,
    18752.63,1841.25,8870.95,32.13,
    1088.89,106.91,515.10,1.87,
    998.64,98.05,472.41,1.71,
    138.77,13.63,65.65,0.24,
    177.22,17.40,83.83,0.30,
    616.84,60.56,291.80,1.06,
    262.54,25.78,124.19,0.45,
    1316.04,129.22,622.55,2.25,
    658.49,64.65,311.50,1.13,
    189.96,18.65,89.86,0.33,
    3268.09,320.88,1545.97,5.60,
    1390.67,136.54,657.86,2.38,
    215.38,21.15,101.89,0.37,
    704.02,69.13,333.04,1.21));
    public static boolean checkIfCurrencyCodeExists(Calculator c, String code) {
        return c.getCurrencies().get(code) != null;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
