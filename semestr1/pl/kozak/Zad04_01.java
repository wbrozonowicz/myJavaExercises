package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferUnderflowException;

public class Zad04_01 {
    /*
    1. Napisać program, który wczytuje od użytkownika ciąg znaków, a następnie wyświetla informację o tym ile razy
    w tym ciągu powtarza się jego ostatni znak. Przykład, dla ciągu „Abrakadabra” program powinien wyświetlić 4,
    ponieważ ostatnim znakiem jest literka „a”, która występuje w podanym ciągu łącznie 4 razy.
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Podaj dwolny ciąg znaków: ");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input = buff.readLine();
        char sign = input.charAt(input.length() - 1);
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (sign == input.charAt(i)) {
                count++;
            }
        }
        System.out.println("Ostatni znak to: " + sign + " i występuje w ciągu " + count + " razy.");
    }
}
