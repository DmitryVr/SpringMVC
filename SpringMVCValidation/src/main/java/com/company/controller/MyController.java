package com.company.controller;

import com.company.model.Developer;
import com.company.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MyController {
    @Autowired
    private DeveloperService developerServiceImpl;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(Model model) {
        model.addAttribute("developer", new Developer());
        return "login";
    }

    // получение данных с формы
    @RequestMapping(value = "check-user", method = RequestMethod.POST)
    public String checkUser(@Valid @ModelAttribute("developer") Developer developer,
                            BindingResult bindingResult,
                            Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        model.addAttribute("developer", developer);
        return "main";
    }
}
