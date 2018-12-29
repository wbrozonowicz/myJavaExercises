package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Zad06_07 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    Napisać program, który dla pliku tekstowego o podanej nazwie wyznaczy „wykres”
    częstości wystąpień małych liter alfabetu angielskiego. Słupki wykresu majązostać utworzone ze znaków gwiazdki ’*’,
    przy czym długość słupka dla najczęściej występującej litery powinna wynosić 50.
    Dodatkowo dla każdego znaku należy dodatkowo wyświetlić liczbę jego wystąpień.
    Poniżej umieszczono przykładowy wykres wygenerowany dla tekstu „Adventuresof Huckleberry Finn” M. Twaina dostępnego pod adresem:
    http://www.gutenberg.org/dirs/7/76/76.txt
    a ************************************* 36581
    b ******* 7439
    c ******** 8317
    d ************************ 23754
    e ************************************************** 49084
    f ******** 7914
    g ********** 10733
    h ************************** 26338
    i **************************** 28222
    j * 1211
    k ***** 5677
    l ***************** 17446
    m ********** 10337
    n ********************************* 32818
    o ************************************* 36700
    p ****** 5971
    q 189
    r ******************** 20252
    s ************************* 25193
    t ******************************************* 42390
    u ************** 13954
    v ** 2944
    w ************* 13347
    x 453
    y ********** 10312
    z 185
     */

    public static void main(String[] args) {
        String fileName = "finn.txt";
        chart(fileName);
    }

    private static void chart(String fileName) {

        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int[] countForChar = new int[26];
        int max = 0;
        int unit = 0;
        int speceCount = 0;
        try (
                FileReader fo = new FileReader(fileName);
                BufferedReader buff = new BufferedReader(fo);
        ) {
            boolean eof = false;
            String line;

            while (!eof) {
                line = buff.readLine();
                if (line == null) {
                    eof = true;
                } else {
                    for (int i = 0; i < line.length(); i++) {
                        for (int j = 0; j < alphabet.length; j++) {
                            if (line.charAt(i) == alphabet[j]) {
                                countForChar[j]++;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < countForChar.length; i++) {
                if (countForChar[i] > max) {
                    max = countForChar[i];
                }
            }
            unit = max / 50;
            for (int i = 0; i < alphabet.length; i++) {
                speceCount = 55;
                System.out.print(alphabet[i] + ": ");
                for (int j = 0; j < (countForChar[i] / unit); j++) {
                    System.out.print("*");
                    speceCount--;
                }
                for (int j = 0; j < speceCount; j++) {
                    System.out.print(" ");
                }
                System.out.print(countForChar[i] + "\n");
            }
        } catch (IOException ioe) {
            System.out.println("File error");
        }
    }
}
