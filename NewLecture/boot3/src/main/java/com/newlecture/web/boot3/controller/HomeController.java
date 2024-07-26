package com.newlecture.web.boot3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HomeController {

    @GetMapping("/mainController")
    public String mainController(){
        return "main";
    }

    @GetMapping("/categoryController")
    public String categoryController() {
        return "category";
    }

    @GetMapping("/index")
    public String index() {
        return "notice/index";
    }
    

}
