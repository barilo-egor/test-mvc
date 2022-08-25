package org.example.enums;

public enum QuestType {

    STORY("сюжетное"),
    SECONDARY("второстепенное"),
    LOCAL("локальное"),
    DAILY("ежедневное"),
    WEEKLY("еженедельное");

    private final String name;

    QuestType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
