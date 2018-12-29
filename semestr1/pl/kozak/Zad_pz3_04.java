package semestr1.pl.kozak;

public class Zad_pz3_04 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    4.Napisać funkcję, która w jednowymiarowej tablicy łańcuchów znaków (podanej przez parametr) znajduje liczbę
    wystąpień frazy podanej jako drugi parametr. Jeśli w danej komórce fraza występuje kilkukrotnie, to należy policzyć każde
    jej wystąpienie. Funkcja zwraca liczbę wystąpień frazy. W zadaniu nie wolno wykorzystywać funkcji POS,
    a wielkość liter nie ma znaczenia.
    Przykład:
    Dla frazy 'abc' i tablicy:
    Ala ma kota
    Abc
    defg
    AbC
    AACB
    abC
    zdam
    abc
    egzamin
    w środę
    Funkcja zwróci wartość: 4
     */
    public static void main(String[] args) {
        String[] tab = {"Ala ma kota", "Abc", "defg", "AbC", "AACB", "abC", "zdam", "abc", "egzamin", "w środę"};
        String toFind = "abc";
        int result = countPhrases(tab, toFind);
        System.out.println("Tablica znaków:");
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + "\t");
        }
        System.out.println("\nIlość wystąpień frazy: " + toFind + " = " + result);
    }

    private static String[] toLowKeys(String[] inTab) {
        String[] outTab = new String[inTab.length];
        for (int i = 0; i < inTab.length; i++) {
            outTab[i] = inTab[i].toLowerCase();
        }
        return outTab;
    }

    private static int countPhrases(String[] tabIn, String stringToFind) {
        int count = 0;
        String[] tab = toLowKeys(tabIn);
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j <= (tab[i].length() - stringToFind.length()); j++) {
                if (stringToFind.equals(tab[i].substring(j, j + stringToFind.length()))) {
                    count++;
                }
            }
        }
        return count;
    }

}
