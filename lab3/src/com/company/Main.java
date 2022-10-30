package com.company;

import java.util.*;


//как третье задание
interface SurgeonInterface {
    public int getBadOperation();
    public void checkPromotion();
    public int[] getIdOperationsInADay();
    public void setIdOperationsInADay(int[] operations);
    public String getSpeciality();
    public void setSpeciality(String specialityDoctor);
    public int getSalary();
    public void setSalary(int monthSalary);

}

class BadArg extends Exception {
    public String WriteBadArg(Object ... values) {
//        if (values[0].getClass() != Arrays.class) {
//            return "Неверный тип аргумента, должен быть массив";
//        } else if (values[1].getClass() != String.class) {
//            return "Неверный тип аргумента, должна быть строка";
//        } else if (values[2].getClass() != Integer.class) {
//            return  "Неверный тип аргумента, должно быть число";
//        }
        return "Ошибка неверный аргумент";
    }

}

class ProfessionMedicSurgeon implements SurgeonInterface {

    int[] idOperationsInADay = new int[3];
    String speciality;
    int salary;

    int premium = 0;

    ProfessionMedicSurgeon() {
        speciality = "Общая хирургия";
        salary = 40000;
    }

    public ProfessionMedicSurgeon(/*int[] operations, String specialityDoctor, int monthSalary*/ Object ... args) /*throws BadArg*/ {
        try {
            if (args[0].getClass() != Arrays.class) {
                throw new RuntimeException();
            } else if (args[1].getClass() != String.class) {
                throw new RuntimeException();
            } else if (args[2].getClass() != Integer.class) {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            e.getMessage();
        }

        setIdOperationsInADay((int[]) args[0]);
        setSpeciality((String) args[1]);
        setSalary((Integer) args[2]);
    }

    public int getBadOperation() {

        //Производит подсчет плохий операций у хирурга для личного дела
        //считает количество хороший операций и доплату за них
        int amountBad = 0;
        for (int i = 0; i < getIdOperationsInADay().length; i++) {
            Random rnd = new Random();
            int answer = rnd.nextInt(2);
            if (answer == 1) {
                amountBad++;
            } else if (answer == 0) {
                this.premium += 5000;
            }
        }
        this.salary += premium;

        return amountBad;
    }

    public void checkPromotion() {
        if (premium > 300000) {
            setSpeciality("Хирург заведующий отделением");
        }
    }

    public int[] getIdOperationsInADay() {
        return this.idOperationsInADay;
    }

    public void setIdOperationsInADay(int[] operations) {
        for (int i = 0; i < operations.length; i++) {
            this.idOperationsInADay[i] = operations[i];
        }
    }

    public String getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(String specialityDoctor) {
        this.speciality = specialityDoctor;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int monthSalary) {
        this.salary = monthSalary;
    }

    @Override
    public String toString() {
        return "" + getIdOperationsInADay() + ", " + getSpeciality() + ", "  + getSalary();
    }

    public boolean equals(ProfessionMedicSurgeon surgeon) {
        if (surgeon.getIdOperationsInADay() == this.getIdOperationsInADay()
            && surgeon.getSpeciality() == this.getSpeciality()
            && surgeon.getSalary() == this.getSalary()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        Random rnd = new Random();
        int hash = rnd.nextInt(1000);
        return hash;
    }
}

//как третье задание

interface TherapistInterface {
    public ArrayList getPatientsNotWas();
    public void getFullInfo();
    public int[] getIdPatients();
    public void setIdPatients(int[] numPatients);
    public String getNameDoctor();
    public void setNameDoctor(String fullNameDoctor);
    public int getCabinet();
    public void setCabinet(int numberCab) throws WrongCab;

}

class WrongCab extends Exception {
    String message = "Неверный номер кабинета";
}

class ProfessionMedicTherapist implements TherapistInterface {

    int[] idPatients = new int[3];
    String nameDoctor;
    int cabinet;

    ProfessionMedicTherapist() {
        nameDoctor = "";
        cabinet = 1;
    }

    public ProfessionMedicTherapist(int[] numPatients, String fullNameDoctor, int numberCab) {
        setIdPatients(numPatients);
        setNameDoctor(fullNameDoctor);
        try {
            setCabinet(numberCab);
        } catch (WrongCab e) {
            System.out.println(e.message);
        }

    }

    public ArrayList getPatientsNotWas() {

        ArrayList<Integer> patientsNotWas = new ArrayList<Integer>();
        for (int i = 0; i < getIdPatients().length; i++) {
            Random rnd = new Random();
            int answer = rnd.nextInt(2);
            if (answer == 1) {
                patientsNotWas.add(getIdPatients()[i]);
            }
        }

        return patientsNotWas;
    }

    public void getFullInfo() {
        System.out.println(getNameDoctor() + " находится в кабинете: " + getCabinet());
    }

    public int[] getIdPatients() {
        return this.idPatients;
    }

    public void setIdPatients(int[] numPatients) {
        for (int i = 0; i < numPatients.length; i++) {
            this.idPatients[i] = numPatients[i];
        }
    }

    public String getNameDoctor() {
        return this.nameDoctor;
    }

    public void setNameDoctor(String fullNameDoctor) {
        this.nameDoctor = fullNameDoctor;
    }

    public int getCabinet() {
        return this.cabinet;
    }

    public void setCabinet(int numberCab) throws WrongCab {
        if (numberCab < 0 || numberCab == 0) {
            throw new WrongCab();
        } else {
            this.cabinet = numberCab;
        }
    }

    @Override
    public String toString() {
        return "" + getIdPatients() + ", " + getNameDoctor() + ", "  + getCabinet();
    }

    public boolean equals(ProfessionMedicTherapist therapist) {
        if (therapist.getIdPatients() == this.getIdPatients()
                && therapist.getNameDoctor() == this.getNameDoctor()
                && therapist.getCabinet() == this.getCabinet()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        Random rnd = new Random();
        int hash = rnd.nextInt(1000);
        return hash;
    }

}

//class MedicBase {
//    Vector medics = new Vector();
//
//    public void addMedic(Object doc) {
//        medics.add(doc);
//    }
//
//    public void getAllMedics() {
//        Enumeration docs = medics.elements();
//        while (docs.hasMoreElements()) {
//            System.out.println(docs.nextElement().toString());
//        }
//    }

//}

class MedicBase {
    Object[] values = new Object[6];

    ArrayList<ProfessionMedicTherapist> therapists = new ArrayList<ProfessionMedicTherapist>();
    ArrayList<ProfessionMedicSurgeon> surgeons = new ArrayList<ProfessionMedicSurgeon>();
    ArrayList<Object> docsIndentificalResults = new ArrayList<Object>();
    public void addMedics(Object ... docs) { //для 5 задание можно написать исключение
        values = docs.clone();
    }

    public void getAllMedics() {
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i].toString());
        }
    }


