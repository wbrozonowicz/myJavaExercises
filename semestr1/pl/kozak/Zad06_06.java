package semestr1.pl.kozak;

import java.io.*;

public class Zad06_06 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    Napisać funkcję, której zadaniem jest odczytanie danych tabelarycznych z pliku tekstowego, a następnie zapisanie ich
    do nowego pliku w postaci kodu HTML.
    Przykład:
    Wejście:
    "Waga" "Wzrost" "BMI" "Nadwaga"
    70 1,8 21,6 "NIE"
    67 1,77 21,39 "NIE"
    85 1,7 29,41 "TAK"
    100 1,92 27,13 "TAK"
    Wynik:
    <html><body>
    <table>
    <tr><td>"Waga"</td><td>"Wzrost"</td><td>"BMI"</td><td>"Nadwaga"
    </td></tr>
    <tr><td>70</td><td>1,8</td><td>21,6</td><td>"NIE"
    </td></tr>
    <tr><td>67</td><td>1,77</td><td>21,39</td><td>"NIE"
    </td></tr>
    <tr><td>85</td><td>1,7</td><td>29,41</td><td>"TAK"
    </td></tr>
    <tr><td>100</td><td>1,92</td><td>27,13</td><td>"TAK"</td></tr>
    </table>
    </body></html>
     */

    public static void main(String[] args) {
        String inFile = "Zad6in.txt";
        String outFile = "Out.html";
        generateHTML(inFile, outFile);
    }

    private static void generateHTML(String inFile, String outFile) {
        try (
                FileReader file = new FileReader(inFile);
                BufferedReader buff = new BufferedReader(file);
                FileWriter fileO = new FileWriter(outFile, false);
                BufferedWriter buffO = new BufferedWriter(fileO);
        ) {
            boolean eof = false;
            String line;
            buffO.write("<html><body>");
            buffO.newLine();
            buffO.write("<table>");
            buffO.newLine();
            int[] position = new int[3];
            int posNo = 0;
            String inText;
            while (!eof) {
                line = buff.readLine();
                if (line == null) {
                    eof = true;
                } else {
                    posNo = 0;
                    System.out.println(line);
                    for (int i = 0; i < line.length(); i++) {
                        if (line.charAt(i) == ' ') {
                            position[posNo++] = i;
                        }
                    }
                    buffO.write("<tr>");
                    buffO.write("<td>");
                    inText = line.substring(0, position[0]);
                    buffO.write(inText);
                    buffO.write("</td>");
                    buffO.write("<td>");
                    inText = line.substring(position[0] + 1, position[1]);
                    buffO.write(inText);
                    buffO.write("</td>");
                    buffO.write("<td>");
                    inText = line.substring(position[1] + 1, position[2]);
                    buffO.write(inText);
                    buffO.write("</td>");
                    buffO.write("<td>");
                    inText = line.substring(position[2] + 1, line.length());
                    buffO.write(inText);
                    buffO.write("</td>");
                    buffO.write("</tr>");
                    buffO.newLine();
                }
            }
            buffO.write("</table>");
            buffO.newLine();
            buffO.write("</body></html>");
        } catch (IOException ioe) {
            System.out.println("File error!");
        }
    }
}
