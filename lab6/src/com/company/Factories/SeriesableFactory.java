package com.company.Factories;

import com.company.Series.Seriesable;

public interface SeriesableFactory {
    default Seriesable createInstance(){
        Seriesable s = null;
        return s;
    }
}
