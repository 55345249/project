package com.primeton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {


    @RequestMapping("/main1")
    public String main1() {

        return "/zelda/userList";
    }

}
