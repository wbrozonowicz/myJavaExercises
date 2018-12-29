package semestr1.pl.kozak;

import java.util.Random;

public class Zad_e_01 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    1. Napisać program, który tworzy dwuwymiarową tablicę liczb całkowitych o losowej wielkości (wylosowanej z
    zakresu [10, 20]), gdzie liczba wierszy jest taka sama, jak liczba kolumn.
    Następnie tablica zostaje uzupełniona liczbami losowymi z zakresu [-100, 100], z wyjątkiem elementów
    znajdujących się na przekątnej tablicy, które w (losowo) ok. 50% przypadków otrzymują wartość 1, a w
    pozostałych 50% przypadków wartość -1. W wyniku działania programu należy wyświetlić na ekran:
    • dwie największe liczby zapisane w tabeli,
    • stosunek sumy liczb leżących w komórkach tablicy o parzystych indeksach wierszy i nieparzystych indeksach kolumn,
    • liczbę komórek, których wartość jest mniejsza od iloczynu indeksu wiesza i kolumny tej komórki.
    Uwaga, nie należy używać (importować) żadnych dodatkowych bibliotek,poza klasą niezbędną do obsługi losowania liczb
     */
    public static void main(String[] args) {
        Random ram = new Random();
        int size = ram.nextInt(11) + 10;
        System.out.println("Wielkość tablicy = " + size);
        int[][] tab = new int[size][size];
        int inNumber = 0;
        int sumOfPos = 0;
        int sumOfNeg = 0;
        double ratio = 0;
        int multipliy = 0;
        int count = 0;
        boolean inNumberDiagonal = true;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                multipliy = i * j;
                if (isDiagonal(i, j, size)) {
                    inNumberDiagonal = ram.nextBoolean();
                    if (inNumberDiagonal) {
                        inNumber = 1;
                    } else {
                        inNumber = -1;
                    }
                } else {
                    inNumber = ram.nextInt(201) - 100;
                }
                tab[i][j] = inNumber;
                if (tab[i][j] < multipliy) {
                    count++;
                }
                System.out.print(tab[i][j] + "\t");
                if (i % 2 == 0) {
                    sumOfPos += tab[i][j];
                }
                if (j % 2 != 0) {
                    sumOfNeg += tab[i][j];
                }
            }
            System.out.print("\n");
        }
        int max1 = findMax(tab);
        int min = findMin(tab);
        int[][] tab2 = replaceInTab(max1, min, tab);
        int max2 = findMax(tab2);
        System.out.println("Wyniki:");
        System.out.println("1. Dwie największe liczby to " + max1 + " oraz " + max2);
        ratio = (double) sumOfPos / sumOfNeg;
        System.out.println("2. Stosunek wynosi = " + ratio);
        System.out.println("3. Ilość liczb mniejszych od iloczynu indeksów = " + count);
    }

    static boolean isDiagonal(int a, int b, int c) {
        // a index i, b index j, c size
        if ((a == b) || (a + b) == (c - 1)) {
            return true;
        } else {
            return false;
        }
    }

    static int findMax(int[][] tab) {
        int max = tab[0][0];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if (tab[i][j] > max) {
                    max = tab[i][j];
                }
            }
        }
        return max;
    }

    static int findMin(int[][] tab) {
        int min = tab[0][0];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if (tab[i][j] < min) {
                    min = tab[i][j];
                }
            }
        }
        return min;
    }

    static int[][] replaceInTab(int value, int min, int[][] tab) {
        int[][] outTab = new int[tab.length][tab[0].length];
        for (int i = 0; i < outTab.length; i++) {
            for (int j = 0; j < outTab.length; j++) {
                if (tab[i][j] == value) {
                    outTab[i][j] = min;
                } else {
                    outTab[i][j] = tab[i][j];
                }
            }
        }
        return outTab;
    }
}
