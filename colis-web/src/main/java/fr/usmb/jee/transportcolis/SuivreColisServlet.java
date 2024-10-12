package fr.usmb.jee.transportcolis;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/suivreColis/{id}")
public class SuivreColisServlet extends HttpServlet {
    @EJB
    private Operation ejb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        Colis colis = ejb.getColis(id);

        req.setAttribute("colis", colis);
        req.getRequestDispatcher("/SuivreColisServlet.jsp").forward(req, resp);
    }
}
