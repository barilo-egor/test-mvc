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

        return questDao.save(questConvert(questForm));
    }

    public Quest updateQuestFromForm(QuestForm questForm) {
        Quest quest = questConvert(questForm);
        questDao.update(quest);
        return quest;
    }

    public Quest questConvert(QuestForm questForm) {
        if (questForm.getId() != null) {
            return new Quest(
                    questForm.getId(),
                    questForm.getName(),
                    questForm.getQuestType(),
                    npcDao.findById(questForm.getNpcId()));
        } else {
            return new Quest(
                    questForm.getName(),
                    questForm.getQuestType(),
                    npcDao.findById(questForm.getNpcId()));
        }
    }

    public QuestForm questConvert(Quest quest) {
        return new QuestForm(
                quest.getId(),
                quest.getName(),
                quest.getQuestType(),
                quest.getNonPlayerCharacter().getId());
    }
}
