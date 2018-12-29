package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zad05_04 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    4.Napisać funkcję String flipCase(String text), która zamieni małe litery na duże i odwrotnie w łańcuchu podanym jako parametr.
    Wynikiem ma być łańcuch znaków zawierający kopię łańcucha po zmianie wielkości liter.
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Podaj dowolny tekst z małej litery");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input = buff.readLine();
        String output = flipCase(input);
        System.out.println(output);
    }

    private static String flipCase(String text) {
        String out = text.toUpperCase();
        return out;
    }
}
