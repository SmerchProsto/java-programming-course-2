package com.company;

import java.util.Enumeration;
import java.util.Vector;

class VectorEdit {
    VectorEdit() {
        v = new Vector<>(3, 1);
    }

    Vector v;

    public void getElem (int numElem) { // возвращает значение элемента
        System.out.println(v.elementAt(numElem));
    }

    public void editElem (int numElem, int meanElem) { // изменяет значение определенного элемента
        System.out.println("Элемент " + numElem + " равен " + v.elementAt(numElem));
        v.set(numElem, meanElem);
        System.out.println("Элемент " + numElem + " изменен на значение " + v.elementAt(numElem));
    }

    public void getLength() {
        System.out.println("Текущая ёмкость: " + v.capacity());
        // перечислить элементы в векторе.
        Enumeration vEnum = v.elements();
        System.out.println("Элементы в векторе:");

        while(vEnum.hasMoreElements())
            System.out.print(vEnum.nextElement() + " ");
        System.out.println();
    }

    public int minElem() {
        int i = (int) v.elementAt(0);
        for (int j = 0; j < v.size(); j++) {
            if (j < i) {
                i = j;
            }
        }

        System.out.println("Минимальный элемент " + i);
        return i;

    }

    public int maxElem() {
        int i = (int) v.elementAt(0);
        for (int j = 0; j < v.size(); j++) {
            if (j > i) {
                i = j;
            }
        }

        System.out.println("Максимальный элемент " + i);
        return i;

    }

    public void sortV () {
        Vector v1 = (Vector) v.clone();
        Enumeration vEnum = v1.elements();
        for (int i = 0; i < v1.size(); i++) {
            int numberInV = (int) v1.elementAt(i);
            int min = numberInV;

            for (int j = i; j < v1.size() ; j++){
                int comparableNum = (int) v1.elementAt(j);
                if (comparableNum < min) {
                    min = comparableNum;


                }

                if (j == v1.size() - 1) {
                    v1.set(v1.indexOf(min), numberInV);
                    v1.set(i, min);
                }

            }

        }
        System.out.println("Отсортированный вектор: ");
        while(vEnum.hasMoreElements())
            System.out.print(vEnum.nextElement() + " ");
        System.out.println();
    }

    public int evklidNorm() {
        int answer = 0;
        for (int i = 0; i < v.size(); i++)
        {
            answer += (int) v.elementAt(i) * (int) v.elementAt(i);
        }

        System.out.println("Евклидова норма: " + answer);
        return answer;
    }

    public void multiplicationOnNum(int number) {
        Vector v1 = (Vector) v.clone();

        for (int i = 0; i < v1.size(); i++)
        {
            v1.set(i, (int) v1.elementAt(i) * number);
        }
        System.out.println("Умноженный вектор на число: ");
        Enumeration vEnum = v1.elements();
        while(vEnum.hasMoreElements())
            System.out.print(vEnum.nextElement() + " ");
        System.out.println();
    }

    public Vector multiplicationOnVector(Vector differentV) {
        Vector vAnswer = new Vector();
        vAnswer = (Vector) differentV.clone();
        if (v.size() != differentV.size())
            System.out.println("Нужен вектор нужной длины");
        else {
            for (int i = 0; i < v.size(); i++)
            {
                vAnswer.set(i, (int) differentV.elementAt(i) * (int) v.elementAt(i));
            }
            System.out.println("Перемноженный вектор: " + vAnswer);
        }
        return vAnswer;
    }

    public Vector sumOnVector(Vector differentV) {
        Vector vAnswer = new Vector();
        vAnswer = (Vector) differentV.clone();
        if (v.size() != differentV.size())
            System.out.println("Нужен вектор нужной длины");
        else {
            for (int i = 0; i < v.size(); i++)
            {
                vAnswer.set(i, (int) differentV.elementAt(i) + (int) v.elementAt(i));
            }
            System.out.println("Сложенный вектор: " + vAnswer);
        }
        return vAnswer;
    }


}

public class Main {

    public static void main(String[] args) {
        VectorEdit userVector = new VectorEdit();
        userVector.v.add(3);
        userVector.v.add(0);
        userVector.v.add(1);


        userVector.getLength();

        userVector.minElem();
        userVector.maxElem();

        userVector.sortV();
        userVector.evklidNorm();
        userVector.multiplicationOnNum(3);
        VectorEdit v2 = new VectorEdit();
        v2.v.add(1);
        v2.v.add(0);
        v2.v.add(1);

        userVector.multiplicationOnVector(v2.v);
        userVector.sumOnVector(v2.v);


    }
}
