package com.newlecture.web.controller;

@Controller
public class ListBootController {

    @getMapping("/nidlogin.login")
    public String main() {
        String[] parameter = "url".split("?");
        String[] split = parameter[1].split("&");
        //"id=\"기성짱짱" , password="1234"

        return "list";
    }


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















