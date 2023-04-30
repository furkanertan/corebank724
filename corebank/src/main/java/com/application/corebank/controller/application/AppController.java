package com.application.corebank.controller.application;

import com.application.corebank.domain.User;
import com.application.corebank.dto.AccountDto;
import com.application.corebank.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/app")
public class AppController {

    private AccountService accountService;

    @GetMapping("/dashboard")
    public ModelAndView getDashboard(HttpSession session) {
        ModelAndView dashboardPage = new ModelAndView("dashboard");
        dashboardPage.addObject("PageTitle", "Dashboard");

        //Logged user information is stored in session
        User user = (User) session.getAttribute("user");

        //Get User Account Numbers
        Integer numberOfUserAccounts = accountService.getNumberOfUserAccounts(user.getId());

        //Set Objects to dashboardPage
        dashboardPage.addObject("accountsCount", numberOfUserAccounts);

        return dashboardPage;
    }

    @GetMapping("/accounts")
    public ModelAndView getAccountsPage(HttpSession session) {
        ModelAndView accountsPage = new ModelAndView("accounts");
        accountsPage.addObject("PageTitle", "Accounts");

        //Logged user information is stored in session
        User user = (User) session.getAttribute("user");

        //Get user accounts by user id
        List<AccountDto> userAccounts = accountService.getAllActiveAccountsByCustomerNo(user.getId());
        log.info("AppController.getDashboard() - userAccounts: {}", userAccounts);

        accountsPage.addObject("userAccounts", userAccounts);
        return accountsPage;
    }
}
