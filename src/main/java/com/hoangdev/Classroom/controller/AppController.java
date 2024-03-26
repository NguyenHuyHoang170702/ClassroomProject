package com.hoangdev.Classroom.controller;

import com.hoangdev.Classroom.models.User;
import com.hoangdev.Classroom.service.email.EmailService;
import com.hoangdev.Classroom.service.user.UserService;
import com.hoangdev.Classroom.utils.Helper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/forgot_password")
    public String showForgotPasswordForm(Model model) {
        model.addAttribute("pageTitle", "Forgot Password");
        return "user/forgotPassword";
    }

    @PostMapping("/forgot_password")
    public String processForgotPasswordForm(HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        String token = Helper.generateRandomString(45);

        try {
            userService.updateResetPasswordToken(token, email);
            //generate reset password link
            String resetPasswordLink = Helper.getSiteURL(request) + "/reset_password?token=" + token;
            System.out.println(resetPasswordLink);

            //send email
            emailService.sendEmail(email, resetPasswordLink);

            //notify
            model.addAttribute("message", "We have sent a reset password link to your email. Please check.");


        } catch (Exception ex) {
            model.addAttribute("error", "Error while sending email.");
        }

        return "user/forgotPassword";
    }

    @GetMapping("/reset_password")
    public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
        User user = userService.getToken(token);
        if (user == null) {
            model.addAttribute("title","Reset your password");
            model.addAttribute("message","Invalid Token");
            return "message";
        }

        model.addAttribute("token", token);
        model.addAttribute("pageTitle", "Reset Your Password");
        return "user/resetPassword";
    }

    @PostMapping("/reset_password")
    public String processResetPassword(HttpServletRequest request, Model model) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");

        User user = userService.getToken(token);
        if (user == null) {
            model.addAttribute("title","Reset your password");
            model.addAttribute("message","Invalid Token");
            return "user/message";
        } else {
            userService.resetPassword(password, user);
            model.addAttribute("message", "You have successfully changed your password.");
        }
        return "user/message";
    }
}
