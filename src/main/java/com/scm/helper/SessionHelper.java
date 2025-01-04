package com.scm.helper;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

@Component
public class SessionHelper {

    public static void removeMessage() {
        System.out.println("Removing message from session");
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attributes != null) {
                HttpSession session = attributes.getRequest().getSession();
                session.removeAttribute("message");
            }
        } catch (Exception e) {
            System.out.println("Error in session helper: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
