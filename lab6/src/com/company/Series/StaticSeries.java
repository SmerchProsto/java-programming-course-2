package com.company.Series;

import com.company.Factories.SeriesableFactory;
import com.company.Series.SerObject;

public class StaticSeries {
    // region для фабрик
    private static SeriesableFactory factory = (SeriesableFactory) new SerObject();

    public static void setSeriesableFactory(SeriesableFactory sf) {
        factory = sf;
    }

    public static Seriesable createInstance() {
        return factory.createInstance();
    }
}