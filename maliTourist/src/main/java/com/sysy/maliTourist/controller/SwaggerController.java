package com.sysy.maliTourist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@RequestMapping("/") //utilisé pour mapper les rêquttes web.
//permet de detecter automatiquement les classes d'implementations via l'analyse du chemin de classe
@Controller
public class SwaggerController {

    @RequestMapping(method = RequestMethod.GET)
    public String swaggerUi() {
        return "redirect:/swagger-ui.html";
    }
}
