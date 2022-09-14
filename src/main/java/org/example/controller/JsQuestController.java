package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.dao.NPCDao;
import org.example.dao.QuestDao;
import org.example.entities.NonPlayerCharacter;
import org.example.entities.Quest;
import org.example.enums.QuestType;
import org.example.service.QuestService;
import org.example.vo.QuestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/js/quest")
public class JsQuestController {

    @Autowired
    private QuestDao questDao;

    @Autowired
    private NPCDao npcDao;

    @Autowired
    private QuestService questService;

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    
    @RequestMapping(value = "/getAll.form", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayNode getAll() {
        ArrayNode arrayNode = OBJECT_MAPPER.createArrayNode();
        List<Quest> quests = questDao.returnAll();
        for (Quest quest : quests) {
            ObjectNode objectNode = OBJECT_MAPPER.createObjectNode();
            objectNode.put("id", quest.getId());
            objectNode.put("name", quest.getName());
            objectNode.put("questType", quest.getQuestType().getDisplayName());
            objectNode.put("npc", quest.getNonPlayerCharacter().getName());
            arrayNode.add(objectNode);
        }
        return arrayNode;
    }
    @RequestMapping(value = "/questTypes.form", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayNode questTypes() {
        ArrayNode arrayNode = OBJECT_MAPPER.createArrayNode();
        for (QuestType questType : QuestType.values()) {
            ObjectNode objectNode = OBJECT_MAPPER.createObjectNode();
            objectNode.put("name", questType.getName());
            objectNode.put("displayName", questType.getDisplayName());
            arrayNode.add(objectNode);
        }
        return arrayNode;
    }
    @RequestMapping(value = "/npc.form", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayNode npc() {
        ArrayNode arrayNode = OBJECT_MAPPER.createArrayNode();
        List<NonPlayerCharacter> nonPlayerCharacters = npcDao.returnAll();
        for (NonPlayerCharacter npc : nonPlayerCharacters) {
            ObjectNode objectNode = OBJECT_MAPPER.createObjectNode();
            objectNode.put("id", npc.getId());
            objectNode.put("name", npc.getName());
            arrayNode.add(objectNode);
        }
        return arrayNode;
    }
    @RequestMapping(value = "/create.form", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ObjectNode create(@ModelAttribute("questForm") QuestForm questForm) {
        ObjectNode objectNode = OBJECT_MAPPER.createObjectNode();
        ObjectNode result = OBJECT_MAPPER.createObjectNode();
        Quest quest = null;
        if (questForm.getId() != null) quest = questService.updateQuestFromForm(questForm);
        else quest = questService.saveQuestFromForm(questForm);
        objectNode.put("id", quest.getId());
        objectNode.put("name", quest.getName());
        objectNode.put("questType", quest.getQuestType().getDisplayName());
        objectNode.put("npc", quest.getNonPlayerCharacter().getName());
        result.put("success", true);
        result.put("result", objectNode);
        return result;
    }
    @RequestMapping(value = "/delete.form", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ObjectNode delete(@RequestParam Integer[] array) {
        ArrayNode arrayNode = OBJECT_MAPPER.createArrayNode();
        ObjectNode result = OBJECT_MAPPER.createObjectNode();
        for (Integer id : array) {
            ObjectNode objectNode = OBJECT_MAPPER.createObjectNode();
            Quest quest = questDao.findById(id);
            questDao.delete(quest);
            objectNode.put("id", quest.getId());
            arrayNode.add(objectNode);
        }
        result.put("success", true);
        result.put("results", arrayNode);
        return result;
    }
}
