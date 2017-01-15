package com.company.controller;

import com.company.exceptions.BadFileNameException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class MyController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start() {
        return "start";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() throws IOException, BadFileNameException {

        if (true) {
            throw new IOException("Folder not found!");
//            throw new BadFileNameException("Bad filename " + "The name");
        }

        return "hello";
    }

    // системная страница с ошибкой
    // когда возникает ошибка IOException она перехватывается этим методом
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Check arguments!")
//    @ExceptionHandler(IOException.class)
//    public void handleIOException() {
////        logger
//    }

    // своя страница с ошибкой
    @ExceptionHandler(BadFileNameException.class)
    public ModelAndView handleBadFileNameException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("errors/error");
        modelAndView.addObject("error", ex.getMessage());
        return modelAndView;
    }
}
