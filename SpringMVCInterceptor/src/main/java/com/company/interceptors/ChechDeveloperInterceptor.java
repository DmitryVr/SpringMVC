package com.company.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.model.Developer;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ChechDeveloperInterceptor extends HandlerInterceptorAdapter {

//    preHandle - обработка до того как запрос попадет в контроллер

//    postHandle - после контроллера, но до отбражения

//    afterCompletion - после отработки представления


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (request.getRequestURI().contains("sayHello")) {
            Developer developer = (Developer) modelAndView.getModel().get("developer");
            developer.setName(developer.getName() + " interceptor");
            modelAndView.addObject("developer", developer);
//            response.sendRedirect(request.getContextPath() + "/перейтисюда");
        }
    }
}