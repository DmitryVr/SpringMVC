package com.company.controller;

import com.company.model.Developer;
import com.company.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * контроллер
 */
@Controller
//@SessionAttributes({"listPosition", "listGender", "listEmployees", "employee", "listYears"}) - сессия для spring
// общий урл для всех методов
//@RequestMapping("/spring")
public class MyController {
    @Autowired
    private DeveloperService developerServiceImpl;

    // метод для каждого реквеста будет добавлять в модель коллекцию объектов
    @ModelAttribute("developers")
    public List<Developer> getAllDevelopers() {
        List<Developer> allDevelopers = developerServiceImpl.getAll();
        return allDevelopers;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start() {
        return "start";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("developer", developerServiceImpl.getById(1));
        model.addAttribute("message", "Hello Spring");
        return "hello";
    }

    //  урлы /hello2 and /hello3, отзываются на get и post
    @RequestMapping(value = {"/hello2", "/hello3"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView sayHello2(ModelMap model) {
        model.addAttribute("message", "Spring Hello 2");
        return new ModelAndView("hello", model);
    }

    // получить id
    @RequestMapping(value = "/getId/{id}", method = RequestMethod.GET)
    public void getId(@PathVariable("id") String id) {

    }

    // для получения дыннах из формы, на spf страницу надо послать пустой объект
    @RequestMapping(method = RequestMethod.POST)
    public String add(@ModelAttribute("developer") Developer developer) {
        developerServiceImpl.update(developer);
        return "/go";
    }

    // записать девелопера в респонс (возвращает как JSON)
//    @RequestMapping(value = "/helloResponse", method = RequestMethod.GET)
//    public @ResponseBody Developer sayDeveloper() {
//        Developer developer = developerServiceImpl.getById(2);
//        return developer;
//    }

//    валидация
}
