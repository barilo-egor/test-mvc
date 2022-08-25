package org.example.enums;

public enum Fraction {

    HORDE("Орда"),
    ALLIANCE("Альянс");

    private final String name;

    Fraction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
