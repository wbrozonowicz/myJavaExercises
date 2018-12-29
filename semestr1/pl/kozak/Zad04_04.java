package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zad04_04 {
    /*
    4. Napisać program, który sumuje cyfry w tekście podanym przez użytkownika.
    Przykład:
    "Ala ma 1 psa i 2 koty. Jola ma 10 rybek i 2 papugi."
    Wynik:
    6
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Wpisz dowolne zdanie zawierające jedną lub więcej cyfr:");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input = buff.readLine();
        String sign;
        int sum = 0;
        int number;
        for (int i = 0; i < input.length(); i++) {
            sign = input.charAt(i) + "";
            number = 0;
            try {
                number = Integer.parseInt(sign);
            } catch (Exception e) {
            }
            sum += number;
        }
        System.out.println("Wynik= " + sum);
    }
}
