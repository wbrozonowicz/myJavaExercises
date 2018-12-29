package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zad05_03 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    3. Zdefiniować funkcjęint strpos(String text, char z), która zwraca indeks
    na którym znajduje się znak z (drugi parametr) w podanym łańcuchu text.
    Jeżeli znak z nie występuje w łańcuchu, to wynikiem funkcji powinno być -1.
    Uwaga - pozycje znaków numerujemy począwszy od 0.
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Wpisz dowolny ciąg znaków:");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input = buff.readLine();
        System.out.println("Podaj znak aby sprawdzić jaki ma indeks w podanym tekscie:");
        String sign = buff.readLine();
        char in = sign.charAt(0);
        int resPos = strpos(input, in);
        System.out.println("Znak ma indeks = " + resPos);
    }

    private static int strpos(String text, char z) {
        int position = -1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == z) {
                position = i;
                break;
            }
        }
        return position;
    }
}
