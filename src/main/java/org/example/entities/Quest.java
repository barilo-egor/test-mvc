package org.example.entities;

import org.example.enums.QuestType;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Quest extends BasePersist {

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private QuestType questType;

    @OneToOne
    private NonPlayerCharacter nonPlayerCharacter;

    public Quest() {
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
