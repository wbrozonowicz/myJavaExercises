package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zad05_07 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    7. Zdefiniować funkcję int strfind(String gdzie, String co), która szuka łańcucha co w łańcuchu gdzie
    i jeżeli go znajdzie, to jej wynikiem jest pozycja, na której ten łańcuch zaczyna się w łańcuchu gdzie.
    Jeżeli nie udało się znaleźć łańcucha to wtedy wynikiem ma być -1.
    Przykłady:
    strfind("Ala ma kota", "ma") - wynik to 4
    strfind("Ala ma kota", "Ala ma kota") - wynik to 0
    strfind("Ala ma kota", "") - wynik to 0, bo pusty łańcuch jest podłańcuchem każdego innego łańcucha
    strfind("Pies", "jakis napis") - wynik to -1
    strfind("Ala ma kota", "pies") - wynik to -1
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Podaj tekst przeszukiwany:");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input = buff.readLine();
        System.out.println("Podaj ciąg do odszukania:");
        String text = buff.readLine();
        int result;
        result = strfind(input, text);
        System.out.println(result);
    }

    private static int strfind(String gdzie, String co) {
        int pos = 0;
        if (co.equals("")) {
            return 0;
        }
        if (gdzie.contains(co)) {
            for (int i = 0; i < (gdzie.length() - co.length() + 1); i++) {
                if (gdzie.substring(i, i + co.length()).equals(co)) {
                    pos = i;
                    break;
                }
            }
            return pos;
        } else
            return -1;
    }
}

