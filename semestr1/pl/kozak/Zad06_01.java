package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Zad06_01 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    1. Napisać funkcję liczZnakiSlowa, która zlicza:
    • liczbę znaków w pliku,
    • liczbę białych znaków w pliku (białe znaki to spacja, tabulator, znacznik końca wiersza),
    • liczbę słów w pliku.
    Wynikiem funkcji jest tablica złożona z 3 liczb całkowitych po jednej dla wymienionych podpunktów.
     */
    public static void main(String[] args) {
        // file
        String inFile = "C:\\Projects_Java\\Semestr1\\src\\semestr1\\File.txt";
        int[] out = new int[3];
        out = liczZnakiSlowa(inFile);
        for (int i = 0; i < out.length; i++) {
            System.out.println(out[i]);
        }
    }

    private static int[] liczZnakiSlowa(String fileName) {
        int[] res = new int[3];
        int charactercTotal = 0;
        int whiteCharCount = 0;
        int wordCount = 0;
        char x;
        try (
                FileReader file = new FileReader(fileName);
                BufferedReader buff = new BufferedReader(file)
        ) {
            boolean eof = false;
            while (!eof) {
                String line = buff.readLine();
                if (line == null) {
                    eof = true;
                } else {
                    charactercTotal += line.length();
                    System.out.println(line);
                    for (int i = 0; i < line.length(); i++) {
                        x = line.charAt(i);
                        if (Character.isWhitespace(x)) {
                            whiteCharCount++;
                        } else {
                            if (i == 0) {
                                wordCount++;
                            }
                            if (i > 0 && Character.isWhitespace(line.charAt(i - 1))) {
                                wordCount++;
                            }
                        }
                    }

                }
            }
            res[0] = charactercTotal;
            res[1] = whiteCharCount;
            res[2] = wordCount;
        } catch (IOException ioe) {
            System.out.println("File error!");
        }
        return res;
    }
}
