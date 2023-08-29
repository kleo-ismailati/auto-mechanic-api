package com.auto_mechanic.auto_mechanic_api.api.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/")
@ApiIgnore
public class MainController {

    @GetMapping
    public ModelAndView getRedirectUrl(ModelMap model) {
        return new ModelAndView("redirect:/swagger-ui/", model);
    }
}
