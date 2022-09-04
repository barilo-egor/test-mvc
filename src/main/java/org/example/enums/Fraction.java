package org.example.enums;

public enum Fraction {

    HORDE("Орда"),
    ALLIANCE("Альянс");

    private final String displayName;

    Fraction(String name) {
        this.displayName = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getName() {
        return this.name();
    }
}
