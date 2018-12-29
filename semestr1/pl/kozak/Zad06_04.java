package semestr1.pl.kozak;

import java.io.*;

public class Zad06_04 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    4. Stworzyć dwie funkcje:
    void szyfruj(String nazwaWe, int przesun)
    void deszyfruj(String nazwaWe, int przesun)
    Funkcja szyfruj dokonuje szyfrowania pliku, którego nazwa podana została jako pierwszy parametr.
    Szyfrowanie polega na zamianie każdej litery na znak przesunięty o wartość podaną drugim parametrem np.
    dla przesunięcia równego 2 literka ’a’ powinna zostać zastąpiona literką ’c’, literka ’z’ literką ’b’ itp.
    Wynikiem działania funkcji ma być plik o nazwie utworzonej na podstawie nazwy pliku wejściowego poprzez dołączenie znaku ’
    ’ np. dla pliku dane.txt zaszyfrowana postać powinna mieć nazwę dane.txt.
    Funkcja deszyfruj powinna deszyfrować plik (niekoniecznie ten sam) zaszyfrowany przez funkcję szyfruj.
     */
    public static void main(String[] args) {
        String inFile = "C:\\Projects_Java\\Semestr1\\src\\semestr1\\Plik.txt";
        String inFile2 = "C:\\Projects_Java\\Semestr1\\src\\semestr1\\_Plik.txt";
        szyfruj(inFile, 2);
        deszyfruj(inFile2, 2);
    }

    private static void szyfruj(String nazwaWe, int przesun) {
        String outFile = "C:\\Projects_Java\\Semestr1\\src\\semestr1\\_Plik.txt";
        String line;
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', '.', ',', '?', 'ś', 'ć', 'T', 'C'};
        char charToFind;
        char outChar;
        int indexOfChar;
        try (
                FileReader file = new FileReader(nazwaWe);
                BufferedReader buff = new BufferedReader(file);
                FileWriter outF = new FileWriter(outFile, false);
                BufferedWriter buufOut = new BufferedWriter(outF)
        ) {
            boolean eof = false;
            while (!eof) {

                line = buff.readLine();
                if (line == null) {
                    eof = true;
                } else {
                    for (int i = 0; i < line.length(); i++) {
                        indexOfChar = 0;
                        charToFind = line.charAt(i);
                        for (int j = 0; j < alphabet.length; j++) {
                            if (charToFind == alphabet[j]) {
                                indexOfChar = j;
                                break;
                            }
                        }
                        if ((indexOfChar + przesun) > alphabet.length - 1) {
                            indexOfChar = indexOfChar - alphabet.length;
                        }
                        outChar = alphabet[indexOfChar + przesun];
                        System.out.print(outChar);
                        buufOut.write(outChar);
                    }
                    buufOut.newLine();
                    System.out.println('\n');
                }
            }
            buufOut.close();
        } catch (IOException e) {
            System.out.println("File error!!");
        }
    }

    private static void deszyfruj(String nazwaWe, int przesun) {
        String outFile = "C:\\Projects_Java\\Semestr1\\src\\semestr1\\_Plik_odszyfrowany.txt";
        String line;
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', '.', ',', '?', 'ś', 'ć', 'T', 'C'};
        char charToFind;
        char outChar;
        int indexOfChar;
        try (
                FileReader file = new FileReader(nazwaWe);
                BufferedReader buff = new BufferedReader(file);
                FileWriter outF = new FileWriter(outFile, false);
                BufferedWriter buufOut = new BufferedWriter(outF)
        ) {
            boolean eof = false;
            while (!eof) {

                line = buff.readLine();
                if (line == null) {
                    eof = true;
                } else {
                    for (int i = 0; i < line.length(); i++) {
                        indexOfChar = 0;
                        charToFind = line.charAt(i);
                        for (int j = 0; j < alphabet.length; j++) {
                            if (charToFind == alphabet[j]) {
                                indexOfChar = j;
                                break;
                            }
                        }
                        if ((indexOfChar - przesun) < 0) {
                            indexOfChar = indexOfChar + alphabet.length;
                        }
                        outChar = alphabet[indexOfChar - przesun];
                        System.out.print(outChar);
                        buufOut.write(outChar);
                    }
                    buufOut.newLine();
                    System.out.println('\n');
                }
            }
            buufOut.close();
        } catch (IOException e) {
            System.out.println("File error!!");
        }
    }
}
