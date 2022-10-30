package com.company.Series;

import java.util.ArrayList;
import java.util.Random;

class WrongCab extends Exception {
    String message = "Неверный номер кабинета";
}

public class ProfessionMedicTherapist {
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
