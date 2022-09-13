package org.example.enums;

public enum QuestType {

    STORY("сюжетный"),
    SECONDARY("второстепенный"),
    LOCAL("локальный"),
    DAILY("ежедневный"),
    WEEKLY("еженедельный");

    final String displayName;

    QuestType(String name) {
        this.displayName = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getName() {
        return this.name();
    }
}