    // 4 задание 3ий пункт
    public void sortMedics() {
        for (int i = 0; i < values.length; i++) {
            if (values[i].getClass() == ProfessionMedicSurgeon.class) {
                surgeons.add((ProfessionMedicSurgeon) values[i]);
            } else if (values[i].getClass() == ProfessionMedicTherapist.class) {
                therapists.add((ProfessionMedicTherapist) values[i]);
            }
        }
    }

    public void getEquals() {
        for (int i = 0; i < surgeons.size(); i++) {
            for (int j = 1; j < surgeons.size(); j++) {
                if (surgeons.get(i).getBadOperation() == surgeons.get(j).getBadOperation()) {
                    docsIndentificalResults.add(i);
                    docsIndentificalResults.add(j);
                }
            }
        }


        // смотрим одинаковые ли люди не пришли на прием
        for (int i = 0; i < therapists.size(); i++) {
            for (int j = 1; j < therapists.size(); j++) {
                Collections.sort(therapists.get(i).getPatientsNotWas()); //необходимо для сравнения двух arraylist
                Collections.sort(therapists.get(j).getPatientsNotWas());
                if (therapists.get(i).getPatientsNotWas().equals(therapists.get(j).getPatientsNotWas())) {
                    docsIndentificalResults.add(i);
                    docsIndentificalResults.add(j);
                }
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {

        int[] urgentOperations = {12, 13, 451};
        int[] idPeoples = {1234, 5678, 91011};
        int[] urgentOperations2 = {10, 151, 626};
        int[] idPeoples2 = {12344, 54368, 910345};
        int[] urgentOperations3 = {18, 1324, 45435};
        int[] idPeoples3 = {223, 5345678, 9346};
        ProfessionMedicTherapist doc2 = new ProfessionMedicTherapist(idPeoples, "Доктор Стрейндж", 324);
        ProfessionMedicTherapist doc4 = new ProfessionMedicTherapist(idPeoples2, "Сергеев Александр Сильвестрович", 201);
        ProfessionMedicTherapist doc6 = new ProfessionMedicTherapist(idPeoples3, "Андреев Семен Викторович", 102);

        ProfessionMedicSurgeon doc1 = new ProfessionMedicSurgeon(urgentOperations, "Общая хирургия", 80000);
        ProfessionMedicSurgeon doc3 = new ProfessionMedicSurgeon(urgentOperations2, "Нейрохирургия", 50000);
        ProfessionMedicSurgeon doc5 = new ProfessionMedicSurgeon(urgentOperations3, "Пластическая хирургия", 100000);


        for (int i = 0; i < doc1.getIdOperationsInADay().length; i++) {
            System.out.println(doc1.getIdOperationsInADay()[i]);
        }

        ArrayList<Integer> clientNotWas = doc2.getPatientsNotWas();

        for (int i = 0; i < clientNotWas.size(); i++) {
            System.out.println(clientNotWas.get(i));

        }

//        MedicBase medics = new MedicBase();
//        medics.addMedic(doc1);
//        medics.addMedic(doc2);
//        medics.addMedic(doc3);
//        medics.addMedic(doc4);
//        medics.addMedic(doc5);
//        medics.addMedic(doc6);
//
//        medics.getAllMedics();

    }
}
