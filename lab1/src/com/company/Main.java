package com.company;
import com.company.FirstPackage.*;


public class Main {

    public static void main(String[] args) {
	// System.out.println("Hello world!!!"); 2е задание

        /* //3е задание

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

         */

        secondClass o = new secondClass();
        int i, j;
        for (i = 1; i <= 8; i++) {
            for (j = 1; j <= 8; j++) {
                o.changeVar1(i);
                o.changeVar2(j);
                System.out.print(o.sum());
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}


