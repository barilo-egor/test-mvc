package org.example.controller;

import org.example.dao.LocationDao;
import org.example.dao.NPCDao;
import org.example.entities.NonPlayerCharacter;
import org.example.enums.Fraction;
import org.example.service.NpcService;
import org.example.vo.NpcForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/jsp/entities/npc")
public class NPCController {

    @Autowired
    private LocationDao locationDao;

    @Autowired
    private NPCDao npcDao;

    @Autowired
    private NpcService npcService;

    @RequestMapping("/list.form")
    public ModelAndView showNpc() {

        return new ModelAndView("npc", "nonPlayerCharacters", npcDao.returnAll());
    }

    @RequestMapping("/add.form")
    public ModelAndView showNpcSaveForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("npcForm", new NpcForm());
        modelAndView.addObject("fractions", Fraction.values());
        modelAndView.addObject("locations", locationDao.returnAll());
        modelAndView.setViewName("npcAdd");
        return modelAndView;
    }

    @RequestMapping(value = "/save.form", method = RequestMethod.POST)
    public String saveNpc(@ModelAttribute("npcForm") NpcForm npcForm, ModelMap model) {

        NonPlayerCharacter npc = npcService.saveNpcFromForm(npcForm);
        model.addAttribute("id", npc.getId());
        model.addAttribute("name", npc.getName());
        model.addAttribute("eliteStatus",npc.isEliteStatus());
        model.addAttribute("fraction",npc.getFraction().getDisplayName());
        model.addAttribute("location",npc.getLocation().getName());
        return "npcSave";
    }

    @RequestMapping(value = "/{id}/edit.form")
    public ModelAndView showNpcEditForm(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("npcForm", npcService.npcConvert(npcDao.findById(id)));
        modelAndView.addObject("fractions", Fraction.values());
        modelAndView.addObject("locations", locationDao.returnAll());
        modelAndView.setViewName("npcEdit");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/update.form", method = RequestMethod.POST)
    public String updateNpc(@ModelAttribute("npcForm") NpcForm npcForm, ModelMap model) {
        NonPlayerCharacter npc = npcService.updateNpcFromForm(npcForm);
        model.addAttribute("id", npc.getId());
        model.addAttribute("name", npc.getName());
        model.addAttribute("eliteStatus", npc.isEliteStatus());
        model.addAttribute("fraction", npc.getFraction().getDisplayName());
        model.addAttribute("location", npc.getLocation().getName());
        return "npcUpdate";
    }

    @RequestMapping("/{id}/delete.form")
    public ModelAndView deleteNpc(@PathVariable("id") Integer id) {
        npcDao.delete(npcDao.findById(id));
        return new ModelAndView("redirect:/jsp/entities/npc/list.form", "nonPlayerCharacters", npcDao.returnAll());
    }
}
