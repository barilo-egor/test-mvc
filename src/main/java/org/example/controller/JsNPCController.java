package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.dao.LocationDao;
import org.example.dao.NPCDao;
import org.example.entities.NonPlayerCharacter;
import org.example.enums.Fraction;
import org.example.enums.Mapper;
import org.example.service.JsMappingService;
import org.example.service.NpcService;
import org.example.vo.NpcForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/js/npc")
public class JsNPCController {

    @Autowired
    private NPCDao npcDao;

    @Autowired
    private LocationDao locationDao;

    @Autowired
    private NpcService npcService;

    @Autowired
    private JsMappingService jsMappingService;

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @RequestMapping(value = "/getAll.form", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayNode getAll() {
        return jsMappingService.mapObjects(npcDao.returnAll(), Mapper.NPC);
    }

    @RequestMapping(value = "/fractions.form", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayNode fractions() {
        return jsMappingService.mapObjects(Arrays.asList(Fraction.values()), Mapper.FRACTION);
    }

    @RequestMapping(value = "/locations.form", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayNode locations() {
        return jsMappingService.mapObjects(locationDao.returnAll(), Mapper.NPC_LOCATION);
    }

    @RequestMapping(value = "/create.form", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ObjectNode create(@ModelAttribute("npcForm") NpcForm npcForm) {
        NonPlayerCharacter npc;
        if (npcForm.getId() != null) npc = npcService.updateNpcFromForm(npcForm);
        else npc = npcService.saveNpcFromForm(npcForm);
        return jsMappingService.mapResult(npc, Mapper.NPC);
    }

    @RequestMapping(value = "/delete.form", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ObjectNode delete(@RequestParam Integer[] array) {
        for (Integer id : array) {
            npcDao.delete(npcDao.findById(id));
        }
        return jsMappingService.mapResult(Arrays.asList(array), Mapper.OBJECT_ID);
    }
}
