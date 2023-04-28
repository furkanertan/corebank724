package com.application.corebank.helpers;

public class HTML {

    public static String verificationEmailTemplate(String token, int code, String firstName, String lastName) {
        String url = "http://localhost:8080/verify?token=" + token + "&code=" + code;

        String emailTemplate = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\"/>\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n" +
                "    <link rel=\"stylesheet\" href=\"css/bootstrap/css/bootstrap.css\"/>\n" +
                "    <link rel=\"stylesheet\" href=\"css/fontawesome/css/all.css\"/>\n" +
                "    <title>Document</title>\n" +
                "    <style>\n" +
                "        * {\n" +
                "            box-sizing: border-box;\n" +
                "            font-family: Arial;\n" +
                "        }\n" +
                "\n" +
                "        /* Main body styling */\n" +
                "        body {\n" +
                "            height: 100vh;\n" +
                "            background-color: rgb(224, 221, 221);\n" +
                "            display: flex;\n" +
                "            align-items: center;\n" +
                "            justify-content: center;\n" +
                "        }\n" +
                "\n" +
                "        .wrapper {\n" +
                "            width: 550px;\n" +
                "            height: auto;\n" +
                "            padding: 15px;\n" +
                "            background-color: white;\n" +
                "            align-items: center;\n" +
                "            justify-content: center;\n" +
                "        }\n" +
                "\n" +
                "        .email-msg-header {\n" +
                "            text-align: center;\n" +
                "            font-size: 20px;\n" +
                "        }\n" +
                "\n" +
                "        .company-name {\n" +
                "            width: 100%;\n" +
                "            font-size: 30px;\n" +
                "            color: rgba(12, 84, 199, 0.387);\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "\n" +
                "        .welcome-text {\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "\n" +
                "        .copy-right {\n" +
                "            text-align: center;\n" +
                "            padding: 15px;\n" +
                "            font-size: 14px;\n" +
                "            margin: 0px 0px;\n" +
                "            display: flex;\n" +
                "            align-items: center;\n" +
                "            justify-content: center;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<!-- Wrapper -->\n" +
                "<div class=\"wrapper\">\n" +
                "    <!-- Email header-->\n" +
                "    <div class=\"email-msg-header\">\n" +
                "        Welcome and thank you for registering with\n" +
                "    </div>\n" +
                "    <!-- End of Email header-->\n" +
                "    <!-- Company name-->\n" +
                "    <div class=\"company-name\">Core Bank 7/24</div>\n" +
                "    <!-- End of Company name-->\n" +
                "    <!-- Email body-->\n" +
                "    <hr/>\n" +
                "    <div class=\"welcome-text\">\n" +
                "        <p>Dear <span class=\"user-name\">" + firstName + " " + lastName + "</span>,</p>\n" +
                "        <p>Your account has been successfully created.</p>\n" +
                "        <p>Please click the link below to activate your account.</p>\n" +
                "        <a href=\'" + url + "' class=\"btn btn-primary btn-lg\" role=\"button\"\n" +
                "        >Verify Account</a\n" +
                "        >\n" +
                "        <br/>\n" +
                "        <br/>\n" +
                "        <p>\n" +
                "            If you have any questions, please contact us at\n" +
                "            <a href=\"mailto:\" class=\"email-link\">corebank724@gmail.com</a>\n" +
                "        </p>\n" +
                "        <hr/>\n" +
                "        <div class=\"copy-right\">\n" +
                "            <p>© 2023 Core Bank 7/24. All rights reserved.</p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <!-- End of Email body-->\n" +
                "</div>\n" +
                "<!-- End of Wrapper-->\n" +
                "</body>\n" +
                "</html>\n";

        return emailTemplate;
    }

