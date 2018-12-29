package semestr1.pl.kozak;

import java.util.Random;

public class Zad_pz3_01 {
    /*
    adanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    1.Napisać program, który losuje 95 pseudolosowych liczb rzeczywistych (dokładność do drugiego miejsca po przecinku)
    z zakresu [-5.00, 5.00), czyli większych lub równych -5.00 i mniejszych od 5.00. W rezultacie działania programu należy
    wyświetlić informację ile liczb należało do zakresu [-1.00, 1.00] i ile z nich było ujemnych. Dodatkowo program powinien
    wyświetlić liczbę wszystkich wylosowanych liczb z zakresu (0.00, 5.00).
    Zadanie należy wykonać beż użycia tablic.
    Przykład (dla 5 liczb):
    -3.52    2.41    0.11    -0.64    1.00
    Wynik:
    3     1     3
     */
    public static void main(String[] args) {
        double number;
        boolean positive;
        int countRange1a = 0; // zakres od -1.00 do 1.00
        int countRange1b = 0; // ile z zakresu -1.00 do 1.00 było ujemnych
        int countRange2 = 0; // zakres od 0.00 do 500
        Random rm = new Random();
        Random ranSign = new Random();
        for (int i = 0; i < 95; i++) {
            positive = rm.nextBoolean();
            number = rm.nextDouble() * 5;
            if (!positive && number != 0) {
                number = -1 * number;
            }
            System.out.println((i + 1) + ": " + number);
            if (number >= -1.00 && number <= 1.00) {
                countRange1a++;
                if (number < 0) {
                    countRange1b++;
                }
            }
            if (number >= 0 && number <= 5.00) {
                countRange2++;
            }
        }
        System.out.println("Wyniki " + countRange1a + " / " + countRange1b + " / " + countRange2);
    }
}
