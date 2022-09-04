package org.example.enums;

public enum Mainland {

    EASTERN_KINGDOMS("Восточные королевства"),
    KALIMDOR("Калимдор"),
    NORTHREND("Нордскол"),
    PANDARIA("Пандария"),
    SPLIT_ISLANDS("Расколотые острова"),
    ZANDALAR("Зандалар"),
    KUL_TIRAS("Кул-Тирас");

    private final String displayName;

    Mainland(String name) {
        this.displayName = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getName() {
        return this.name();
    }
}

