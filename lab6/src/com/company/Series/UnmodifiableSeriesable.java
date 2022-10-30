package com.company.Series;


import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;

public class UnmodifiableSeriesable implements Seriesable {
    private final Seriesable s;

    public UnmodifiableSeriesable(Seriesable s) {
        this.s = s;
    }

    @Override
    public int getNumOfEls(int index) {
        return s.getNumOfEls(index);
    }

    @Override
    public void setNumOfEls(int index, int val) {
        throw new UnsupportedOperationException("неподдерживаемая операция: невозможно значение элемента");
    }

    public synchronized int getLength(){
        return s.getLength();
    }

    @Override
    public void output(OutputStream out) {
        s.output(out);
    }

    @Override
    public void write(Writer out) {
        s.write(out);
    }

}
