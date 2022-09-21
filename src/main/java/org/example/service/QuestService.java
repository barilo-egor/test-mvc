package org.example.service;

import org.example.dao.NPCDao;
import org.example.dao.QuestDao;
import org.example.entities.Quest;
import org.example.vo.QuestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestService {

    private final NPCDao npcDao;

    private final QuestDao questDao;

    @Autowired
    public QuestService(NPCDao npcDao, QuestDao questDao) {
        this.npcDao = npcDao;
        this.questDao = questDao;
    }

    public Quest saveQuestFromForm(QuestForm questForm) {

        return questDao.save(convertToQuest(questForm));
    }

    public Quest updateQuestFromForm(QuestForm questForm) {
        Quest quest = convertToQuest(questForm);
        questDao.update(quest);
        return quest;
    }

    public Quest convertToQuest(QuestForm questForm) {
        Quest quest = new Quest();
        quest.setId(questForm.getId());
        quest.setName(questForm.getName());
        quest.setQuestType(questForm.getQuestType());
        quest.setNonPlayerCharacter(npcDao.findById(questForm.getNpcId()));
        return quest;
    }

    public QuestForm convertToQuestForm(Quest quest) {
        QuestForm questForm = new QuestForm();
        questForm.setId(quest.getId());
        questForm.setName(quest.getName());
        questForm.setQuestType(quest.getQuestType());
        questForm.setNpcId(quest.getNonPlayerCharacter().getId());
        return questForm;
    }
}
