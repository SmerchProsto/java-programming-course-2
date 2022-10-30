package com.company.FirstPackage;

public class secondClass {


    private int oneVar;
    private int secondVar;

    public secondClass() {
        oneVar = 1;
        secondVar = 2;
    }

    public void changeVar1(int varArg) {
        oneVar = varArg;
    }

    public void changeVar2(int varArg) {
        secondVar = varArg;
    }

    public int sum() {
        return oneVar + secondVar;
    }
}
