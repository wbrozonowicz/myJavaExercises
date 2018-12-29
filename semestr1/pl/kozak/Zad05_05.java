package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zad05_05 {
    /*
     Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    5.Zdefiniować funkcję boolean startsWith(String str1, String str2),która sprawdza, czy łańcuch str2
    jest prefiksem łańcucha str1.
    Przykłady:
    startsWith("Alibaba", "Ali") - wynik true, ponieważ wyraz "Alibaba" zaczyna się wyrazem "Ali".
    startsWith("Alibaba", "Alibaba") - wynik true, ponieważ wyraz jest zawsze swoim prefiksem.
    startsWith("Kot", "Pies") - wynik false, ponieważ wyraz "Pies" nie jest prefiksem wyrazu "Kot"
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Podaj wyraz do sprawdzenia:");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input = buff.readLine();
        System.out.println("Podaj prefiks do sprawdzenia");
        String prefixIn = buff.readLine();
        boolean checked = startsWith(input, prefixIn);
        System.out.println("Wynik sprawdzenia to: " + checked);
    }

    private static boolean startsWith(String str1, String str2) {
        if (str2.substring(0, 3).equals(str1.substring(0, 3))) {
            return true;
        } else {
            return false;
        }
    }
}
