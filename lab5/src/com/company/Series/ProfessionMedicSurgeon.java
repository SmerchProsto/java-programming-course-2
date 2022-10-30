package com.company.Series;

import java.util.Arrays;
import java.util.Random;

public class ProfessionMedicSurgeon {
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
