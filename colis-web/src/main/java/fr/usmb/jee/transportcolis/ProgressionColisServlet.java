package fr.usmb.jee.transportcolis;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/progressionColis/{id}")
public class ProgressionColisServlet extends HttpServlet {
    @EJB
    private Operation ejb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        Colis colis = ejb.getColis(id);

        req.setAttribute("colis", colis);
        req.getRequestDispatcher("/ProgressionColisServlet.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String latitude = req.getParameter("latitude");
        String longitude = req.getParameter("longitude");
        String emplacement = req.getParameter("emplacement");
        String etat = req.getParameter("etat");

        ejb.updatePosition(id, latitude, longitude, emplacement, etat);

        req.setAttribute("success", true);
        this.doGet(req, resp);
    }
}
