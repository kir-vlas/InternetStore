package com.drakezzz.internetstore.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebClientController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
