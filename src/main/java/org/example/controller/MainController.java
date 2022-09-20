package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class MainController {

    @RequestMapping("/entities.form")
    public String entities() {
        return "entities";
    }
}
