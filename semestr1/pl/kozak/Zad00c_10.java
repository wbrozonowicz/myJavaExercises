package semestr1.pl.kozak;

import java.io.*;

public class Zad00c_10 {
    /*
     Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    10. Napisać procedurę (funkcję void), która konwertuje dane zapisane w pliku elementowym do pliku
    tekstowego, w taki sposób, że każdy rekord zapisany zostaje do jednej linii, a jego pola oddzielone
    zostają znakiem spacji. Pensja każdego pracownika w pliku tekstowym ma być o 10% wyższa niż pensja
    w pliku elementowym. Nazwy plików przekazywane są jako parametr.
    Plik elementowy zawiera obiekty z polami:
    T
    pracownik
    imie:string;
    nazwisko:string;
    dzial:int;
    pensja:int; //Proszę zwrócić uwagę, że pensja w rekordzie jest zapisana w postaci całkowitoliczbowej.
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "plikElementowy.dat";
        Worker worker1 = new Worker("Maciej", "Kozak", 301, 2600);
        Worker worker2 = new Worker("Ewa", "Nowak", 301, 3400);
        Worker worker3 = new Worker("Kazimierz", "Tomecki", 201, 4000);
        Worker worker4 = new Worker("Karol", "Duda", 201, 1900);
        Worker worker5 = new Worker("Kasia", "Duraj", 201, 8900);
        Worker worker6 = new Worker("Wojtek", "Brożonowicz", 201, 125000);
        System.out.println(worker1);
        Worker[] staff = {worker1, worker2, worker3, worker4, worker5, worker6};
        try {
            Worker.saveGroupToElementFile(fileName, staff);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // odczyt z pliku elementowego
        Worker[] staffFromFile = Worker.readGroupFromElementFile(fileName);
        System.out.println("Odczyt z pliku:");
        for (int i = 0; i < staffFromFile.length; i++) {
            if (staffFromFile[i] != null) {
                System.out.println(staffFromFile[i]);
            }
        }
        // zapis do pliku textowego danych z pliku elementowego
        Worker.saveToTxtFile("Workers.txt", fileName);
    }
}

class Worker implements Serializable {
    String name;
    String surname;
    int deptNo;
    int salary;

    Worker(String inName, String inSurname, int inDeptNo, int inSalary) {
        name = inName;
        surname = inSurname;
        deptNo = inDeptNo;
        salary = inSalary;
    }

    public String toString() {
        String out = "Pracownik: " + name + " " + surname + " , dział nr: " + deptNo + ", pensja = " + salary + "zł";
        return out;
    }

    static void saveGroupToElementFile(String fileName, Worker[] workerIn) throws IOException {
        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream(fileName));
            for (int i = 0; i < workerIn.length; i++) {
                os.writeObject(workerIn[i]);
            }
            os.flush();
        } catch (IOException ioe) {
            System.out.println("File error!");
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }

    static Worker[] readGroupFromElementFile(String fileName) throws ClassNotFoundException, IOException {
        Worker[] outStaff = new Worker[10]; // max 10 elementów
        ObjectInputStream oi = null;
        Object obj = null;
        int count = 0;
        try {
            oi = new ObjectInputStream(new FileInputStream(fileName));
            while ((obj = oi.readObject()) != null) {
                outStaff[count++] = (Worker) obj;
            }
        } catch (IOException e) {
        } finally {
            if (oi != null) {
                oi.close();
            }
        }
        return outStaff;
    }

    // odczyt z pliku elementowego + zwiększenie pensji o 10% + zapis do pliku textowego
    static void saveToTxtFile(String fileName, String elementFile) throws IOException, ClassNotFoundException {
        Worker[] staffToSave = Worker.salaryIncrease(Worker.readGroupFromElementFile(elementFile));
        try (BufferedWriter buffW = new BufferedWriter(new FileWriter(fileName, false))) {

            for (int i = 0; i < staffToSave.length; i++) {
                if (staffToSave[i] != null) {
                    buffW.write(staffToSave[i].toString());
                    buffW.newLine();
                }
            }
        } catch (IOException ioe) {
            System.out.println("File error");
        }
    }

    static Worker[] salaryIncrease(Worker[] inStaff) {
        Worker[] outStaff = new Worker[inStaff.length];
        double increase = 0;
        for (int i = 0; i < inStaff.length; i++) {
            outStaff[i] = inStaff[i];
            if (outStaff[i] != null) {
                increase = 0.1 * outStaff[i].salary;
                outStaff[i].salary += increase;
            }
        }
        return outStaff;
    }

}
