package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/js")
public class JsController {

    @RequestMapping("/application.form")
    public String showEntities() {

        return "jsPages/index";
    }
}