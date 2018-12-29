package semestr1.pl.kozak;

import java.io.*;

public class Zad06_02 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    2. Napisać funkcję:
    public static void szukaj(String nazwaPlikWe, String nazwaPlikWy, String slowo)
    której zadaniem jest znalezienie wszystkich wierszy w pliku, które zawierają
    szukane słowo. Wszystkie wiersze, które zawierają słowo powinny zostać zapisane w
    pliku wynikowym wraz z nr wiersza (z pierwszego pliku). Nazwa pierwszego pliku zapamiętana jest w parametrze
    nazwaPlikWe, nazwa pliku wynikowego podana jest w parametrze nazwaPlikWy, natomiast szukane słowo w parametrze
    slowo.
    Przykład - plik wejściowy:
    Ala ma jutro egzamin z biologii.
    Jan myje auto.
    Eh, jutro kolejny egzamin.
    Nie lubie polityki.
    Jeżeli szukanym słowem byłoby ”egzamin”, to plik wynikowy powinien wyglądać następująco:
    1: Ala ma jutro egzamin z biologii.
    3: Eh, jutro kolejny egzamin.
     */
    public static void main(String[] args) {
        String fileIn = "C:\\Projects_Java\\Semestr1\\src\\semestr1\\File.txt";
        String fileOut = "C:\\Projects_Java\\Semestr1\\src\\semestr1\\FileOut.txt";
        String wortToFind = "auto";
        szukaj(fileIn, fileOut, wortToFind);
    }

    public static void szukaj(String nazwaPlikWe, String nazwaPlikWy, String slowo) {
        try (FileReader file = new FileReader(nazwaPlikWe)) {
            BufferedReader buff = new BufferedReader(file);
            String line;
            String outLine;
            boolean isInLine;
            boolean eof = false;
            int lineNumber = 0;
            FileWriter fileOut = new FileWriter(nazwaPlikWy, true);
            BufferedWriter buffW = new BufferedWriter(fileOut);
            while (!eof) {
                line = buff.readLine();
                if (line == null) {
                    eof = true;
                } else {
                    lineNumber++;
                    isInLine = false;
                    for (int i = 0; i <= line.length() - slowo.length(); i++) {
                        if (slowo.equals(line.substring(i, i + slowo.length()))) {
                            isInLine = true;
                            outLine = lineNumber + ": " + line;
                            buffW.write(outLine);
                            buffW.newLine();
                        }
                    }
                }
            }
            buffW.close();
        } catch (IOException ioe) {
            System.out.println("File error!!!");
        }
    }
}
