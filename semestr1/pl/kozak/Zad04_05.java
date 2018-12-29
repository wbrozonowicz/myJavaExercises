package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zad04_05 {
    /*
    5. Napisz program, który sprawdzi, czy w podanym przez użytkownika wyrażeniu
    arytmetycznym nawiasy są poprawnie sparowane. Wyrażenie podawane jest jako
    pojedynczy łańcuch znaków. Program powinien wyświetlić stosowny komunikat.
    Przykład a:
    "2 * (3.4 - (-7)/2)*(a-2)/(b-1)))"
    Wynik:
    Błędne sparowanie nawiasów
    Przykład b:
    "2 * (3.4 - (-7)/2)*(a-2)/(b-1))"
    Wynik:
    OK
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Wpisz fragment kodu z nawiasami:");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input = buff.readLine();
        int countLeft = 0;
        int countRight = 0;
        char sign;
        for (int i = 0; i < input.length(); i++) {
            sign = input.charAt(i);

            if (sign == '(') {
                countLeft++;
            }
            if (sign == ')') {
                countRight++;
            }
        }
        if (countLeft == countRight) {
            System.out.println("Nawiasy poprawnie sparowane");
        } else {
            System.out.println("Błąd w sparowaniu nawiasów");
        }
    }
}
