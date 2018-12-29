package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zad04_02 {
    /*
    2. Napisać program, który wczytuje od użytkownika ciąg znaków, a następnie tworzy łańcuch będący odwróceniem
    podanego łańcucha i wyświetla go na ekranie. Przykładowo, dla łańcucha „Kot” wynikiem powinien być łańcuch „toK”.
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Podaj dowolny ciąg znaków:");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input = buff.readLine();
        String output = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            output = output + input.charAt(i);
        }
        System.out.println(output);
    }
}
