package org.example.controller;

import org.example.dao.LocationDao;
import org.example.dao.NPCDao;
import org.example.entities.NonPlayerCharacter;
import org.example.enums.Fraction;
import org.example.enums.ModelMapper;
import org.example.service.JspMappingService;
import org.example.service.NpcService;
import org.example.vo.NpcForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @Autowired
    private JspMappingService jspMappingService;

    @RequestMapping("/list.form")
    public ModelAndView showNpc() {

        return new ModelAndView("npc/npc", "nonPlayerCharacters", npcDao.returnAll());
    }

    @RequestMapping("/add.form")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("npcForm", new NpcForm());
        modelAndView.addObject("fractions", Fraction.values());
        modelAndView.addObject("locations", locationDao.returnAll());
        modelAndView.setViewName("npc/npcAdd");
        return modelAndView;
    }

    @RequestMapping(value = "/save.form", method = RequestMethod.POST)
    public String save(@ModelAttribute("npcForm") NpcForm npcForm, ModelMap model) {
        NonPlayerCharacter npc;
        if (npcForm.getId() != null) npc = npcService.updateNpcFromForm(npcForm);
        else npc = npcService.saveNpcFromForm(npcForm);
        jspMappingService.mapObject(npc, ModelMapper.NPC, model);
        return "npc/npcSave";
    }

    @RequestMapping(value = "/{id}/edit.form")
    public ModelAndView edit(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("npcForm", npcService.npcConvert(npcDao.findById(id)));
        modelAndView.addObject("fractions", Fraction.values());
        modelAndView.addObject("locations", locationDao.returnAll());
        modelAndView.addObject("bool", true);
        modelAndView.setViewName("npc/npcEdit");
        return modelAndView;
    }

    @RequestMapping("/{id}/delete.form")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        npcDao.delete(npcDao.findById(id));
        return new ModelAndView("redirect:/jsp/entities/npc/list.form", "nonPlayerCharacters", npcDao.returnAll());
    }
}
