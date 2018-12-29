package semestr1.pl.kozak;

public class Zad_pz3_03 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    3.Napisać funkcję, która w dwuwymiarowej tablicy liczb rzeczywistych (podanej przez parametr) znajduje najmniejszy
    element na pierwszej przekątnej (głównej, diagonalnej - ozn. pogrubienie) i najmniejszy na drugiej przekątnej (ozn.
    podkreślenie).
    Funkcja zwraca średnią arytmetyczną tych dwóch znalezionych wartości. Dodatkowo wyświetlony zostaje trzeci, co do
    wielkości, maksymalny element z całej tablicy.
     */
    public static void main(String[] args) {
        double[][] tab = {
                {0.12, 0.23, 0.17, 0.89, 1.00},
                {0.83, 0.25, 0.99, 0.46, 0.46},
                {0.21, 0.00, 0.63, 0.15, 0.71},
                {0.19, 0.04, 0.23, 0.38, 0.30},
                {0.38, 0.93, 0.11, 0.53, 0.06}
        };
        System.out.println("Wynik1: średnia arytmetyczna z max z przekątnych = " + findInTab(tab));
        System.out.println("Wynik2: trzecia najwieksza liczba z tablicy = " + findInTableThirdMax(tab));
    }

    private static double findInTab(double[][] inTab) {
        double minFirstDiagonal = inTab[0][0];
        double minSecondDiagonal = inTab[0][inTab.length - 1];
        double avgDiagonals = 0;
        int index = inTab[0].length - 1;
        for (int i = 0; i < inTab.length; i++) {
            for (int j = 0; j < inTab[0].length; j++) {
                if (i == j) {
                    if (inTab[i][j] < minFirstDiagonal) {
                        minFirstDiagonal = inTab[i][j];
                    }
                }
                if (inTab[i][index] < minSecondDiagonal) {
                    minSecondDiagonal = inTab[i][index];
                }
            }
            index--;
        }
        avgDiagonals = (minFirstDiagonal + minSecondDiagonal) / 2;
        return avgDiagonals;
    }

    private static double findInTableThirdMax(double[][] inTab) {
        double thirdMaxValue = 0;
        double[][] tab;
        int repeat = 2; // 2 ponieważ zwracamy 3 najwiekszy element
        tab = inTab;
        for (int i = 0; i < repeat; i++) {
            tab = replaceMaxWithMin(tab);
        }
        thirdMaxValue = findMaxInTab(tab);
        return thirdMaxValue;
    }

    private static double[][] replaceMaxWithMin(double[][] inTab) {
        double[][] outTab = new double[inTab.length][inTab[0].length];
        double max = findMaxInTab(inTab);
        double min = findMinInTab(inTab);
        for (int i = 0; i < inTab.length; i++) {
            for (int j = 0; j < inTab[0].length; j++) {
                if (inTab[i][j] == max) {
                    outTab[i][j] = min;
                } else {
                    outTab[i][j] = inTab[i][j];
                }
            }
        }
        return outTab;
    }

    private static double findMaxInTab(double[][] inTab) {
        double max = inTab[0][0];
        for (int i = 0; i < inTab.length; i++) {
            for (int j = 0; j < inTab[0].length; j++) {
                if (inTab[i][j] > max) {
                    max = inTab[i][j];
                }
            }
        }
        return max;
    }

    private static double findMinInTab(double[][] inTab) {
        double min = inTab[0][0];
        for (int i = 0; i < inTab.length; i++) {
            for (int j = 0; j < inTab[0].length; j++) {
                if (inTab[i][j] < min) {
                    min = inTab[i][j];
                }
            }
        }
        return min;
    }

}
