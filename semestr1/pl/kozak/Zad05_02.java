package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zad05_02 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    2. Napisz funkcję, która zwraca wartość n -tego wyrazu ciągu Fibonacciego. Funkcja
    po  winna być napisana w dwóch wersjach: iteracyjnej i rekurencyjnej.
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Podaj numer n elementu z ciągu Fibonacciego:");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buff.readLine());
        int wynik = fibo(n);
        System.out.println(wynik);
        int wynikRek = fiboRekurencja(n);
        System.out.println(wynikRek);
    }

    private static int fibo(int inN) {
        int[] ciagFibo = new int[inN + 1];
        for (int i = 0; i <= inN; i++) {
            if (i == 0) {
                ciagFibo[i] = 1;
            } else if (i == 1) {
                ciagFibo[i] = 2;
            } else {
                ciagFibo[i] = ciagFibo[i - 2] + ciagFibo[i - 1];
            }
        }
        for (int a : ciagFibo) {
            System.out.print(a + "\t");
        }
        System.out.println("");
        return ciagFibo[inN];
    }

   private static int fiboRekurencja(int inN) {
        if (inN == 0) {
            return 1;
        } else if (inN == 1) {
            return 2;
        } else {
            return (fiboRekurencja(inN - 2) + fiboRekurencja(inN - 1));
        }
    }
}
