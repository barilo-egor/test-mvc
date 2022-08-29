package org.example.controller;

import org.example.entities.Quest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping("/hello.form")
    public String hello() {
        return "index";
    }

    @RequestMapping("/addQuest.form")
    public ModelAndView addQuest() {
        return new ModelAndView("quest", "command", new Quest());
    }

    @RequestMapping(value = "/showQuest.jsp.form", method = RequestMethod.POST)
    public String addQuest(@ModelAttribute("mvc-dispatcher") Quest quest, ModelMap model) {
        model.addAttribute("id", quest.getId());
        model.addAttribute("id", quest.getName());
        model.addAttribute("id", quest.getQuestType());
        return "showQuest.jsp";
    }


}
