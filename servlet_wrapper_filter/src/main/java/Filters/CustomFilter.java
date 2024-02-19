package Filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wrapper.CustomRequestWrapper;
import wrapper.CustomResponseWrapper;

import java.io.IOException;
@WebFilter("/*")
public class CustomFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Intercepter la requête et l'envelopper dans CustomRequestWrapper
        CustomRequestWrapper customRequestWrapper = new CustomRequestWrapper((HttpServletRequest) request);
        // Intercepter la réponse et l'envelopper dans CustomResponseWrapper
        CustomResponseWrapper customResponseWrapper = new CustomResponseWrapper((HttpServletResponse) response);

        chain.doFilter(customRequestWrapper, customResponseWrapper);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialisation du filtre (si nécessaire)
    }

    @Override
    public void destroy() {
        // Libération des ressources (si nécessaire)
    }
}
