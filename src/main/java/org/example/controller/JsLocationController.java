package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.dao.LocationDao;
import org.example.entities.Location;
import org.example.enums.Mainland;
import org.example.vo.LocationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/js/location")
public class JsLocationController {

    @Autowired
    private LocationDao locationDao;

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @RequestMapping(value = "/getAll.form", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayNode getAll() {
        ArrayNode arrayNode = OBJECT_MAPPER.createArrayNode();
        List<Location> locations = locationDao.returnAll();
        for (Location location : locations) {
            ObjectNode objectNode = OBJECT_MAPPER.createObjectNode();
            objectNode.put("id", location.getId());
            objectNode.put("name", location.getName());
            objectNode.put("mainland", location.getMainland().getDisplayName());
            objectNode.put("introductionDate", location.getIntroductionDate().toString());
            arrayNode.add(objectNode);
        }
        return arrayNode;
    }
    @RequestMapping(value = "/mainlands.form", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayNode mainlands() {
        ArrayNode arrayNode = OBJECT_MAPPER.createArrayNode();
        for (Mainland mainland : Mainland.values()) {
            ObjectNode objectNode = OBJECT_MAPPER.createObjectNode();
            objectNode.put("name", mainland.getName());
            objectNode.put("displayName", mainland.getDisplayName());
            arrayNode.add(objectNode);
        }
        return arrayNode;
    }
    @RequestMapping(value = "/create.form", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ObjectNode create(@ModelAttribute Location location) {
        ObjectNode objectNode = OBJECT_MAPPER.createObjectNode();
        ObjectNode result = OBJECT_MAPPER.createObjectNode();
        if (location.getId() != null) locationDao.update(location);
        else locationDao.save(location);
        objectNode.put("id", location.getId());
        objectNode.put("name", location.getName());
        objectNode.put("mainland", location.getMainland().getDisplayName());
        objectNode.put("introductionDate", location.getIntroductionDate().toString());
        result.put("success", true);
        result.put("result", objectNode);
        return result;
    }
}
