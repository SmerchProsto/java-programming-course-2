package com.company.Threads;

import com.company.Series.Seriesable;

import static com.company.Test.*;

public class WritingThread extends Thread {
    private Seriesable s;

    public WritingThread(Seriesable s) {
        this.s = s;
    }

    @Override
    public void run() {

        for (int i = 0; i < s.getLength(); i++) {
            int num = getRandNum();
            s.setNumOfEls(i, num);
            System.out.println("WRITE " + num + " to   position " + i);
        }
    }
}
