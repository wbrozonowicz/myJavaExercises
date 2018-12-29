package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Zad_pz3_02 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    2. Napisać program, który wczytuje od użytkownika liczby, do momentu aż zostanie podana liczba 0. Następnie losuje
    tyle liczb z zakresu [-150, 150], ile wcześniej zostało podanych przez użytkownika. W wyniki działania programu należy
    wyświetlić stosunek średniej arytmetycznej liczb parzystych podanych przez użytkownika do średniej arytmetycznej
    wylosowanych liczb nieparzystych.
    Zadanie należy wykonać beż użycia tablic.
    Przykład:
    Użytkownik: 4    -2    3    6    0
    Losowanie: 12    33    -1    124
    Wynik:
    0,16666   //  ( ( 4 + -2 + 6 ) / 3 ) / ( ( 33 + -1 ) / 2 ) = 2,66666 / 16
     */

    public static void main(String[] args) throws IOException {
        int number = 1;
        int randomNumber = 0;
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int count = 0;
        int sumPos = 0;
        int countPos = 0;
        int sumNeg = 0;
        int countNeg = 0;
        double avgPos;
        double avgNeg;
        double ratio;
        Random rn = new Random();
        while (number != 0) {
            System.out.println("Podaj liczbę lub 0 aby przejść do losowania");
            input = buff.readLine();
            number = Integer.parseInt(input);
            if (number != 0) {
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            randomNumber = rn.nextInt(301) - 150;
            System.out.println("Wylosowana liczba nr " + (i + 1) + ": " + randomNumber);
            if (randomNumber > 0) {
                sumPos += randomNumber;
                countPos++;
            }
            if (randomNumber < 0) {
                sumNeg += randomNumber;
                countNeg++;
            }
        }
        avgPos = (double) sumPos / countPos;
        avgNeg = (double) sumNeg / countNeg;
        ratio = avgPos / avgNeg;
        System.out.println("Suma parzystych = " + sumPos + " " + countPos);
        System.out.println("Suma parzystych = " + sumNeg + " " + countNeg);
        System.out.println("Stosunek średniej arytmetycznej liczb przystych do średniej arytmetycznej liczb nieparzystych wynosi = " + ratio);
    }
}
