package com.application.corebank.controller.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class IndexController {

    @GetMapping("/")
    public ModelAndView getIndex() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("PageTitle", "Home");
        log.info("IndexController.getIndex()");

        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView getRegister() {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("PageTitle", "Register");
        log.info("IndexController.getRegister()");

        return modelAndView;
    }

    @GetMapping("/currencyexchange")
    public ModelAndView getCurrencyExchange() {
        ModelAndView modelAndView = new ModelAndView("currencyexchange");
        modelAndView.addObject("PageTitle", "Currency Exchange");
        log.info("IndexController.getCurrencyExchange()");

        return modelAndView;
    }

    @GetMapping("/moneytransfer")
    public ModelAndView getMoneyTransfer() {
        ModelAndView modelAndView = new ModelAndView("moneytransfer");
        modelAndView.addObject("PageTitle", "Money Transfer");
        log.info("IndexController.getMoneyTransfer()");

        return modelAndView;
    }

    @GetMapping("/error")
    public ModelAndView getError() {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("PageTitle", "Error");
        log.info("IndexController.getError()");

        return modelAndView;
    }

    @GetMapping("/contactus")
    public ModelAndView getContactUs() {
        ModelAndView modelAndView = new ModelAndView("contactus");
        modelAndView.addObject("PageTitle", "Contact Us");
        log.info("IndexController.getContactUs()");

        return modelAndView;
    }

    @GetMapping("/services")
    public ModelAndView getServices() {
        ModelAndView modelAndView = new ModelAndView("services");
        modelAndView.addObject("PageTitle", "Services");
        log.info("IndexController.getServices()");

        return modelAndView;
    }

    @GetMapping("/aboutus")
    public ModelAndView getAboutUs() {
        ModelAndView modelAndView = new ModelAndView("aboutus");
        modelAndView.addObject("PageTitle", "About Us");
        log.info("IndexController.getAboutUs()");

        return modelAndView;
    }

    @GetMapping("/faq")
    public ModelAndView getFAQ() {
        ModelAndView modelAndView = new ModelAndView("faq");
        modelAndView.addObject("PageTitle", "FAQ");
        log.info("IndexController.getFAQ()");

        return modelAndView;
    }

    @GetMapping("/forgotPassword")
    public ModelAndView getForgotPassword() {
        ModelAndView forgotPasswordPage = new ModelAndView("forgotPassword");
        forgotPasswordPage.addObject("PageTitle", "Forgot Password");
        log.info("IndexController.getForgotPassword()");

        return forgotPasswordPage;
    }
}
