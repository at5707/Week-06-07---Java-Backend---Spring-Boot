package com.example.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class FirstServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h1>Hello, Servlet!</h1>");
    }
}