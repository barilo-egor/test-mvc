package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/main")
public class MainController {

    @RequestMapping("/hello")
    public String hello() {
        return "index";
    }
}