    public static String forgotPasswordEmail(String firstName, String lastName, Long userId) {
        String url = "http://localhost:8080/resetpassword?userId=" + userId;

        String emailTemplate = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\"/>\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n" +
                "    <link rel=\"stylesheet\" href=\"css/bootstrap/css/bootstrap.css\"/>\n" +
                "    <link rel=\"stylesheet\" href=\"css/fontawesome/css/all.css\"/>\n" +
                "    <title>Document</title>\n" +
                "    <style>\n" +
                "        * {\n" +
                "            box-sizing: border-box;\n" +
                "            font-family: Arial;\n" +
                "        }\n" +
                "\n" +
                "        /* Main body styling */\n" +
                "        body {\n" +
                "            height: 100vh;\n" +
                "            background-color: rgb(224, 221, 221);\n" +
                "            display: flex;\n" +
                "            align-items: center;\n" +
                "            justify-content: center;\n" +
                "        }\n" +
                "\n" +
                "        .wrapper {\n" +
                "            width: 550px;\n" +
                "            height: auto;\n" +
                "            padding: 15px;\n" +
                "            background-color: white;\n" +
                "            align-items: center;\n" +
                "            justify-content: center;\n" +
                "        }\n" +
                "\n" +
                "        .email-msg-header {\n" +
                "            text-align: center;\n" +
                "            font-size: 20px;\n" +
                "        }\n" +
                "\n" +
                "        .welcome-text {\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "\n" +
                "        .copy-right {\n" +
                "            text-align: center;\n" +
                "            padding: 15px;\n" +
                "            font-size: 14px;\n" +
                "            margin: 0px 0px;\n" +
                "            display: flex;\n" +
                "            align-items: center;\n" +
                "            justify-content: center;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<!-- Wrapper -->\n" +
                "<div class=\"wrapper\">\n" +
                "    <!-- Email header-->\n" +
                "    <div class=\"email-msg-header\">\n" +
                "        Reset your Core Bank 7/24 password\n" +
                "    </div>\n" +
                "    <!-- End of Email header-->\n" +
                "    <!-- Email body-->\n" +
                "    <hr/>\n" +
                "    <div class=\"welcome-text\">\n" +
                "        <p>Hi <span class=\"user-name\">" + firstName + " " + lastName + "</span>,</p>\n" +
                "        <p>We are sending you this email because you requested a password reset.</p>\n" +
                "        <p>Please click the link below to reset your password.</p>\n" +
                "        <a href=\'" + url + "' class=\"btn btn-primary btn-lg\" role=\"button\"\n" +
                "        >Set a new password</a\n" +
                "        >\n" +
                "        <br/>\n" +
                "        <br/>\n" +
                "        <p>\n" +
                "            If you didn't request a password reset, you can ignore this email.\n" +
                "            Your password will not be changed.\n" +
                "        </p>\n" +
                "        <p>\n" +
                "            If you have any questions, please contact us at\n" +
                "            <a href=\"mailto:\" class=\"email-link\">corebank724@gmail.com</a>\n" +
                "        </p>\n" +
                "        <hr/>\n" +
                "        <div class=\"copy-right\">\n" +
                "            <p>© 2023 Core Bank 7/24. All rights reserved.</p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <!-- End of Email body-->\n" +
                "</div>\n" +
                "<!-- End of Wrapper-->\n" +
                "</body>\n" +
                "</html>\n";

        return emailTemplate;
    }

    public static String contactUsEmail(String firstName, String lastName, String phoneNumber, String email, String message) {

        String emailTemplate = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\"/>\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n" +
                "    <link rel=\"stylesheet\" href=\"css/bootstrap/css/bootstrap.css\"/>\n" +
                "    <link rel=\"stylesheet\" href=\"css/fontawesome/css/all.css\"/>\n" +
                "    <title>Document</title>\n" +
                "    <style>\n" +
                "        * {\n" +
                "            box-sizing: border-box;\n" +
                "            font-family: Arial; \n" +
                "        }\n" +
                "\n" +
                "        /* Main body styling */\n" +
                "        body {\n" +
                "            height: 100vh;\n" +
                "            background-color: rgb(224, 221, 221);\n" +
                "            display: flex;\n" +
                "            align-items: center;\n" +
                "            justify-content: center;\n" +
                "        }\n" +
                "\n" +
                "        .wrapper {\n" +
                "            width: 550px;\n" +
                "            height: auto;\n" +
                "            padding: 15px;\n" +
                "            background-color: white;\n" +
                "            align-items: center;\n" +
                "            justify-content: center;\n" +
                "        }\n" +
                "\n" +
                "        .email-msg-header {\n" +
                "            text-align: center;\n" +
                "            font-size: 20px;\n" +
                "        }\n" +
                "\n" +
                "        .welcome-text {\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "\n" +
                "        .copy-right {\n" +
                "            text-align: center;\n" +
                "            padding: 15px;\n" +
                "            font-size: 14px;\n" +
                "            margin: 0px 0px;\n" +
                "            display: flex;\n" +
                "            align-items: center;\n" +
                "            justify-content: center;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<!-- Wrapper -->\n" +
                "<div class=\"wrapper\">\n" +
                "    <!-- Email header-->\n" +
                "    <div class=\"email-msg-header\">\n" +
                "        Contact Us\n" +
                "    </div>\n" +
                "    <!-- End of Email header-->\n" +
                "    <!-- Email body-->\n" +
                "    <hr/>\n" +
                "    <div class=\"welcome-text\">\n" +
                "        <p>Name & Surname: <span class=\"user-name\">" + firstName + " " + lastName + "</span>,</p>\n" +
                "        <p>Email: <span class=\"email\">" + email + "</span>,</p>\n" +
                "        <p>Phone Number: <span class=\"phoneNumber\">" + phoneNumber + "</span>,</p>\n" +
                "        <p>Message: <span class=\"message\">" + message + "</span>,</p>\n" +
                "        <div class=\"copy-right\">\n" +
                "            <p>© 2023 Core Bank 7/24. All rights reserved.</p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <!-- End of Email body-->\n" +
                "</div>\n" +
                "<!-- End of Wrapper-->\n" +
                "</body>\n" +
                "</html>\n";

        return emailTemplate;

    }
}
