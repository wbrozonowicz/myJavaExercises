package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zad05_09 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    9. Napisać funkcję String[] podzielNaSlowa(String tekst),która dzieli podany tekst na słowa i zapisuje je w tablicy.
    Wynikiem funkcji jest tablica zawierające kolejno słowa z tekstu. Za słowo przyjmujemy każdy ciąg znaków niezawierający białego znaku.
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Podaj tekst do podzielenia:");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input = buff.readLine();

        String[] res = podzielNaSlowa(input);
        for (int i = 0; i < res.length; i++) {
            if (res[i] != null) {
                System.out.println(res[i]);
            }
        }

    }

   private static String[] podzielNaSlowa(String tekst) {
        String[] output = new String[tekst.length()];
        String wordRead = "";
        int index = 0;
        for (int i = 0; i < tekst.length(); i++) {
            if (tekst.substring(i, i + 1).equals(" ") || tekst.substring(i, i + 1).equals(".") || tekst.substring(i, i + 1).equals(",")) {
                if (!wordRead.equals("")) {
                    output[index++] = wordRead;
                    wordRead = "";
                }
            } else {
                wordRead += tekst.substring(i, i + 1);
                if (i == tekst.length() - 1) {
                    output[index++] = wordRead;
                }
            }
        }
        return output;
    }
}
