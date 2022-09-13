package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.dao.LocationDao;
import org.example.dao.NPCDao;
import org.example.entities.Location;
import org.example.entities.NonPlayerCharacter;
import org.example.entities.Quest;
import org.example.enums.Fraction;
import org.example.service.NpcService;
import org.example.vo.NpcForm;
import org.example.vo.QuestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/js/npc")
public class JsNPCController {

    @Autowired
    private NPCDao npcDao;

    @Autowired
    private LocationDao locationDao;

    @Autowired
    private NpcService npcService;

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @RequestMapping(value = "/getAll.form", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayNode getAll() {
        ArrayNode arrayNode = OBJECT_MAPPER.createArrayNode();
        List<NonPlayerCharacter> nonPlayerCharacters = npcDao.returnAll();
        for (NonPlayerCharacter npc : nonPlayerCharacters) {
            ObjectNode objectNode = OBJECT_MAPPER.createObjectNode();
            objectNode.put("id", npc.getId());
            objectNode.put("name", npc.getName());
            objectNode.put("eliteStatus", npc.isEliteStatus());
            objectNode.put("fraction", npc.getFraction().getDisplayName());
            objectNode.put("location", npc.getLocation().getName());
            arrayNode.add(objectNode);
        }
        return arrayNode;
    }
    @RequestMapping(value = "/fractions.form", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayNode fractions() {
        ArrayNode arrayNode = OBJECT_MAPPER.createArrayNode();
        for (Fraction fraction : Fraction.values()) {
            ObjectNode objectNode = OBJECT_MAPPER.createObjectNode();
            objectNode.put("name", fraction.getName());
            objectNode.put("displayName", fraction.getDisplayName());
            arrayNode.add(objectNode);
        }
        return arrayNode;
    }
    @RequestMapping(value = "/locations.form", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayNode locations() {
        ArrayNode arrayNode = OBJECT_MAPPER.createArrayNode();
        List<Location> locations = locationDao.returnAll();
        for (Location location : locations) {
            ObjectNode objectNode = OBJECT_MAPPER.createObjectNode();
            objectNode.put("id", location.getId());
            objectNode.put("name", location.getName());
            arrayNode.add(objectNode);
        }
        return arrayNode;
    }
    @RequestMapping(value = "/create.form", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ObjectNode create(@ModelAttribute("npcForm") NpcForm npcForm) {
        ObjectNode objectNode = OBJECT_MAPPER.createObjectNode();
        ObjectNode result = OBJECT_MAPPER.createObjectNode();
        NonPlayerCharacter npc = null;
        if (npcForm.getId() != null) npc = npcService.updateNpcFromForm(npcForm);
        else npc = npcService.saveNpcFromForm(npcForm);
        objectNode.put("id", npc.getId());
        objectNode.put("name", npc.getName());
        objectNode.put("isEliteStatus", npc.isEliteStatus());
        objectNode.put("fraction", npc.getFraction().getDisplayName());
        objectNode.put("location", npc.getLocation().getName());
        result.put("success", true);
        result.put("result", objectNode);
        return result;
    }
}
