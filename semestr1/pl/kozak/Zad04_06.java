package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferUnderflowException;

public class Zad04_06 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    6. Napisz program, który umożliwia szyfrowanie podanego ciągu znaków przy użyciu szyfru Cezara, który jest
    szczególnym przypadkiem szyfru podstawieniowego monoalfabetycznego.
    Użytkownik program podaje tekst do zaszyfrowania oraz liczbę n, o którą przesunięty jest alfabet za pomocą
    którego szyfrujemy tekst. Dla uproszczenia można przyjąć, że łańuch wejściowy składa się tylko z małych liter
    alfabetu angielskiego, tj. ’a’ – ’z’ (26 znaków) oraz spacji.
    Przykład 1.
    Podaj łańcuch znaków do zaszyfrowania: abrakadabraz
    Podaj przesunięcie: 2
    Zaszyfrowany tekst: cdtcmcfcdtcb
    Przykład 2.
    Podaj łańcuch znaków do zaszyfrowania: cdtcmcfcdtcb
    Podaj przesunięcie: -2
    Zaszyfrowany tekst: abrakadabraz
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Podaj tekst do zaszyfrowania:");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input = buff.readLine();
        System.out.println("Podaj przesunięcie [liczba całkowita dodatnia lub ujemna]:");
        int n = Integer.parseInt(buff.readLine());
        String alphabet = "abcdefghijklmnopqrstuvwxyz ";
        char sign;
        char newSign;
        int position = 0;
        for (int i = 0; i < input.length(); i++) {
            sign = input.charAt(i);
            for (int j = 0; j < alphabet.length(); j++) {
                if (sign == alphabet.charAt(j)) {
                    position = j;
                    break;
                }
            }
            if ((position + n) > 26) {
                position = position + n - 26;
                newSign = alphabet.charAt(position);
            } else if (position + n < 0) {
                position = position + n + 26;
                newSign = alphabet.charAt(position);
            } else {
                newSign = alphabet.charAt(position + n);
            }
            System.out.print(newSign);
        }
    }
}
