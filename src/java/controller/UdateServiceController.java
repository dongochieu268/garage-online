package controller;

import dal.CategoryDAO;
import dal.serviceDAO;
import java.io.File;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Service;

@MultipartConfig
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

            CategoryDAO cdao = new CategoryDAO();
            request.setAttribute("categories", cdao.getAll());

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
        String oldImg = request.getParameter("oldImg");
        String categoryId_raw = request.getParameter("categoryId");

        try {
            int id = Integer.parseInt(id_raw);
            double price = Double.parseDouble(price_raw);
            int categoryId = Integer.parseInt(categoryId_raw);

            String img = oldImg;

            Part filePart = request.getPart("image");
            String fileName = filePart.getSubmittedFileName();

            if (fileName != null && !fileName.isEmpty()) {
                String uploadPath = getServletContext().getRealPath("/images/services");
                File dir = new File(uploadPath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                filePart.write(uploadPath + File.separator + fileName);
                img = "images/services/" + fileName;
            }

            Service s = new Service();
            s.setId(id);
            s.setName(name);
            s.setPrice(price);
            s.setDescription(description);
            s.setImg(img);
            s.setCategoryId(categoryId);

            serviceDAO dao = new serviceDAO();
            boolean check = dao.update(s);

            if (check) {
                response.sendRedirect(request.getContextPath() + "/admin/service");
                return;
            } else {
                CategoryDAO cdao = new CategoryDAO();
                request.setAttribute("categories", cdao.getAll());
                request.setAttribute("error", "Can not update");
                request.setAttribute("service", s);
                request.getRequestDispatcher("/views/admin/service/update.jsp").forward(request, response);
                return;
            }

        } catch (Exception e) {
            CategoryDAO cdao = new CategoryDAO();
            request.setAttribute("categories", cdao.getAll());
            request.setAttribute("error", "Can not update");
            request.getRequestDispatcher("/views/admin/service/update.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}