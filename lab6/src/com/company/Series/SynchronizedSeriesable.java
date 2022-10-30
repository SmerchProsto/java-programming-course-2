package com.company.Series;

import java.io.OutputStream;
import java.io.Writer;

public class SynchronizedSeriesable implements Seriesable {
    private final Seriesable s;

    public SynchronizedSeriesable(Seriesable s) {
        this.s = s;
    }

    @Override
    public synchronized int getNumOfEls(int index) {
        return s.getNumOfEls(index);
    }

    @Override
    public synchronized void setNumOfEls(int index, int val) {
        s.setNumOfEls(index, val);
    }

    public synchronized int getLength(){
        return s.getLength();
    }

    @Override
    public synchronized void output(OutputStream out) {
        s.output(out);
    }

    @Override
    public synchronized void write(Writer out) {
        s.write(out);
    }
}
