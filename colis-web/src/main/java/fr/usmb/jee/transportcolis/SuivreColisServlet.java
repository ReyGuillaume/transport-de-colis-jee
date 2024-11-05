package fr.usmb.jee.transportcolis;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/suivreColis/*")
public class SuivreColisServlet extends HttpServlet {
    @EJB
    private Operation ejb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        String id = pathParts[1];

        Colis colis = ejb.getColis(id);

        req.setAttribute("colis", colis);
        req.getRequestDispatcher("/SuivreColis.jsp").forward(req, resp);
    }
}
