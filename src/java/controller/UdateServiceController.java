package controller;

import dal.serviceDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Service;

@WebServlet(name = "updateServiceController", urlPatterns = {"/admin/updateService"})
public class UdateServiceController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("id");
        try {
            int id = Integer.parseInt(id_raw);
            serviceDAO dao = new serviceDAO();
            Service s = dao.getById(id);
            request.setAttribute("service", s);
            request.getRequestDispatcher("/views/admin/service/update.jsp").forward(request, response);
            return;
        } catch (Exception e) {
        }

        response.sendRedirect(request.getContextPath() + "/admin/service");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("id");
        String name = request.getParameter("name");
        String price_raw = request.getParameter("price");
        String description = request.getParameter("description");
        String img = request.getParameter("img");
        String categoryId_raw = request.getParameter("categoryId");

        try {
            int id = Integer.parseInt(id_raw);
            double price = Double.parseDouble(price_raw);
            int categoryId = Integer.parseInt(categoryId_raw);

            Service s = new Service();
            s.setId(id);
            s.setName(name);
            s.setPrice(price);
            s.setDescription(description);
            s.setImg(img);
            s.setCategoryId(categoryId);

            serviceDAO dao = new serviceDAO();
            dao.update(s);

        } catch (Exception e) {
        }

        response.sendRedirect(request.getContextPath() + "/admin/service");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}