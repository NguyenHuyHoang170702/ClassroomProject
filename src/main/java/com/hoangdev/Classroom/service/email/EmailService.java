package com.hoangdev.Classroom.service.email;

import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;

public interface EmailService {
    void sendEmail(String email, String resetPasswordLink) throws MessagingException, UnsupportedEncodingException;
}
