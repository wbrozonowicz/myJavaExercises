package semestr1.pl.kozak;

import java.io.*;

public class Zad_pz3_06 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    6. Zdefiniować obiekt (TData), który będzie spełniał format daty (pola dzień - integer, miesiąc - integer, rok - integer i
    dzień tygodnia - string). Następnie napisać funkcję 'konwertujDate', która z pliku tekstowego, w którym zapisane są daty
    w różnych formatach (podanych poniżej), przepisze dane do pliku elemntowego (TData).
    Dodatkowo, jeśli jakaś data została powtórzona, to w pliku elementowym ma zostać zapisana tylko raz (daty w pliku
    wejściowym są posortowane zgodnie z kolejnością rosnącą).
    Funkcja zwraca liczbę przepisanych dat. Nazwa pliku tekstowego oraz elementowego przekazana jest przez parametry funkcji.
    W każdej linii pliku tekstowego zapisana jest dokładnie jedna data dowolnego z formatu:
    dd/mm/rrrr/dzien_tygodnia
    dd/m/rrrr/dzien_tygodnia
    rrrr-mm-dd dzien_tygodnia
    dzien_tygodnia dd.mm.rrrr
    gdzie dzien_tygodnia, to poprawny zapis bezpośrednio odpowiadający nazwie dnia tygodnia.
    Przykład:
    Z pliku tekstowego:
        2007-06-20 środa
        28/01/2009 środa
        środa 28.01.2009
        2009-01-28 środa
        14/2/2009 niedziela
        piątek 27.11.2009
    powstaną następujące obiekty:
        dzień = 20, miesiac = 6,    rok = 2007,    dzien_tygodnia = środa
        dzień = 28, miesiac = 1,    rok = 2009,    dzien_tygodnia = środa
        dzień = 14, miesiac = 2,    rok = 2009,    dzien_tygodnia = niedziela
        dzień = 27, miesiac = 11,  rok = 2009,    dzien_tygodnia = piątek
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "Daty.txt";
        String elemFile = "DatesElementFile.dat";
        String[] linesToDecode = TData.readFromFile(fileName);
        System.out.println("Dane do dekodowania z pliku tekstowego:");
        for (int i = 0; i < linesToDecode.length; i++) {
            System.out.println(linesToDecode[i]);
        }
        System.out.print("\n");
        int res = TData.decodeLines(fileName, elemFile);
        System.out.println("Odczyt z pliku wynikowego:");
        TData[] dates = TData.readElementsFromFile(elemFile);
        for (int i = 0; i < dates.length; i++) {
            if (dates[i] != null) {
                System.out.println(dates[i]);
            }
        }
        System.out.println("Liczba odczytanych unikalnych dat:" + res);
    }
}

class TData implements Serializable {
    int day;
    int month;
    int year;
    String dayOfWeek;

    TData(int inDay, int inMonth, int inYear, String inDayOfWeek) {
        day = inDay;
        month = inMonth;
        year = inYear;
        dayOfWeek = inDayOfWeek;
    }

    public String toString() {
        String prefixDay = "";
        String prefixMonth = "";
        if (day < 10) {
            prefixDay = "0";
        } else {
            prefixDay = "";
        }
        if (month < 10) {
            prefixMonth = "0";
        } else {
            prefixMonth = "";
        }
        String out = prefixDay + day + "-" + prefixMonth + month + "-" + year + " / " + dayOfWeek;
        return out;
    }

    static String[] readFromFile(String filename) {
        String[] line = new String[countLines(filename)];
        String inLine = "";
        int index = 0;
        try (FileReader fr = new FileReader(filename);
             BufferedReader buff = new BufferedReader(fr)) {
            while ((inLine = buff.readLine()) != null) {
                line[index++] = inLine;
            }
        } catch (IOException ioe) {
            System.out.println("File error!!!");
        }
        return line;
    }

