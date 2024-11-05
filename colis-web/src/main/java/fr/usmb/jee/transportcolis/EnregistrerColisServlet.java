package fr.usmb.jee.transportcolis;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/enregistrerColis")
public class EnregistrerColisServlet extends HttpServlet {
    @EJB
    private Operation ejb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("colis", req.getAttribute("colis"));
        req.getRequestDispatcher("/EnregistrerColis.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String identifiant = req.getParameter("identifiant");
        double poids = Double.parseDouble(req.getParameter("poids"));
        double valeur = Double.parseDouble(req.getParameter("valeur"));
        String origine = req.getParameter("origine");
        String destination = req.getParameter("destination");
        String latitude = req.getParameter("latitude");
        String longitude = req.getParameter("longitude");
        String emplacement = req.getParameter("emplacement");

        // Appel de la méthode EJB pour enregistrer le colis
        Colis colis = ejb.enregistrerColis(identifiant, poids, valeur, origine, destination, latitude, longitude, emplacement, "enregistrement");

        // Rediriger ou afficher un message de succès
        req.setAttribute("colis", colis);
        req.getRequestDispatcher("/EnregistrerColis.jsp").forward(req, resp);
    }
}
