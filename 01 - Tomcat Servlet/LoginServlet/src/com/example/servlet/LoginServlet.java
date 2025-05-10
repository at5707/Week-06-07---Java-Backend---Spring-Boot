package com.example.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.Logger;

public class LoginServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(LoginServlet.class.getName());

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");

        // Check if inputs are null or empty
        if (username == null || password == null || name == null || username.isEmpty() || password.isEmpty() || name.isEmpty()) {
            res.getWriter().println("<h3>All fields are required!</h3>");
            return;
        }

        if (!isValidName(name)) {
            res.getWriter().println("<h3>Invalid name. It must start with a capital and have at least 3 characters.</h3>");
            return;
        }

        if (!isValidPassword(password)) {
            res.getWriter().println("<h3>Invalid password. Requirements: 8+ chars, 1 upper, 1 digit, exactly 1 special char.</h3>");
            return;
        }

        if ("admin".equals(username) && "Admin@123".equals(password)) {
            logger.info("User 'admin' logged in successfully.");
            res.sendRedirect("LoginSuccess.jsp");
        } else {
            logger.warning("Invalid login attempt by user: " + username);
            res.getWriter().println("<h3>Invalid credentials</h3>");
        }
    }

    private boolean isValidName(String name) {
        return name != null && name.matches("^[A-Z][a-zA-Z]{2,}$");
    }

    private boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) return false;
        if (!password.matches(".*[A-Z].*")) return false;
        if (!password.matches(".*\\d.*")) return false;
        String specialChars = password.replaceAll("[a-zA-Z0-9]", "");
        return specialChars.length() == 1;
    }
}
