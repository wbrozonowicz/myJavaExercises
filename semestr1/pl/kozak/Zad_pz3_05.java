package semestr1.pl.kozak;

import java.io.*;

public class Zad_pz3_05 {
    /*
    Zadanie ze strony:
    http://www.jkozak.pl/przedmioty/podstawy-i-jezyki-programowania/materialy-do-cwiczen/
    5.Dany jest obiekt z polami:
    TPracownik
        imie, nazwisko : string;
        placa : int;
        plec: char;   // 'K' - kobieta, 'M' - mężczyzna.
        dzial: int;   // możliwe, istniejące działy, to 1, 2, 3, 4 i 5.

    Napisać procedurę (funkcję void) 'podzielPlace', która jako parametr otrzymuje nazwę pliku wejściowego (elemetowego),
    nazwę pliku wyjściowego 1 ( tekstowego 1) i nazwę pliku wyjściowego 2 (tekstowego 2). Procedura przepisuje z pliku
    wejściowego do pliku wyjściowego 1 osoby (wszystkie dane o nich), których zarobki są mniejsze od średniej wszystkich
    zarobków, natomiast do pliku wyjściowego 2 wszystkie pozostałe osoby (dane o nich). Dodatkowo należy wyświetlić
    numer działu, w którym średnie zarobki są najwyższe.
    Przykład:
    Jeżeli w pliku były dane:
        Jan, Kowalski, 2100, M, 3
        Agnieszka, Cuber, 2900, K, 3
        Tomasz, Nowak, 1500, M , 4
        Adam, Nowak, 1100, M, 4
        Sylwia, Zych, 2100, K, 3
        Beata, Dudek, 1900, K, 4
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TWorker os1 = new TWorker("Jan", "Kowalski", 2100, 'M', 3);
        TWorker os2 = new TWorker("Agnieszka", "Cuber", 2900, 'K', 2);
        TWorker os3 = new TWorker("Tomasz", "Nowak", 1500, 'M', 4);
        TWorker os4 = new TWorker("Adam", "Nowak", 1100, 'M', 4);
        TWorker os5 = new TWorker("Sylwia", "Zych", 2100, 'K', 3);
        TWorker os6 = new TWorker("Beata", "Dudek", 1900, 'K', 4);
        TWorker[] teamToSave = {os1, os2, os3, os4, os5, os6};
        String filename = "Tworkers.dat";
        String fileTworkers1 = "Tworkers1.txt";
        String fileTworkers2 = "Tworkers2.txt";
        TWorker.saveGroupToElementFile(filename, teamToSave);

        TWorker[] team;
        team = TWorker.readElementsFromFile(filename);
        for (int i = 0; i < team.length; i++) {
            if (team[i] != null) {
                System.out.println(team[i]);
            }
        }

        TWorker.divideSalaries(filename, fileTworkers1, fileTworkers2);
    }
}

class TWorker implements Serializable {
    String name;
    String surname;
    int salary;
    char sex;
    int department;

    TWorker(String inName, String inSurname, int inSalary, char inSex, int inDepartment) {
        name = inName;
        surname = inSurname;
        salary = inSalary;
        sex = inSex;
        department = inDepartment;
    }

    public String toString() {
        String out = "Pracownik:" + name + " " + surname + ", z działu: " + department + ", pensja: " + salary + ", płeć: " + sex;
        return out;
    }

    public static void saveGroupToElementFile(String filename, TWorker[] obj) throws IOException {
        ObjectOutputStream os = null;
        try {
            FileOutputStream fo = new FileOutputStream(filename, false);
            os = new ObjectOutputStream(fo);
            for (int i = 0; i < obj.length; i++) {
                os.writeObject(obj[i]);
            }
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static TWorker[] readElementsFromFile(String filename) throws IOException, ClassNotFoundException {
        TWorker[] out = new TWorker[10];
        Object objRead = null;
        ObjectInputStream oi = null;
        int index = 0;
        try {
            oi = new ObjectInputStream(new FileInputStream(filename));
            while ((objRead = oi.readObject()) != null) {
                out[index++] = (TWorker) objRead;
            }
        } catch (IOException e) {
        } finally {
            if (oi != null) {
                oi.close();
            }
        }
        return out;
    }

    static void divideSalaries(String elementFile, String outFile1, String outFile2) {
        double avgSalary = 0;
        double sumOfSalary = 0;
        int countWorkers = 0;
        double[] avgInDepartment = {0, 0, 0, 0, 0};
        double[] sumInDept = {0, 0, 0, 0, 0};
        int[] countInDepts = {0, 0, 0, 0, 0};

        try (FileWriter fw1 = new FileWriter(outFile1);
             FileWriter fw2 = new FileWriter(outFile2);
             BufferedWriter buffW1 = new BufferedWriter(fw1);
             BufferedWriter buffW2 = new BufferedWriter(fw2);
        ) {
            TWorker[] inTeam = readElementsFromFile(elementFile);
            for (int i = 0; i < inTeam.length; i++) {
                if (inTeam[i] != null) {
                    sumOfSalary += inTeam[i].salary;
                    countWorkers++;
                    switch (inTeam[i].department) {
                        case 1:
                            sumInDept[0] += inTeam[i].salary;
                            countInDepts[0]++;
                            break;

                        case 2:
                            sumInDept[1] += inTeam[i].salary;
                            countInDepts[1]++;
                            break;

                        case 3:
                            sumInDept[2] += inTeam[i].salary;
                            countInDepts[2]++;
                            break;

                        case 4:
                            sumInDept[3] += inTeam[i].salary;
                            countInDepts[3]++;
                            break;

                        case 5:
                            sumInDept[4] += inTeam[i].salary;
                            countInDepts[4]++;
                            break;
                    }
                }
            }
            avgSalary = sumOfSalary / countWorkers;

            for (int i = 0; i < countInDepts.length; i++) {
                if (countInDepts[i] > 0) {
                    avgInDepartment[i] = sumInDept[i] / countInDepts[i];
                }
            }

            int result = findIndexOfMax(avgInDepartment);
            System.out.println("Średnia zarobków = "+avgSalary);
            System.out.println("Najwyższe średnie zarobki są w dziale: " + (result) + " i wynoszą =" + avgInDepartment[result - 1]);

            for (int i = 0; i < countWorkers; i++) {
                if (inTeam[i].salary < avgSalary) {
                    buffW1.write(inTeam[i].toString());
                    buffW1.newLine();
                } else {
                    buffW2.write(inTeam[i].toString());
                    buffW2.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static int findIndexOfMax(double[] inArr) {
        int res = 0;
        double max = inArr[res];
        for (int i = 0; i < inArr.length; i++) {
            if (inArr[i] > max) {
                max = inArr[i];
                res = i;
            }
        }
        return res + 1;
    }
}
