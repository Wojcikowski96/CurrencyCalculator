Set WshShell = CreateObject("WScript.Shell")

dim a
a = "out\artifacts\CurrencyCalculator\CurrencyCalculator.jar"

WshShell.Run "java -jar "&chr(34)&a&chr(34)
