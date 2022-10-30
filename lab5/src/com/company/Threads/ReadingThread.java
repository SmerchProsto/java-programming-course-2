package com.company.Threads;

import com.company.Series.Seriesable;

import static com.company.Test.*;

public class ReadingThread extends Thread {
    private Seriesable s;

    public ReadingThread(Seriesable s) {this.s = s;}
    @Override
    public void run() {

        for (int index = 0; index < s.getLength(); index++) {
            System.out.println("READ  " + s.getNumOfEls(index) + " from position " + index);
        }
    }
}
