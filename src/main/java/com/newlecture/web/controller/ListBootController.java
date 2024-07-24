package com.newlecture.web.controller;

@Controller
public class ListBootController {

    @getMapping("/exam/list")
    public String main() {
        return "list";
    }

    @PostMapping("/exam/list")
    public String doPost() {
        return "list";
    }

    @getMapping("/result")
    public String getResult() {
        return "result";
    }

    @PostMapping("/result")
    public String postResult() {
        return "result";
    }
}















