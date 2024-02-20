package com.servlet_wrapper_filter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/DisconnectServlet")
public class DisconnectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("disconnection ... ... ...");
        HttpSession session = request.getSession(false); // Don't create new session if none exists
        if (session != null) {
            System.out.println("SESSION IS VALID");
            session.invalidate();
        }
        // Redirect to the login page or servlet
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        System.out.println("LOGED OUT SUCCESSFULLY");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