    static int countLines(String filename) {
        int count = 0;
        try (FileReader fr = new FileReader(filename);
             BufferedReader buff = new BufferedReader(fr)) {
            while (buff.readLine() != null) {
                count++;
            }
        } catch (IOException ioe) {
            System.out.println("File error!!!");
        }
        return count;
    }

    static int decodeLines(String fileIn, String fileOut) throws IOException {
        String[] inLines = readFromFile(fileIn);
        TData[] output = new TData[inLines.length];
        int[] data = new int[3]; // 0 = year, 1 = month, 2 = day
        int posOfSpace = 0;
        int countElements = 0;
        String left;
        String right;
        String line;
        String nameOfDay;
        for (int i = 0; i < inLines.length; i++) {
            line = inLines[i];
            posOfSpace = findSpace(line);
            left = line.substring(0, posOfSpace);
            right = line.substring(posOfSpace + 1, line.length());
            if (ifDate(left)) {
                data = decodeDateToInt(left);
                nameOfDay = right;
            } else {
                data = decodeDateToInt(right);
                nameOfDay = left;
            }
            if (i > 0 && data[2] == output[countElements - 1].day && data[1] == output[countElements - 1].month && data[0] == output[countElements - 1].year) {
                // nie dodawaj powtórzonego
            } else {
                output[countElements++] = new TData(data[2], data[1], data[0], nameOfDay);
            }
        }
        // zapisz do pliku elementowego
        ObjectOutputStream ous = null;
        try {
            FileOutputStream fos = new FileOutputStream(fileOut);
            ous = new ObjectOutputStream(fos);
            for (int i = 0; i < output.length; i++) {
                if (output[i] != null) {
                    ous.writeObject(output[i]);
                }
            }
            ous.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (ous != null) {
                ous.close();
            }
        }
        return countElements;
    }

    static TData[] readElementsFromFile(String fileName) throws ClassNotFoundException, IOException {
        TData[] date = new TData[10];
        ObjectInputStream oi = null;
        Object obj = null;
        int count = 0;
        try {
            oi = new ObjectInputStream(new FileInputStream(fileName));
            while ((obj = oi.readObject()) != null) {
                date[count++] = (TData) obj;
            }
        } catch (IOException e) {
        } finally {
            if (oi != null) {
                oi.close();
            }
        }

        return date;
    }

    static int findSpace(String inText) {
        int pos = 0;
        for (int i = 0; i < inText.length(); i++) {
            if (inText.substring(i, i + 1).equals(" ")) {
                pos = i;
            }
        }
        return pos;
    }

    static boolean ifDate(String inText) {
        if (inText.contains(".") || inText.contains("/") || inText.contains("-"))
            return true;
        else
            return false;
    }

    static int[] decodeDateToInt(String inText) {
        int[] data = new int[3];
        int[] posOfSeparator = new int[2];
        int index = 0;
        for (int i = 0; i < inText.length(); i++) {
            if (inText.substring(i, i + 1).equals(".") || inText.substring(i, i + 1).equals("/") || inText.substring(i, i + 1).equals("-")) {
                posOfSeparator[index++] = i;
            }
        }
        if (posOfSeparator[0] == 4) {
            data[0] = Integer.parseInt(inText.substring(0, posOfSeparator[0])); // year
            data[1] = Integer.parseInt(inText.substring(posOfSeparator[0] + 1, posOfSeparator[1])); // month
            data[2] = Integer.parseInt(inText.substring(posOfSeparator[1] + 1, inText.length())); // day
        } else if (posOfSeparator[0] == 2) {
            data[0] = Integer.parseInt(inText.substring(posOfSeparator[1] + 1, inText.length())); // year
            data[1] = Integer.parseInt(inText.substring(posOfSeparator[0] + 1, posOfSeparator[1])); // month
            data[2] = Integer.parseInt(inText.substring(0, posOfSeparator[0])); // day
        }
        return data;
    }

}