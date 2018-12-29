package semestr1.pl.kozak;

import static semestr1.pl.kozak.Zad05_06.strToInt;
import static semestr1.pl.kozak.Zad05_10.strFindAndCount;
import static semestr1.pl.kozak.Zad05_11.strcut;

public class Zad05_12 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    12. Napisać program, który wykorzystując część z zaimplementowanych wcześniej
    funkcji wyznacza:
    • Sumę wszystkich liczb znajdujących się w tablicy (jako liczbę traktuje się
    łańcuch, którego początkiem jest liczba - format jak w funkcji strToInt().
    • Łańcuch będący połączeniem wszystkich komórek tablicy, których wartość
    łańcucha nie jest liczbą (definicja liczby analogiczna do pkt. 1).
    • Liczbę wystąpień określonej frazy we wszystkich komórkach „nieliczbowych”
    tablicy.
    • Liczbę wystąpień określonej frazy w łańcuchu, o którym mowa w pkt. 2.
    • Stosunek wystąpień frazy w komórkach tablicy (pkt. 3) do liczby wystąpień w powstałym łańcuchu (pkt. 4).
    Przykład:
    Tablica, o której mowa w zadaniu:
    zadania[N][M]={"mamla", " mama ", "+12", "0001", "991-234-3",
    "-12e5", "-12e-5", "+zonmakm", "ax2", "amakotma"};
    // gdzie N=M=10;
    Szukana fraza:
    f[N]="ma";
    Wynik wyświetlony na konsolę:
    Pkt. 1: -1199008
    Pkt. 2: mamla mama +zonmakmax2amakotma
    Pkt. 3: 6
    Pkt. 4: 7
    Pkt. 5: 0.857143
     */
    public static void main(String[] args) {
        System.out.println();
        String s = strcut("ala ma kota", 3, 4);
        String[] zadania = {"mamla", " mama ", "+12", "0001", "991-234-3",
                "-12e5", "-12e-5", "+zonmakm", "ax2", "amakotma"};
        String phrase = "ma";
        int sum = 0;
        int sumForPhrase = 0;
        int sumForPhraseInTotalString = 0;
        String totalString = "";
        for (int i = 0; i < zadania.length; i++) {
            if (strToInt(zadania[i]) != -1) {
                sum += strToInt(zadania[i]);
            } else {
                sumForPhrase += strFindAndCount(zadania[i], phrase);
                System.out.println(zadania[i] + " : " + strFindAndCount(zadania[i], phrase));
                totalString += zadania[i];
            }
        }
        double stosunek = 0;
        sumForPhraseInTotalString = strFindAndCount(totalString, phrase);
        System.out.println("1. sum = " + sum);
        System.out.println("2. cały tekst = " + totalString);
        System.out.println("3. suma wystąpień = " + sumForPhrase);
        System.out.println("4. suma wystąpień w totalString= " + sumForPhraseInTotalString);
        stosunek = (double) sumForPhrase / sumForPhraseInTotalString;
        System.out.println("5. stosunek to = " + stosunek);
    }
}
