package semestr1.pl.kozak;

import java.io.*;

public class Zad06_05 {

    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    Napisać funkcję emerytura(String nazwaPliku), która wczyta z pliku o podanej
    nazwie dane pracowników zapisane w kolejnych wierszach w następujący sposób:
    Imię Nazwisko Płeć Wiek
    Przykład:
    Tomasz Nowak M 45
    Marta Ziobro K 42
    Jan Kowalski M 27
    Ewelina Tusk K 59
    Następnie funkcja dla każdego pracownika powinna wyznaczyć ile lat pozostało
    do jego emerytury. Wyniki należy zapisać w następujący sposób:
    Nazwisko Imię ”Lata do emerytury”
    Przykład:
    Nowak Tomasz 20
    Kowalski Jan 38
    Wyniki dla kobiet należy zapisać w pliku o nazwie ”kobiety.txt”, natomiast wyniki
    dla mężczyzn należy zapisać w pliku ”mezczyzni.txt”.
    */

    public static void main(String[] args) {
        String fileName = "AllWorkers.txt";
        emerytura(fileName);
    }

    public static void emerytura(String nazwaPliku) {
        String line;
        try (
                FileReader file = new FileReader(nazwaPliku);
                BufferedReader buff = new BufferedReader(file);
                FileWriter fileOut = new FileWriter("mezczyzni.txt", false);
                BufferedWriter buffOut = new BufferedWriter(fileOut);
                FileWriter fileOut2 = new FileWriter("kobiety.txt", false);
                BufferedWriter buffOut2 = new BufferedWriter(fileOut2);
        ) {
            boolean eof = false;
            String name;
            String surname;
            String sex;
            int age;
            int toRetirement;
            int[] indexes = new int[3]; // indeksy białych znaków
            int countIndexes;
            while (!eof) {
                name = "";
                surname = "";
                sex = "";
                age = 0;
                toRetirement = 0;
                countIndexes = 0;
                line = buff.readLine();
                if (line == null) {
                    eof = true;
                } else {
                    for (int i = 0; i < line.length(); i++) {
                        if (Character.isWhitespace(line.charAt(i)))
                            indexes[countIndexes++] = i;
                    }
                    name = line.substring(0, indexes[0]);
                    surname = line.substring(indexes[0] + 1, indexes[1]);
                    sex = line.substring(indexes[1] + 1, indexes[1] + 2);
                    age = Integer.parseInt(line.substring(indexes[2] + 1, line.length()));
                    if (sex.equals("M")) {
                        toRetirement = 65 - age;
                        buffOut.write(surname + " " + name + " " + toRetirement);
                        buffOut.newLine();
                    }
                    if (sex.equals("K")) {
                        toRetirement = 65 - age;
                        buffOut2.write(surname + " " + name + " " + toRetirement);
                        buffOut2.newLine();
                    }
                }
            }
            buffOut.close();
            buffOut2.close();
        } catch (IOException e) {
            System.out.println("File error!!!");
        }
    }
}
