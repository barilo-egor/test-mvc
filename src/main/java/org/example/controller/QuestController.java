package org.example.controller;

import org.example.dao.NPCDao;
import org.example.dao.QuestDao;
import org.example.entities.Quest;
import org.example.enums.QuestType;
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

    @RequestMapping("/list.form")
    public ModelAndView showNpc() {

        return new ModelAndView("quests", "quests", questDao.returnAll());
    }

    @RequestMapping("/add.form")
    public ModelAndView showQuestSaveForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("questForm", new QuestForm());
        modelAndView.addObject("questTypes", QuestType.values());
        modelAndView.addObject("nonPlayerCharacters", npcDao.returnAll());
        modelAndView.setViewName("questAdd");
        return modelAndView;
    }

    @RequestMapping(value = "/save.form", method = RequestMethod.POST)
    public String saveQuest(@ModelAttribute("questForm") QuestForm questForm, ModelMap model) {

        Quest quest = questService.saveQuestFromForm(questForm);
        model.addAttribute("id", quest.getId());
        model.addAttribute("name", quest.getName());
        model.addAttribute("questType",quest.getQuestType().getDisplayName());
        model.addAttribute("npc",quest.getNonPlayerCharacter().getName());
        return "questSave";
    }

    @RequestMapping(value = "/{id}/edit.form")
    public ModelAndView showLocationEditForm(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("questForm", questService.questConvert(questDao.findById(id)));
        modelAndView.addObject("questTypes", QuestType.values());
        modelAndView.addObject("nonPlayerCharacters", npcDao.returnAll());
        modelAndView.setViewName("questEdit");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/update.form", method = RequestMethod.POST)
    public String updateLocation(@ModelAttribute("questForm") QuestForm questForm, ModelMap model) {
        Quest quest = questService.updateQuestFromForm(questForm);
        model.addAttribute("id", quest.getId());
        model.addAttribute("name", quest.getName());
        model.addAttribute("questType",quest.getQuestType().getDisplayName());
        model.addAttribute("npc",quest.getNonPlayerCharacter().getName());
        return "questUpdate";
    }

    @RequestMapping("/{id}/delete.form")
    public ModelAndView deleteLocation(@PathVariable("id") Integer id) {
        questDao.delete(questDao.findById(id));
        return new ModelAndView("redirect:/jsp/entities/quest/list.form", "nonPlayerCharacters", npcDao.returnAll());
    }
}