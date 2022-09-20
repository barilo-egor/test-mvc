package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.dao.NPCDao;
import org.example.dao.QuestDao;
import org.example.entities.Quest;
import org.example.enums.Mapper;
import org.example.enums.QuestType;
import org.example.service.JsMappingService;
import org.example.service.QuestService;
import org.example.vo.QuestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/js/quest")
public class JsQuestController {

    @Autowired
    private QuestDao questDao;

    @Autowired
    private NPCDao npcDao;

    @Autowired
    private QuestService questService;

    @Autowired
    private JsMappingService jsMappingService;

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @RequestMapping(value = "/getAll.form", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayNode getAll() {
        return jsMappingService.mapObjects(questDao.returnAll(), Mapper.QUEST);
    }

    @RequestMapping(value = "/questTypes.form", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayNode questTypes() {
        return jsMappingService.mapObjects(Arrays.asList(QuestType.values()), Mapper.QUEST_TYPE);
    }

    @RequestMapping(value = "/npc.form", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayNode npc() {
        return jsMappingService.mapObjects(npcDao.returnAll(), Mapper.QUEST_NPC);
    }

    @RequestMapping(value = "/create.form", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ObjectNode create(@ModelAttribute("questForm") QuestForm questForm) {
        Quest quest;
        if (questForm.getId() != null) quest = questService.updateQuestFromForm(questForm);
        else quest = questService.saveQuestFromForm(questForm);
        return jsMappingService.mapResult(jsMappingService.mapObject(quest, Mapper.QUEST));
    }

    @RequestMapping(value = "/delete.form", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ObjectNode delete(@RequestParam Integer[] array) {
        for (Integer id : array) {
            questDao.delete(questDao.findById(id));
        }
        return jsMappingService.mapResult(jsMappingService.mapObjects(Arrays.asList(array), Mapper.OBJECT_ID));
    }
}
