package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zad03_04 {
    /*
    9. Napisz program, który pobiera od użytkownika dodatnią liczbę naturalną n
    i tworzy tablicę a zmiennych typu logicznego (boolean) o rozmiarze n × n .
    Następnie program powinien wypełnić utworzoną tablicę, tak by a[i][j] = true jeżeli liczby (i+1) oraz (j+1) są względnie pierwsze,
    tzn. nie mają wspólnych dzielników poza 1.
    Tak utworzoną tablicę należy wypisać na ekranie, przy czym dla wartości true należy wyświetlić znak ”+”,
    natomiast dla wartości false znak ”.”. Przykład:
    Podaj liczbę (> 0): 10
    1  2  3  4  5  6  7  8  9 10
    1  +  +  +  +  +  +  +  +  +  +
    2  +  .  +  .  +  .  +  .  +  .
    3  +  +  .  +  +  .  +  +  .  +
    4  +  .  +  .  +  .  +  .  +  .
    5  +  +  +  +  .  +  +  +  +  .
    6  +  .  .  .  +  .  +  .  .  .
    7  +  +  +  +  +  +  .  +  +  +
    8  +  .  +  .  +  .  +  .  +  .
    9  +  +  .  +  +  .  +  +  .  +
    10  +  .  +  .  .  .  +  .  +  .
     */

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Podaj liczbę całkowitą > 0 :");
        int number = Integer.parseInt(buff.readLine());
        int[] dzielnikiI = new int[number];
        int[] dzielnikiJ = new int[number];
        int liczbaA = 0;
        int liczbaB = 0;
        int checkNumber = 0;
        String sign = "x";
        boolean[][] matrixBool = new boolean[number][number];
        for (int i = 0; i < matrixBool.length; i++) {
            for (int j = 0; j < matrixBool[0].length; j++) {
                matrixBool[i][j] = true;
            }
        }
        for (int i = 0; i < dzielnikiI.length; i++) {
            dzielnikiI[i] = 1;
        }
        for (int i = 0; i < dzielnikiJ.length; i++) {
            dzielnikiJ[i] = 1;
        }
        for (int i = 0; i <= number; i++) {
            for (int j = 0; j <= number; j++) {
                if (i == 0 && j == 0) {
                    System.out.print(" " + "\t");
                } else if (i == 0) {
                    System.out.print(j + "\t"); // nr kolumny
                } else if (j == 0) {
                    System.out.print(i + "\t"); // nr wiersza
                } else { // kod dla komórki
                    for (int k = 0; k < dzielnikiI.length; k++) {
                        dzielnikiI[k] = 1;
                        dzielnikiJ[k] = 1;
                    }
                    liczbaA = i;
                    liczbaB = j;
                    for (int k = 1; k <= i; k++) {
                        if (liczbaA % k == 0) {
                            dzielnikiI[k - 1] = k;
                        } else {
                            dzielnikiI[k - 1] = 1;
                        }
                    }
                    for (int k = 1; k <= j; k++) {
                        if (liczbaB % k == 0) {
                            dzielnikiJ[k - 1] = k;
                        } else {
                            dzielnikiJ[k - 1] = 1;
                        }
                    }
                    for (int k = 0; k < dzielnikiI.length; k++) {
                        checkNumber = dzielnikiI[k];
                        if (checkNumber != 1) {
                            for (int l = 0; l < dzielnikiJ.length; l++) {
                                if (checkNumber == dzielnikiJ[l]) {
                                    matrixBool[i - 1][j - 1] = false;
                                    break;
                                }
                            }
                        }
                    }
                    if (matrixBool[i - 1][j - 1]) {
                        sign = "+";
                    } else {
                        sign = ".";
                    }
                    System.out.print(sign + "\t");
                }
            }
            System.out.println(" ");
        }
    }
}

