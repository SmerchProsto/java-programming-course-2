package com.company.Series;

import java.io.OutputStream;
import java.io.Writer;

public interface Seriesable {

    int MAX_ELEMENTS = 100;
    int[] ELEMENTS = new int[MAX_ELEMENTS];
    int[] FILLED_ELEMENTS = new int[MAX_ELEMENTS];

    default int getLength(){
        return ELEMENTS.length;
    }

    default int getNumOfEls(int index){
        return ELEMENTS[index];
    }

    default void setNumOfEls(int index, int val){
        ELEMENTS[index] = val;
        return;
    }

    void output(OutputStream out);

    void write(Writer out);
}
