package com.application.corebank.controller.application;

import com.application.corebank.helpers.HTML;
import com.application.corebank.mailMessenger.EmailSenderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;

@Slf4j
@Controller
@AllArgsConstructor
public class IndexController {

    private EmailSenderService emailSenderService;

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

    @GetMapping("/forgotPassword")
    public ModelAndView getForgotPassword() {
        ModelAndView forgotPasswordPage = new ModelAndView("forgotPassword");
        forgotPasswordPage.addObject("PageTitle", "Forgot Password");
        log.info("IndexController.getForgotPassword()");

        return forgotPasswordPage;
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
    public ModelAndView postFAQ() {
        ModelAndView modelAndView = new ModelAndView("faq");
        modelAndView.addObject("PageTitle", "FAQ");
        log.info("IndexController.postFAQ()");

        return modelAndView;
    }

    @PostMapping("/contactus")
    public ModelAndView contactUsSendMail(@RequestParam("name") String name,
                                          @RequestParam("surname") String surname,
                                          @RequestParam("email") String email,
                                          @RequestParam("phoneNumber") String phoneNumber,
                                          @RequestParam("message") String message) throws MessagingException {
        ModelAndView modelAndView = new ModelAndView("contactus");
        modelAndView.addObject("PageTitle", "Contact Us");

        String emailBody = HTML.contactUsEmail(name, surname, phoneNumber, email, message);
        log.info("IndexController.contactUsSendMail()");

        //Send email to bank's email address with the message from the user
        emailSenderService.htmlEmailMessenger(email, "corebank724@gmail.com", "CoreBank 7/24 Contact Us", emailBody);

        // Redirect to login page
        modelAndView.addObject("success", "Your message has been sent successfully. We will contact you as soon as possible.");
        return modelAndView;
    }
}
