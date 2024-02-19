package com.servlet_wrapper_filter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = ConnectionManager.getConnection();
        System.out.println(connection);
        try {
            String sql = "SELECT * FROM accounts WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Utilisateur authentifié, rediriger vers une page d'accueil
                System.out.println("authentification done");
                HttpSession session = request.getSession(true);
                session.setAttribute("username", username);
                response.sendRedirect("helloworld.jsp");
            } else {
                // Afficher un message d'erreur si les identifiants sont invalides
                request.setAttribute("errorMessage", "Nom d'utilisateur ou mot de passe incorrect.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}