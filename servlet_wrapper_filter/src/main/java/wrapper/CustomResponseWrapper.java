package wrapper;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

public class CustomResponseWrapper extends HttpServletResponseWrapper {
    public CustomResponseWrapper(HttpServletResponse response) {
        super(response);
    }
    @Override
    public void addHeader(String name, String value) {
        // Ajouter un en-tête personnalisé à chaque réponse
        super.addHeader(name, value);
        if (name.equalsIgnoreCase("X-Custom-Header")) {
            // Logique personnalisée si nécessaire
            System.out.println("En-tête personnalisé ajouté : " + value);
        }
    }
}
