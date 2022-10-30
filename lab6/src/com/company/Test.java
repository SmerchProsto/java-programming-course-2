package com.company;

import java.util.Random;

public class Test {

    private static int getRandInt(int min, int max) {
        int num;

        Random rand = new Random();
        num = min + rand.nextInt(max - min + 1);

        return num;
    }

    public static int getRandNum() {
        return getRandInt(0, 100);
    }
}
