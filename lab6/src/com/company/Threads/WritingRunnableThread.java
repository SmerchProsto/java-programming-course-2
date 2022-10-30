package com.company.Threads;

import static com.company.Test.getRandNum;

public class WritingRunnableThread implements Runnable {
    private SeriesableSynchronizer ssyncher;

    public WritingRunnableThread(SeriesableSynchronizer ssyncher) {
        this.ssyncher = ssyncher;
    }

    @Override
    public void run() {
        try {
            for (int index = 0; index < ssyncher.getSerLenght(); index++) {
                int val = getRandNum();
                ssyncher.write(val);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
    }
}
