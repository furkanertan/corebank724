package com.application.corebank.controller.application;

import com.application.corebank.domain.User;
import com.application.corebank.helpers.Token;
import com.application.corebank.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@AllArgsConstructor
public class AuthController {

    private UserService userService;

    @GetMapping("/login")
    public ModelAndView getLogin() {
        ModelAndView loginPage = new ModelAndView("login");
        System.out.println("AuthController.getLogin()");

        //Generate token for login form
        String token = Token.generateToken();

        loginPage.addObject("token", token);
        loginPage.addObject("PageTitle", "Login");

        return loginPage;
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            @RequestParam("_token") String token,
                            Model model,
                            HttpSession session) {
        String LOGIN_PAGE = "login";

        //check if token is valid, email and password are not empty, otherwise return login page with error message
        if (email.isEmpty() || password.isEmpty()) {
            log.info("token: " + token);
            model.addAttribute("error", "E-mail and password are required!");
            return LOGIN_PAGE;
        }

        //find user by email
        User user = userService.findByEmail(email);

        //check if user exists, otherwise return login page with error message
        if (user == null) {
            model.addAttribute("error", "Incorrect E-mail or Password!");
            return LOGIN_PAGE;
        } else {
            //check if password is correct and user is verified, otherwise return login page with error message
            if (!BCrypt.checkpw(password, user.getPassword())) {
                model.addAttribute("error", "Incorrect E-mail or Password!");
                return LOGIN_PAGE;
            }
            if (user.getVerified() != 1) {
                model.addAttribute("error", "Your account is not verified! Please check your e-mail for verification link.");
                return LOGIN_PAGE;
            }
        }

        //Add user to session
        session.setAttribute("user", user);
        session.setAttribute("token", token);
        session.setAttribute("authenticated", true);

        return "redirect:/app/dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        //Invalidate sessions and redirect to login page
        session.invalidate();

        //show logged out message
        redirectAttributes.addFlashAttribute("logged_out", "Logged out successfully");
        return "redirect:/login";
    }
}
