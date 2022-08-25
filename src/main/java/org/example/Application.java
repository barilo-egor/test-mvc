package org.example;

import org.example.dao.QuestDao;
import org.example.entities.Quest;
import org.example.enums.QuestType;

public class Application {
    public static void main(String[] args) {
        QuestDao questDao = new QuestDao();
        Quest quest = new Quest("Простое задание", QuestType.STORY);
        System.out.println(questDao.save(quest));
    }
}
