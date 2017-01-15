package com.company.controller;

import com.company.model.Developer;
import com.company.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private DeveloperService developerServiceImpl;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start() {
        return "start";
    }

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("developer", developerServiceImpl.getById(1));
        return "hello";
    }
}
