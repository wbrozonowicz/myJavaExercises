package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zad05_13 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    13. Napisać funkcję
    String poprzestawiaj(String tekst, int [] kolejnosc)
    ,której wynikiem jest łańcuch złożony ze znaków w zmiennej tekst ułożonych wg kolejności podanej w tablicy kolejnosc,
    tzn. i-ty znak tekstu powinien znaleźć się w wynikowym łańcuchu na pozycji kolejnosc[i].
    Przykład, dla poniższego wywołania funkcji:
    String tekst = "Egzamin";
    int [] kol = { 0, 1, 4, 3, 2, 6, 5 };
    System.out.println(poprzestawiaj(tekst, kol));
    wynikiem powinien być łańcuch: Egmazni
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Podaj zdanie do poprzestawiania:");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input = buff.readLine();
        int [] kol = { 0, 1, 4, 3, 2, 6, 5 };
        System.out.println(poprzestawiaj(input,kol));
    }

   private static String poprzestawiaj(String tekst, int [] kolejnosc){
        String[] output = new String[tekst.length()];
        String totalString="";
       for (int i = 0; i < tekst.length(); i++) {
            output[i]=tekst.substring(kolejnosc[i],kolejnosc[i]+1);
            totalString+=output[i];
       }
        return  totalString;
   }
}
