package org.example.enums;

public enum Mainland {

    EASTERN_KINGDOMS("Восточные королевства"),
    KALIMDOR("Калимдор"),
    NORTHREND("Нордскол"),
    PANDARIA("Пандария"),
    SPLIT_ISLANDS("Расколотые острова"),
    ZANDALAR("Зандалар"),
    KUL_TIRAS("Кул-Тирас");

    private final String name;

    Mainland(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

