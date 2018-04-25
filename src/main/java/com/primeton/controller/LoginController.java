package com.primeton.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping({ "/index" })
    public String index(Model model) {

        logger.info("--------index----------");

        model.addAttribute("picUrl","/img/profile_small.jpg");

        model.addAttribute("username", "admin");

        return "index_v1";
    }

}
