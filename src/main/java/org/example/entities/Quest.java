package org.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import org.example.enums.QuestType;

import java.util.Objects;

public class Quest extends BasePersist{

    @Column
    private String name;

    @Column
    private QuestType questType;

    @ManyToOne
    private NonPlayerCharacter nonPlayerCharacter;

    public Quest() {
    }

    public Quest(String name, QuestType questType) {
        this.name = name;
        this.questType = questType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QuestType getQuestType() {
        return questType;
    }

    public void setQuestType(QuestType questType) {
        this.questType = questType;
    }

    public NonPlayerCharacter getNonPlayerCharacter() {
        return nonPlayerCharacter;
    }

    public void setNonPlayerCharacter(NonPlayerCharacter nonPlayerCharacter) {
        this.nonPlayerCharacter = nonPlayerCharacter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Quest quest = (Quest) o;
        return Objects.equals(name, quest.name) && questType == quest.questType && Objects.equals(nonPlayerCharacter, quest.nonPlayerCharacter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, questType, nonPlayerCharacter);
    }

    @Override
    public String toString() {
        return "Quest{" +
                "name='" + name + '\'' +
                ", questType=" + questType +
                ", nonPlayerCharacter=" + nonPlayerCharacter +
                "} " + super.toString();
    }
}
