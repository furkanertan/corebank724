package com.application.corebank.controller.application;

import com.application.corebank.domain.User;
import com.application.corebank.helpers.HTML;
import com.application.corebank.helpers.Token;
import com.application.corebank.mailMessenger.EmailSenderService;
import com.application.corebank.service.UserService;
import com.application.corebank.util.CodeGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.validation.Valid;

@Slf4j
@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private EmailSenderService emailSenderService;

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute("registerUser") User user, BindingResult bindingResult, @RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("email") String email,
                                 @RequestParam("phone") String phone,
                                 @RequestParam("address") String address,
                                 @RequestParam("password") String password,
                                 @RequestParam("confirmPassword") String confirmPassword) throws MessagingException {
        ModelAndView modelAndView = new ModelAndView("register");

        if (bindingResult.hasErrors() || !password.equals(confirmPassword)) {
            modelAndView.addObject("errorUser", "The passwords do not match!");
            return modelAndView;
        }

        if (userService.findByEmail(email) != null) {
            modelAndView.addObject("errorUser", "The email already exists!");
            return modelAndView;
        }

        //Generate token
        String token = Token.generateToken();

        //Generate code
        int code = CodeGenerator.generateCode();

        //Get email body
        String emailBody = HTML.verificationEmailTemplate(token, code, firstName, lastName);

        //Hash password
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        //Save user
        userService.saveUser(firstName, lastName, email, phone, address, hashedPassword, token, code);

        //Send email
        emailSenderService.htmlEmailMessenger("corebank724@gmail.com", email, "CoreBank 7/24 Account Verification", emailBody);

        // Redirect to login page
        modelAndView.addObject("success", "Your account has been created successfully! Please check your email for verification.");
        return modelAndView;
    }

    @GetMapping("/verify")
    public ModelAndView verify(@RequestParam("token") String token, @RequestParam("code") int code) {
        ModelAndView verifyPage;

        User user = userService.findByToken(token);

        if (user == null) {
            log.info("User not found!");

            verifyPage = new ModelAndView("error");
            verifyPage.addObject("error", "Your account can't be verified!");

            return verifyPage;
        } else if (user.getCode() == null & user.getVerified() == 1) {
            log.info("User already verified!");

            verifyPage = new ModelAndView("error");
            verifyPage.addObject("error", "Your account has already been verified!");

            return verifyPage;
        }

        userService.verifyUser(token, code);

        verifyPage = new ModelAndView("login");
        verifyPage.addObject("success", "Your account successfully verified! Please login to continue.");
        return verifyPage;
    }

    @PostMapping("/forgotPassword")
    public ModelAndView forgotPassword(@RequestParam("email") String email) throws MessagingException {
        ModelAndView modelAndView = new ModelAndView("forgotPassword");
        User user = userService.findByEmail(email);

        if (user != null) {
            String emailBody = HTML.forgotPasswordEmail(user.getFirstName(), user.getLastName(), user.getId());

            emailSenderService.htmlEmailMessenger("corebank724@gmail.com", email, "CoreBank 7/24 Account Verification", emailBody);

            modelAndView.addObject("success", "A link for password reset has been sent to your email!");
        } else {
            modelAndView.addObject("error", "The email does not exist!");
        }
        return modelAndView;
    }

    @GetMapping("/resetpassword")
    public ModelAndView getResetPassword(@RequestParam("userId") String userId) {
        System.out.println("IndexController.getResetPassword()");

        if (userId == null || userId.isEmpty() || !userId.matches("[0-9]+")) {
            ModelAndView errorPage = new ModelAndView("error");
            errorPage.addObject("error", "Invalid user id!");
            return errorPage;
        }

        User user = userService.findById(Long.valueOf(userId));

        if (user == null) {
            ModelAndView errorPage = new ModelAndView("error");
            errorPage.addObject("error", "User cannot be found!");
            return errorPage;
        }

        ModelAndView modelAndView = new ModelAndView("setUpNewPassword");
        modelAndView.addObject("userId", userId);
        return modelAndView;
    }

    @PostMapping("/setUpNewPassword")
    public ModelAndView setupNewPassword(@RequestParam("_userId") String userId, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword) {
        ModelAndView modelAndView = new ModelAndView("setUpNewPassword");

        if (password == null || password.isEmpty() || confirmPassword == null || confirmPassword.isEmpty()) {
            modelAndView.addObject("error", "Password cannot be empty!");
            return modelAndView;
        }

        if (!password.equals(confirmPassword)) {
            modelAndView.addObject("error", "The passwords do not match!");
            return modelAndView;
        }

        User user = userService.findById(Long.valueOf(userId));

        log.info("user_id: " + userId);

        if (user == null) {
            modelAndView.addObject("error", "User cannot be found!");
            return modelAndView;
        }

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        userService.updatePassword(user.getId(), hashedPassword);

        modelAndView.addObject("success", "Your password has been reset successfully! Please login to continue.");
        return modelAndView;
    }
}
