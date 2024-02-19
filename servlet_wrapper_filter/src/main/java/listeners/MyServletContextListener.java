package listeners;

import com.servlet_wrapper_filter.ConnectionManager;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // Initialisation du pool de connexions à la base de données
        ConnectionManager.initializeConnectionPool();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        // Fermeture du pool de connexions à la base de données
        ConnectionManager.closeConnectionPool();
    }
}

