package org.example.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.entities.Location;
import org.example.enums.*;
import org.example.vo.LocationForm;
import org.example.vo.NpcForm;
import org.example.vo.QuestForm;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

@Service
public class JspMappingService {
    public void mapObject(Object object, ModelMapper modelMapper, ModelMap modelMap) {
        modelMapper.getObjectMapper().apply(object, modelMap);
    }
//    public ModelAndView showQuestSaveForm() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("questForm", new QuestForm());
//        modelAndView.addObject("questTypes", QuestType.values());
//        modelAndView.addObject("nonPlayerCharacters", npcDao.returnAll());
//        modelAndView.setViewName("quest/questAdd");
//        return modelAndView;
//    }
//
//    public ModelAndView showNpcSaveForm() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("npcForm", new NpcForm());
//        modelAndView.addObject("fractions", Fraction.values());
//        modelAndView.addObject("locations", locationDao.returnAll());
//        modelAndView.setViewName("npc/npcAdd");
//        return modelAndView;
//    }
//
//    public ModelAndView showLocationSaveForm() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("location", new Location());
//        modelAndView.addObject("mainlands", Mainland.values());
//        modelAndView.setViewName("location/locationAdd");
//        return modelAndView;
//    }
//
//    public ModelAndView showLocationEditForm(@PathVariable("id") Integer id) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("questForm", questService.questConvert(questDao.findById(id)));
//        modelAndView.addObject("questTypes", QuestType.values());
//        modelAndView.addObject("nonPlayerCharacters", npcDao.returnAll());
//        modelAndView.setViewName("quest/questEdit");
//        return modelAndView;
//    }
//
//    public ModelAndView showNpcEditForm(@PathVariable("id") Integer id) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("npcForm", npcService.npcConvert(npcDao.findById(id)));
//        modelAndView.addObject("fractions", Fraction.values());
//        modelAndView.addObject("locations", locationDao.returnAll());
//        modelAndView.setViewName("npc/npcEdit");
//        return modelAndView;
//    }
//
//    public ModelAndView showLocationEditForm(@PathVariable("id") Integer id) {
//        LocationForm locationForm = locationService.locationConvert(locationDao.findById(id));
//        return new ModelAndView("location/locationEdit", "locationForm",
//                locationForm);
//        }
    }
