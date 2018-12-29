package semestr1.pl.kozak;

import java.util.Random;

public class Zad03_03 {
    /*
    3. Napisz program, który:
    • stworzy tablicę (macierz) 5 x 5 liczb całkowitych,
    • wypełnij ją losowymi wartościami z zakresu {−5,−4, . . . ,5},
    • dla każdej kolumny wyznacz minimum,
    • dla każdej kolumny wyznaczy maksimum.
    Program ma wyświetlać tablicę wypełnioną liczbami oraz tablice z minimami oraz maksymami.
     */
    public static void main(String[] args) {
        System.out.println("Wylosowana macierz");
        int size = 5;
        int[][] matrixInt = new int[size][size];
        int[] minColumn = new int[size];
        int[] maxColumn = new int[size];
        Random rm = new Random();
        for (int i = 0; i < matrixInt.length; i++) {
            for (int j = 0; j < matrixInt[0].length; j++) {
                matrixInt[i][j] = rm.nextInt(10) - 5;
                System.out.print(matrixInt[i][j] + "\t");
            }
            System.out.println("");
        }
        for (int i = 0; i < minColumn.length; i++) {
            minColumn[i] = matrixInt[0][i];
            maxColumn[i] = matrixInt[0][i];
            for (int j = 0; j < matrixInt.length; j++) {
                if (matrixInt[j][i] < minColumn[i]) {
                    minColumn[i] = matrixInt[j][i];
                }
                if (matrixInt[j][i] > maxColumn[i]) {
                    maxColumn[i] = matrixInt[j][i];
                }
            }
        }
        System.out.println("Minima z kolumn to:");
        for (int i = 0; i < minColumn.length; i++) {
            System.out.print(minColumn[i] + "\t");
        }
        System.out.println("");
        System.out.println("Maxima z kolumn to:");
        for (int i = 0; i < minColumn.length; i++) {
            System.out.print(maxColumn[i] + "\t");
        }
    }
}
