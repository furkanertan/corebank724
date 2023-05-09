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
import javax.servlet.http.HttpSession;
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

        //Generate token for verification (when it is not 1, it means that the user is not verified yet)
        String token = Token.generateToken();

        //Generate code for verification (When it is not null, it means that the user is not verified yet)
        int code = CodeGenerator.generateCode();

        //Get email message body for the registered user
        String emailBody = HTML.verificationEmailTemplate(token, code, firstName, lastName);

        //Hash password for privacy
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        //Register user to database
        userService.saveUser(firstName, lastName, email, phone, address, hashedPassword, token, code);

        //Send email to user to verify account
        emailSenderService.htmlEmailMessenger("corebank724@gmail.com", email, "CoreBank 7/24 Account Verification", emailBody);

        // Redirect to login page with success message
        modelAndView.addObject("success", "Your account has been created successfully! Please check your email for verification.");
        return modelAndView;
    }

    @GetMapping("/verify")
    public ModelAndView verify(@RequestParam("token") String token, @RequestParam("code") int code) {
        ModelAndView verifyPage;

        //Find user by token to verify account
        User user = userService.findByToken(token);

        //Validations for user
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

        //Verification of user is completed
        userService.verifyUser(token, code);

        //Return to login page with success message to login to system after verification
        verifyPage = new ModelAndView("login");
        verifyPage.addObject("success", "Your account successfully verified! Please login to continue.");
        return verifyPage;
    }

    @PostMapping("/forgotPassword")
    public ModelAndView forgotPassword(@RequestParam("email") String email) throws MessagingException {
        ModelAndView modelAndView = new ModelAndView("forgotPassword");

        //Find user by email
        User user = userService.findByEmail(email);

        //Validation for user
        //If user is not null, send email to user to reset password
        if (user != null) {
            //Prepare email message body for user
            String emailBody = HTML.forgotPasswordEmail(user.getFirstName(), user.getLastName(), user.getId());
            //Send email to user
            emailSenderService.htmlEmailMessenger("corebank724@gmail.com", email, "CoreBank 7/24 Account Verification", emailBody);
            //Return message to user to check email
            modelAndView.addObject("success", "A link for password reset has been sent to your email!");
        } else {
            //Return error message to user if email does not exist
            modelAndView.addObject("error", "The email does not exist!");
        }

        return modelAndView;
    }

    @GetMapping("/resetpassword")
    public ModelAndView getResetPassword(@RequestParam("userId") String userId) {
        System.out.println("IndexController.getResetPassword()");

        //Validation for user to reset password
        //If user id is null or empty or not numeric, return error page
        if (userId == null || userId.isEmpty() || !userId.matches("[0-9]+")) {
            //Return error page with invalid user id message
            ModelAndView errorPage = new ModelAndView("error");
            errorPage.addObject("error", "Invalid user id!");

            return errorPage;
        }

        //Find user by id
        User user = userService.findById(Long.valueOf(userId));

        //Validation for user
        //If user is not found, return error page
        if (user == null) {
            ModelAndView errorPage = new ModelAndView("error");
            errorPage.addObject("error", "User cannot be found!");
            return errorPage;
        }

        //If user is found, return to set up a new password page
        ModelAndView modelAndView = new ModelAndView("setUpNewPassword");
        modelAndView.addObject("userId", userId);
        return modelAndView;
    }

    @PostMapping("/setUpNewPassword")
    public ModelAndView setupNewPassword(@RequestParam("_userId") String userId, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword) {
        ModelAndView modelAndView = new ModelAndView("setUpNewPassword");

        //Validation for user to set up a new password
        //If password or confirm password is null or empty, return error message
        if (password == null || password.isEmpty() || confirmPassword == null || confirmPassword.isEmpty()) {
            modelAndView.addObject("error", "Password cannot be empty!");
            return modelAndView;
        }

        //If password and confirm password do not match, return error message
        if (!password.equals(confirmPassword)) {
            modelAndView.addObject("error", "The passwords do not match!");
            return modelAndView;
        }

        //After validations completed, find user by id
        User user = userService.findById(Long.valueOf(userId));

        //If user cannot be found, return error message
        if (user == null) {
            modelAndView.addObject("error", "User cannot be found!");
            return modelAndView;
        }

        //Hash password for privacy and then update user's password
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        userService.updatePassword(user.getId(), hashedPassword);

        //Return to login page with success message to login to system after password reset
        modelAndView.addObject("success", "Your password has been reset successfully! Please login to continue.");
        return modelAndView;
    }

    @PostMapping("/editProfile")
    public ModelAndView editProfile(@RequestParam("firstName") String firstName,
                                    @RequestParam("lastName") String lastName,
                                    @RequestParam("email") String email,
                                    @RequestParam("phone") String phone,
                                    @RequestParam("address") String address,
                                    HttpSession session
    ) {
        ModelAndView profilePage = new ModelAndView("profile");

        //Get user from session
        User user = (User) session.getAttribute("user");

        //Check if user is logged in
        if (user == null) {
            profilePage.addObject("errorProfile", "You are not logged in!");
            return profilePage;
        }

        //After checking if user is logged in, start validations for given inputs
        //Check if any of the fields are empty adn return error message
        if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty() || email == null || email.isEmpty() || phone == null || phone.isEmpty() || address == null || address.isEmpty()) {
            profilePage.addObject("errorProfile", "Please fill all the fields!");
            return profilePage;
        }

        //First name validation
        if (!firstName.matches("[a-zA-Z]+")) {
            profilePage.addObject("errorProfile", "First name can only contain letters!");
            return profilePage;
        }
        if (firstName.length() < 3 || firstName.length() > 20) {
            profilePage.addObject("errorProfile", "First name must be between 3 and 20 characters!");
            return profilePage;
        }

        //Last name validation
        if (!lastName.matches("[a-zA-Z]+")) {
            profilePage.addObject("errorProfile", "Last name can only contain letters!");
            return profilePage;
        }
        if (lastName.length() < 3 || lastName.length() > 20) {
            profilePage.addObject("errorProfile", "Last name must be between 3 and 20 characters!");
            return profilePage;
        }

        //Phone validation
        if (!phone.matches("[0-9]+")) {
            profilePage.addObject("errorProfile", "Phone number can only contain numbers!");
            return profilePage;
        }
        if (phone.length() != 10) {
            profilePage.addObject("errorProfile", "Phone number must be 10 characters!");
            return profilePage;
        }

        //Address validation
        if (address.length() < 5 || address.length() > 50) {
            profilePage.addObject("errorProfile", "Address must be between 5 and 50 characters!");
            return profilePage;
        }

        //Update user's profile with given inputs and return success message
        User userUpdated = userService.updateUser(firstName, lastName, email, phone, address, user.getId());
        session.setAttribute("user", userUpdated);
        profilePage.addObject("successProfile", "Your profile has been updated successfully!");
        
        return profilePage;
    }
}
