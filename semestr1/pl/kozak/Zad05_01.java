package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zad05_01 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    1.Napisz funkcję, która zwraca wartość silni dla podanej liczby n. Funkcja powinna być napisana w dwóch wersjach:
    iteracyjnej i rekurencyjnej.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Podaj n silni:");
        int n = Integer.parseInt(buff.readLine());
        silnia(n);
        int wyn = silniaRekurencja(n);
        System.out.println("Rekurencja = " + wyn);
    }

    private static int silnia(int inN) {
        int res = 1;
        for (int i = 1; i <= inN; i++) {
            res *= i;
        }
        System.out.println("Silnia  dla podanego n = " + inN + " wynosi = " + res);
        return res;
    }

    private static int silniaRekurencja(int inN) {
        int n = inN;
        int sum = 0;
        if (n > 0) {
            sum = n * silniaRekurencja(n - 1);
            return sum;
        } else {
            return 1;
        }
    }
}


