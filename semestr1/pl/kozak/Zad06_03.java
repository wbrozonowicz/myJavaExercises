package semestr1.pl.kozak;

import java.io.*;

public class Zad06_03 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    3.Napisać funkcję public static void sumujIZapisz(String nazwaPliku), która odczytuje plik o podanej nazwie
    zawierający liczby całkowite (po jednej w wierszu). Funkcja ma za zadanie odczytać i zsumować wszystkie liczby
    z pliku, a następnie dopisać na końcu pliku wyznaczoną sumę powiększoną o 1. Ponowne uruchomienia funkcji będą
    skutkowały dopisywaniem kolejnych wierszy. Jeżeli plik nie istnieje to ma zostać utworzony – suma dla pustego
    pliku wyniesie 0, a więc należy dopisać wiersz zawierający 1.
    */
    public static void main(String[] args) {
        String fileOut = "C:\\Projects_Java\\Semestr1\\src\\semestr1\\Numbers.txt";
        sumujIZapisz(fileOut);
    }

    public static void sumujIZapisz(String nazwaPliku) {
        try (
                FileWriter fileOut = new FileWriter(nazwaPliku, true);
                BufferedWriter buffOut = new BufferedWriter(fileOut);
                FileReader file = new FileReader(nazwaPliku);
                BufferedReader buff = new BufferedReader(file)
        ) {
            boolean eof = false;
            String line;
            int numberIn;
            int sum = 0;
            int lineCount = 0;
            while (!eof) {
                line = buff.readLine();
                if (line == null && (lineCount == 0)) {
                    eof = true;
                    buffOut.write(1 + "");
                    buffOut.newLine();
                } else if (line == null) {
                    buffOut.write(sum + 1 + "");
                    buffOut.newLine();
                    buffOut.close();
                    eof = true;
                } else {
                    numberIn = Integer.parseInt(line);
                    sum += numberIn;
                    lineCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("FileError");
        }
    }
}
