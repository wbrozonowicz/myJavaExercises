package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zad05_10 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    10. Zdefiniować funkcję
    int strFindAndCount(String gdzie, String co), która zlicza wystąpienia łańcucha co w łańcuchu gdzie.
    Jej wynikiem jest wyznaczona liczba wystąpień. Jeżeli nie udało się znaleźć łańcucha,
    to wtedy wynikiem jest, oczywiście, 0.
    Przykłady:
    strFindAndCount("Ala ma kota", "ma") - wynik to 1
    strFindAndCount("mama ma kota", "ma") - wynik to 3
    strFindAndCount("Ala mmaa ma kota", "ma") - wynik to 2
    strFindAndCount("Ala ma kota", "Asia") - wynik to
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Podaj zdanie do analizy:");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input = buff.readLine();
        System.out.println("Podaj ciąg do odszukania:");
        String word = buff.readLine();
        int res = strFindAndCount(input, word);
        System.out.println("Wynik to " + res);

    }

    public static int strFindAndCount(String gdzie, String co) {
        int count = 0;

        for (int i = 0; i < gdzie.length() - co.length() + 1; i++) {
            if (gdzie.substring(i, i + co.length()).equals(co)) {
                count++;
            }
        }
        return count;
    }
}
