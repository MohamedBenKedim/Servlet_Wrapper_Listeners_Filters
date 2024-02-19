package Filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/helloworld.jsp") // Indiquez ici le chemin qui nécessite une authentification
public class AuthenticationFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Vérifiez si l'utilisateur est authentifié
        if (httpRequest.getSession().getAttribute("username") == null) {
            // Si l'utilisateur n'est pas authentifié, redirigez-le vers la page de connexion
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
        } else {
            // Si l'utilisateur est authentifié, laissez passer la requête
            chain.doFilter(request, response);
        }
    }

}
