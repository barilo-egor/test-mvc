package org.example.controller;

import org.example.dao.NPCDao;
import org.example.dao.QuestDao;
import org.example.entities.Quest;
import org.example.enums.ModelMapper;
import org.example.enums.QuestType;
import org.example.service.JspMappingService;
import org.example.service.QuestService;
import org.example.vo.QuestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/jsp/entities/quest")
public class QuestController {

    @Autowired
    private NPCDao npcDao;

    @Autowired
    private QuestDao questDao;

    @Autowired
    private QuestService questService;

    @Autowired
    private JspMappingService jspMappingService;

    @RequestMapping("/list.form")
    public ModelAndView showNpc() {

        return new ModelAndView("quest/quests", "quests", questDao.returnAll());
    }

    @RequestMapping("/add.form")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("questForm", new QuestForm());
        modelAndView.addObject("questTypes", QuestType.values());
        modelAndView.addObject("nonPlayerCharacters", npcDao.returnAll());
        modelAndView.setViewName("quest/questAdd");
        return modelAndView;
    }

    @RequestMapping(value = "/save.form", method = RequestMethod.POST)
    public String save(@ModelAttribute("questForm") QuestForm questForm, ModelMap model) {
        Quest quest;
        if (questForm.getId() != null) quest = questService.updateQuestFromForm(questForm);
        else quest = questService.saveQuestFromForm(questForm);
        jspMappingService.mapObject(quest, ModelMapper.QUEST, model);
        return "quest/questSave";
    }

    @RequestMapping(value = "/{id}/edit.form")
    public ModelAndView edit(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("questForm", questService.questConvert(questDao.findById(id)));
        modelAndView.addObject("questTypes", QuestType.values());
        modelAndView.addObject("nonPlayerCharacters", npcDao.returnAll());
        modelAndView.setViewName("quest/questEdit");
        return modelAndView;
    }

    @RequestMapping("/{id}/delete.form")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        questDao.delete(questDao.findById(id));
        return new ModelAndView("redirect:/jsp/entities/quest/list.form", "nonPlayerCharacters", npcDao.returnAll());
    }
}