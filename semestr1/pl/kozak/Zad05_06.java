package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zad05_06 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    6. Zdefiniować funkcję int strToInt(String str), która zamienia liczbę całkowitą zapisaną w postaci łańcucha na liczbę całkowitą typu int.
    Funkcja powinna przerywać konwersję w momencie napotkania pierwszego znaku nie należącego do zapisu liczby, zatem np.
    dla strToInt("-13krowa") wynikiem powinno być -13.
    Pozostałe przykłady:
    strToInt("+12") - wynik 12
    strToInt("0001") - wynik 1
    strToInt("991-234-23") - wynik 991
    strToInt("+zonk") - wynik 0
    strToInt("") - wynik 0
    strToInt("-12e5") - wynik -12*10^5 = -120000
    strToInt("-12e-5") - wynik -12, tylko dodatnie wykładniki są rozpatrywane
     */

    public static void main(String[] args) throws IOException {
        System.out.println("Podaj ciąg do konwersji na liczbę int:");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input = buff.readLine();
        int result = strToInt(input);
        System.out.println("Wynik to " + result);
    }

    public static int strToInt(String str) {
        int out;
        String outText = "";
        int start;
        int powerN = 0;
        boolean isPow = false;

        if (str.substring(0, 1).equals("+") || str.substring(0, 1).equals("-")) {
            start = 1;
            outText = str.substring(0, 1);
        } else {
            start = 0;
        }

        for (int i = start; i < str.length(); i++) {
            if (!isNumber(str.substring(i, i + 1))) {
                if (i == str.length() - 1) {
                    break;
                }
                if (!isNumber(str.substring(i, i + 1)) && !str.substring(i, i + 1).equals("e")) {
                    break;
                }
                if (isNumber(str.substring(i - 1, i)) && isNumber(str.substring(i + 1, i + 2)) && str.substring(i, i + 1).equals("e") && (i < str.length() - 1)) {
                    // e
                    powerN = Integer.parseInt(str.substring(i + 1, i + 2));
                    isPow = true;
                    break;
                } else {
                    break;
                }
            } else {
                outText = outText + str.substring(i, i + 1);
            }
        }
        if (isNumber(outText)) {
            out = Integer.parseInt(outText);
            if (isPow) {
                out = out * powerTen(powerN);
            } else {
            }
        } else {
            out = -1;
        }
        return out;
    }

    public static boolean isNumber(String z) {
        int number;
        try {
            number = Integer.parseInt(z);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static int powerTen(int n) {
        int res = 10;
        for (int i = 1; i < n; i++) {
            res = res * 10;
        }
        return res;
    }
}
