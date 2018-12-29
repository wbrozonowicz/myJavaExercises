package semestr1.pl.kozak;

import java.io.*;

public class Zad_e_02 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    2.Napisać funkcję 'konwersja', która jako parametr otrzymuje nazwę pliku wejściowego oraz liczbę całkowitą.
    W wyniku działania funkcji plik (ten sam plik) powinien zostać zmieniony według następujących zasad:
    •co drugi znak w każdej linii powinien zostać zmieniony na znak następny (w tablicy kodów ASCII), np.
    „Ala ma kota” → „Ama!mb loua”,
    •co trzecia linia w pliku powinna zostać odwrócona: np. „atok am alA”,
    •wszystkie linie, których długość jest mniejsza od wartości drugiego parametru funkcji powinny zostać usunięte.
    Natomiast funkcja powinna zwrócić średnią wartość cyfr (nie liczb) zapisanych w pliku.
    Ponadto, jeśli plik o podanej nazwie nie istnieje, to należy stworzyć plik i wpisać w nim informację „Brak pliku
    wejściowego”.
    Uwaga,
    nie należy używać (importować) żadnych dodatkowych bibliotek, poza klasami niezbędnymi do obsługi plików tekstowych.
     */
    public static void main(String[] args) {
        String fileName = "Zad_e_02.txt";
        int number = 4;
        if (!ifFileExist(fileName)) {
            createFile(fileName);
        } else {
            // plik istnieje  - dokonaj modyfikacji
            double res = konwersja(fileName, 9);
            System.out.println("Wynik funkcji - średnia = " + res);
        }
    }

    private static double konwersja(String fileIn, int numberIn) {
        int sum = 0;
        int numbersCount = 0;
        double avg = 0;
        // oblicz wartość liczb w pliku wejciowym
        String line;
        String[] lineToSave = new String[countLinesInFile(fileIn)];
        int lineNo = 0;
        try (FileReader fr = new FileReader(fileIn);
             BufferedReader buff = new BufferedReader(fr);
        ) {
            while ((line = buff.readLine()) != null) {
                sum += sumOfLine(line);
                numbersCount += countNumbersInLine(line);
                lineToSave[lineNo] = replaceEverySecondSign(line);
                if (lineNo % 3 == 0) {
                    lineToSave[lineNo] = reverse(lineToSave[lineNo]);
                }
                if (line.length() < numberIn) {
                    lineToSave[lineNo] = null;
                }
                lineNo++;
            }

        } catch (IOException ioe) {
            System.out.println("Error when reading th file.");
        }
        saveLinesToFile(fileIn, lineToSave);
        System.out.println("Liczb = " + numbersCount);
        System.out.println("Ich suma = " + sum);
        if (numbersCount > 0) {
            avg = (double) sum / numbersCount;
        } else {
            avg = 0;
        }
        return avg;
    }

    private static int countLinesInFile(String fileIn) {
        String line;
        int lineNo = 0;
        try (FileReader fr = new FileReader(fileIn);
             BufferedReader buff = new BufferedReader(fr);
        ) {
            while ((line = buff.readLine()) != null) {
                lineNo++;
            }
        } catch (IOException ioe) {
            System.out.println("Error when reading th file.");
        }
        return lineNo;
    }

    private static void saveLinesToFile(String file, String[] lines) {
        try (FileWriter fw = new FileWriter(file, false);
             BufferedWriter buff = new BufferedWriter(fw)) {
            for (int i = 0; i < lines.length; i++) {
                if (lines[i] != null) {
                    buff.write(lines[i]);
                    buff.newLine();
                }
            }
        } catch (IOException ioe) {
            System.out.println("Error when saving line");
        }
    }

    private static boolean ifFileExist(String filename) {
        try {
            FileReader fr = new FileReader(filename);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    private static void createFile(String filename) {
        try (FileWriter fr = new FileWriter(filename, true);
             BufferedWriter buffW = new BufferedWriter(fr)) {
            buffW.write("Brak pliku wejściowego.");
            buffW.newLine();
        } catch (IOException ioe) {
            System.out.println("File error");
        }
    }

    private static String reverse(String inText) {
        String out = "";
        for (int i = inText.length() - 1; i >= 0; i--) {
            out += inText.substring(i, i + 1);
        }
        return out;
    }

    private static String replaceEverySecondSign(String inText) {
        String out = "";
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < inText.length(); i++) {
            if (i % 2 != 0) {
                index1 = findIndex(inText.substring(i, i + 1));
                index2 = index1 + 1;
                out += findSymbol(index2);
                // zamien
            } else {
                // nie zamieniaj
                out += inText.substring(i, i + 1);
            }
        }
        return out;
    }

    private static int findIndex(String inText) {
        int pos = -1;
        String[] acsiiCodeSymbol = {" ", "!", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "[", "slash", "]", "^", "`", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "{", "|", "}" };
        for (int i = 0; i < acsiiCodeSymbol.length; i++) {
            if (inText.equals(acsiiCodeSymbol[i])) {
                pos = i;
            }
        }
        return pos;
    }

    private static String findSymbol(int index) {
        String out = "";
        String[] acsiiCodeSymbol = {" ", "!", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "[", "slash", "]", "^", "`", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "{", "|", "}" };
        out = acsiiCodeSymbol[index];
        return out;
    }

    private static boolean isNumber(String inText) {
        try {
            int res = Integer.parseInt(inText);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static int sumOfLine(String inLine) {
        int sum = 0;
        for (int i = 0; i < inLine.length(); i++) {
            if (isNumber(inLine.substring(i, i + 1))) {
                sum += Integer.parseInt(inLine.substring(i, i + 1));
            }
        }
        return sum;
    }

    private static int countNumbersInLine(String inLine) {
        int count = 0;
        for (int i = 0; i < inLine.length(); i++) {
            if (isNumber(inLine.substring(i, i + 1))) {
                count++;
            }
        }
        return count;
    }
}
