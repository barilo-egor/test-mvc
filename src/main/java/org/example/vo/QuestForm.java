package org.example.vo;

import org.example.enums.QuestType;

import java.util.Objects;

public class QuestForm {

    private Integer id;

    private String name;

    private QuestType questType;

    private Integer npcId;

    public QuestForm() {
    }

    public QuestForm(Integer id, String name, QuestType questType, Integer npcId) {
        this.id = id;
        this.name = name;
        this.questType = questType;
        this.npcId = npcId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


    public Integer getNpcId() {
        return npcId;
    }

    public void setNpcId(Integer npcId) {
        this.npcId = npcId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestForm questForm = (QuestForm) o;
        return Objects.equals(id, questForm.id) && Objects.equals(name, questForm.name) && questType == questForm.questType && Objects.equals(npcId, questForm.npcId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, questType, npcId);
    }

    @Override
    public String toString() {
        return "QuestForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", questType=" + questType +
                ", npcId=" + npcId +
                '}';
    }
}
