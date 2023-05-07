package com.application.corebank.controller.application;

import com.application.corebank.domain.User;
import com.application.corebank.helpers.Token;
import com.application.corebank.service.UserService;
import com.google.gson.Gson;
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

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@Controller
@AllArgsConstructor
public class AuthController {

    private UserService userService;

    @GetMapping("/login")
    public ModelAndView getLogin() {
        ModelAndView loginPage = new ModelAndView("login");
        System.out.println("AuthController.getLogin()");

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
        //TODO: Validate input fields
        String LOGIN_PAGE = "login";
        if (email.isEmpty() || password.isEmpty()) {
            log.info("token: " + token);
            model.addAttribute("error", "E-mail and password are required!");
            return LOGIN_PAGE;
        }

        //TODO: Check form email
        log.info("email: " + email);
        User user = userService.findByEmail(email);

        if (user == null) {
            model.addAttribute("error", "Incorrect E-mail or Password!");
            return LOGIN_PAGE;
        } else {
            if (!BCrypt.checkpw(password, user.getPassword())) {
                model.addAttribute("error", "Incorrect E-mail or Password!");
                return LOGIN_PAGE;
            }
            if (user.getVerified() != 1) {
                model.addAttribute("error", "Your account is not verified! Please check your e-mail for verification link.");
                return LOGIN_PAGE;
            }
        }

        session.setAttribute("user", user);
        session.setAttribute("token", token);
        session.setAttribute("authenticated", true);

        return "redirect:/app/dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        session.invalidate();
        redirectAttributes.addFlashAttribute("logged_out", "Logged out successfully");
        return "redirect:/login";
    }

    @WebServlet("/getUser")
    public class GetUserServlet extends HttpServlet {
        protected void getUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            Gson gson = new Gson();
            String userJson = gson.toJson(user);
            response.setContentType("application/json");
            response.getWriter().write(userJson);
        }
    }
}
