package org.example.controller;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.dao.LocationDao;
import org.example.entities.Location;
import org.example.enums.DateFormatter;
import org.example.enums.Mainland;
import org.example.enums.Mapper;
import org.example.service.JsMappingService;
import org.example.service.LocationService;
import org.example.vo.LocationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Arrays;

@Controller
@RequestMapping("/js/location")
public class JsLocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private LocationDao locationDao;

    @Autowired
    private JsMappingService jsMappingService;

    @RequestMapping(value = "/getAll.form", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayNode getAll() {
        return jsMappingService.mapObjects(locationDao.returnAll(), Mapper.LOCATION);
    }

    @RequestMapping(value = "/mainlands.form", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayNode mainlands() {
        return jsMappingService.mapObjects(Arrays.asList(Mainland.values()), Mapper.MAINLAND);
    }

    @RequestMapping(value = "/create.form", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ObjectNode create(@ModelAttribute("locationForm") LocationForm locationForm) throws ParseException {
        Location location;
        if (locationForm.getId() != null)
            location = locationService.updateLocationFromForm(locationForm, DateFormatter.DATE_FORMATTER_JS);
        else location = locationService.saveLocationFromForm(locationForm, DateFormatter.DATE_FORMATTER_JS);
        return jsMappingService.mapResult(location, Mapper.LOCATION);
    }

    @RequestMapping(value = "/delete.form", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ObjectNode delete(@RequestParam Integer[] array) {
        for (Integer id : array) {
            locationDao.delete(locationDao.findById(id));
        }
        return jsMappingService.mapResult(Arrays.asList(array), Mapper.OBJECT_ID);
    }
}
