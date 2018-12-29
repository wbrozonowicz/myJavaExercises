package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zad05_08 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    8. Napisać funkcję int wordCount(String text),której wynikiem jest liczba wszystkich słów występujących w podanym jako parametr tekście.
    Do sprawdzania, czy dany znak tekstu jest „białym znakiem” można zastosować metodę Character.isWhitespace.
    Za słowo przyjmujemy każdy ciąg znaków niezawierający białego znaku.
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Podaj zdanie do policzenia słów:");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String sentence = buff.readLine();
        int countW = wordCount(sentence);
        System.out.println(countW);
    }

   private static int wordCount(String text) {
        int countWhiteS = 0;
        for (int i = 1; i < text.length() - 1; i++) {
            if (text.substring(i, i + 1).equals(" ")) {
                countWhiteS++;
            }
        }
        return countWhiteS + 1;
    }
}
