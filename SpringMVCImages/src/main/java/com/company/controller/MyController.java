package com.company.controller;

import com.company.model.Upload;
import com.company.service.UploadService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class MyController {
    private static final Logger log = Logger.getLogger(MyController.class);

    @Autowired
    private UploadService uploadServiceImpl;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(Model model) {
        model.addAttribute("upload", uploadServiceImpl.getAll());

        return "index";
    }

    @RequestMapping(value = "/ok/{id}/{save}", method = RequestMethod.GET)
    public void ok(@PathVariable("id") int id, @PathVariable("save") boolean save, HttpServletResponse response) {
        log.warn("controller ok");
        Upload upload = uploadServiceImpl.getById(id);
        response.setContentType("image/jpeg");
        response.setContentLength(upload.getContent().length);
        if (save == true) {
//            response.setHeader("Content-Disposition", "attachment;filename=file.jpg");
            try {
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(upload.getName(),"UTF-8") + ".jpg");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        // вызвать меню сохранения
//        response.setHeader("Content-Disposition", "attachment;filename=file.jpg");
        try {
//            OutputStream out = response.getOutputStream();
            response.getOutputStream().write(upload.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @RequestMapping(value = "/okk/{id}", method = RequestMethod.GET)
//    public void okk(@PathVariable("id") int id, HttpServletResponse response) {
//        log.warn("controller ok");
//        Upload upload = uploadServiceImpl.getById(id);
//        response.setContentType("image/jpeg");
//        response.setContentLength(upload.getContent().length);
//        // вызвать меню сохранения
//        response.setHeader("Content-Disposition", "attachment;filename=file.jpg");
//        try {
////            OutputStream out = response.getOutputStream();
//            response.getOutputStream().write(upload.getContent());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
