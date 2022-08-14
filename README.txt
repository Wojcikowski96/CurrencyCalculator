# CurrencyCalculator
Do realizacji wykorzystano javaFX.
Program działa w oparciu o wyskakujące okienko, gdzie należy wprowadzić kwotę do przeliczenia oraz kod waluty docelowej.
Kwotę można wprowadzić zarówno z przecinkiem jak i kropką.
Za pomocą przycisku "Przelicz" wynik zapisywany jest w polu "Wynik"
Obsłużono proste przypadki niepoprawności wprowadzanych danych za pomocą komunikatów, pojawiających się pod każdym polem, gdzie wprowadzane są dane.
Stworzono testy jednostkowe badające czy funkcja przeliczająca walutę działa poprawnie.
W tym celu wygenerowana została macierz poprawnych wyników dla każdego typu waluty dla 4 różnych kwot.
Testy sprawdzają także zachowanie funkcji obliczającej dla różnych typów argumentów.

##########################URUCHOMIENIE PROGRAMU SPOZA IDE###################################
Aby uruchomić program należy przejść katalogami out\artifacts\CurrencyCalculator
Następnie dwuklikiem wybrać plik z rozszerzeniem .jar

W przypadku niepoprawnej konfiguracji javy na urządzeniu powyższy sposób może się nie powieść
Alternatywnie można spróbować uruchomić skrypt RunApp.vbs znajdujący się w katalogu głównym projektu.
