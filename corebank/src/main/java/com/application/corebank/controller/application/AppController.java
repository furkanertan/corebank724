package com.application.corebank.controller.application;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@AllArgsConstructor
public class AppController {

    @GetMapping("/dashboard")
    public ModelAndView getDashboard() {
        ModelAndView modelAndView = new ModelAndView("dashboard");
        modelAndView.addObject("PageTitle", "Dashboard");
        System.out.println("IndexController.getDashboard()");

        return modelAndView;
    }
}
