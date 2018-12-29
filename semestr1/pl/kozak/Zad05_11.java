package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zad05_11 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    11. Zdefiniować procedurę String strcut(String str, int start, int ile) ,
    która wycina z podanego łańcucha wszystko co znajduje się w podanym zakresie.
    Wynikiem funkcji powinien być łańcuch bez znaków znajdujących się na pozycjach od start do start+ile-1.
    Przykłady:
    strcut("Ala ma kota", 4, 3) - wynik to "Ala kota"
    strcut("Ala ma kota", 0, 4) - wynik to "ma kota"
    strcut("Ala ma kota", 0, 11) - wynik to ""
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Podaj tekst do wycięcia:");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input = buff.readLine();
        System.out.println("Podaj indeks początku ciągu do wycięcia:");
        int s1 = Integer.parseInt(buff.readLine());
        System.out.println("Podaj indeks końca ciągu do wycięcia:");
        int s2 = Integer.parseInt(buff.readLine());
        String res = strcut(input, s1, s2);
        System.out.println(res);
    }

    public static String strcut(String str, int start, int ile) {
        String output;
        if (start >= 0 && start < str.length() && ile >= 0 && ile < str.length()) {
            String out1 = str.substring(0, start - 1);
            String out2 = str.substring(start + ile - 1, str.length());
            output = out1 + out2;
        } else {
            output = "";
        }
        return output;
    }
}
