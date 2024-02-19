package wrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class CustomRequestWrapper extends HttpServletRequestWrapper {
    public CustomRequestWrapper(HttpServletRequest request) {
        super(request);
    }
    @Override
    public String getParameter(String name) {
        // Valider les paramètres de la requête avant de les renvoyer
        String value = super.getParameter(name);
        if (name.equalsIgnoreCase("username")) {
            // Logique de validation personnalisée
            if (value == null || value.isEmpty()) {
                throw new IllegalArgumentException("Le nom d'utilisateur ne peut pas être vide");
            }
        }
        return value;
    }
}
