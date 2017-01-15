package com.company.controller;

import com.company.model.Upload;
import com.company.service.UploadService;
import com.company.uploadObjects.UploadedFile;
import com.company.validators.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@Controller
@SessionAttributes("filename")
public class MyController {
    @Autowired
    private UploadService uploadServiceImpl;

    @Autowired
    private FileValidator fileValidator;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start() {
        return "main";
    }

    // получение данных с формы
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView uploadFile(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, BindingResult result) {// имена параметров - как на форме jsp
        ModelAndView modelAndView = new ModelAndView();

        String fileName = null;

        MultipartFile file = uploadedFile.getFile(); // получить файл
        fileValidator.validate(uploadedFile, result);

        if (result.hasErrors()) {
            modelAndView.setViewName("main"); // если есть ошибки перейти на страницу и отобразить их
        } else {
            try {
                byte[] bytes = file.getBytes();

                fileName = file.getOriginalFilename();

                Upload upload = new Upload();
                upload.setName("New poster");
                upload.setContent(bytes);
                uploadServiceImpl.add(upload);


                RedirectView redirectView = new RedirectView("fileuploaded"); // редирект на страницу
                redirectView.setStatusCode(HttpStatus.FOUND); // установить код статуса
                modelAndView.setView(redirectView); // установить вью
                modelAndView.addObject("filename", fileName); // в сессию, чтобы при обновлении страницы не потерять

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return modelAndView;
    }

    @RequestMapping(value = "/fileuploaded", method = RequestMethod.GET)
    public String fileUploaded() {
        return "fileuploaded";
    }
}
