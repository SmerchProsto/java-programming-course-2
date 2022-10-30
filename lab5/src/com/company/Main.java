package com.company;

import com.company.Series.SerObject;
import com.company.Series.Seriesable;
import com.company.Threads.*;

import java.util.Scanner;

import static com.company.Menu.*;

public class Main {
    public static void main(String[] args) {


        Seriesable sObj = new SerObject();

        Scanner scan = new Scanner(System.in);
        String menuItem;

        do {
            System.out.println(
                    "1 -- заполнить нитью +\n" +
                    "      считать   нитью\n" +
                    "2 -- write-read-write-read...\n" +
                    LINE +
                    "0 -- выйти\n" +
                    LINE +
                    "выбор ... ");
            menuItem = scan.nextLine();

            switch (menuItem) {
                // region РАБОТА С БАЗОЙ

                case "1":
                    printTask("1 -- заполнить нитью +\n" +
                            "      считать   нитью");
                    WritingThread wt = new WritingThread(sObj);
                    ReadingThread rt = new ReadingThread(sObj);

                    wt.setPriority(Thread.MAX_PRIORITY);
                    wt.start();

                    rt.setPriority(Thread.MIN_PRIORITY);
                    rt.start();


                    break;

                case "2":
                    printTask("2 -- write-read-write-read...");

                    SeriesableSynchronizer ssyncher = new SeriesableSynchronizer(sObj);
                    WritingRunnableThread wrt = new WritingRunnableThread(ssyncher);
                    ReadingRunnableThread rrt = new ReadingRunnableThread(ssyncher);

                    new Thread(wrt).start();
                    new Thread(rrt).start();

                default:
                    break;
            }
        } while (!menuItem.equals("0"));
    }
}
