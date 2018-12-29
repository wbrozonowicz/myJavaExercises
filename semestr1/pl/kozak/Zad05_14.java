package semestr1.pl.kozak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zad05_14 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    14. Napisać funkcję boolean czyAnagram(String t1, String t2), która sprawdza, czy łańcuch t2
    jest anagramem tekstu t1, czyli czy składa się z tych samych znaków, ale ustawionych niekoniecznie w tej samej kolejności.
    Uwaga, należy sprawdzać jedynie małe i duże litery alfabetu angielskiego, jednak ez względu na ich wielkość,
    tzn. zarówno małe ’a’ jak i duże ’A’ liczone są tak samo. Pozostałe znaki nie są sprawdzane, a więc nie mają wpływu na to,
    czy słowo będzie uznane za anagram innego.
    Przykładowo, dla poniższego fragmentu programu:
    System.out.println(czyAnagram("kolej", "olejk"));
    System.out.println(czyAnagram("kolej", "kole"));
    System.out.println(czyAnagram("kolej", "K O L E J"));
    System.out.println(czyAnagram("Gregory House", "Huge ego, sorry"));
    na ekranie powinno zostać wyświetlone:
    true
    false
    true
    true
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Podaj tekst do sprawdzenia czy jest anagramem: ");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input1 = buff.readLine();
        System.out.println("Podaj drugi tekst: ");
        String input2 = buff.readLine();
        boolean res = czyAnagram(input1, input2);
        System.out.println(res);

    }

    private static boolean czyAnagram(String t1, String t2) {
        String t1Out = "";
        String t2Out = "";
        for (int i = 0; i < t1.length(); i++) {
            if (!t1.substring(i, i + 1).equals(" ")) {
                t1Out += t1.substring(i, i + 1);
            }
        }
        t1Out = t1Out.toLowerCase();

        for (int i = 0; i < t2.length(); i++) {
            if (!t2.substring(i, i + 1).equals(" ")) {
                t2Out += t2.substring(i, i + 1);
            }
        }
        t2Out = t2Out.toLowerCase();

        int sumForSign1 = 0;
        int sumForSign2 = 0;
        String toCheck = "";
        for (int i = 0; i < t1Out.length(); i++) {
            toCheck = t1Out.substring(i, i + 1);
            for (int j = 0; j < t1Out.length(); j++) {
                if (toCheck.equals(t1Out.substring(j, j + 1))) {
                    sumForSign1++;
                }
            }
            for (int j = 0; j < t2Out.length(); j++) {
                if (toCheck.equals(t2Out.substring(j, j + 1))) {
                    sumForSign2++;
                }
            }
            if (sumForSign1 != sumForSign2) {
                return false;
            }
        }
        return true;
    }
}
