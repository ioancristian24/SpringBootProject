package com.sda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandingPageController {

    @RequestMapping("/") //face maparea dintre requestul venit din browser si resursa din aplicatie
    public String index(){
        return "Bine ati venit pe prima pagina! ";
    }
}
