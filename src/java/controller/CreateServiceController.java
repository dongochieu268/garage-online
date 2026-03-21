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
@WebServlet(name = "CreateServiceController", urlPatterns = {"/admin/createService"})
public class CreateServiceController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDAO cdao = new CategoryDAO();
        request.setAttribute("categories", cdao.getAll());
        request.getRequestDispatcher("/views/admin/service/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String price_raw = request.getParameter("price");
        String description = request.getParameter("description");
        String categoryId_raw = request.getParameter("categoryId");

        try {
            double price = Double.parseDouble(price_raw);
            int categoryId = Integer.parseInt(categoryId_raw);

            Part filePart = request.getPart("image");
            String fileName = filePart.getSubmittedFileName();
            String img = null;

            if (fileName != null && !fileName.isEmpty()) {
                String uploadPath = getServletContext().getRealPath("/images/services");
                System.out.println("uploadPath = " + uploadPath);
                File dir = new File(uploadPath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                filePart.write(uploadPath + File.separator + fileName);
                img = "images/services/" + fileName;
            }

            Service s = new Service();
            s.setName(name);
            s.setPrice(price);
            s.setDescription(description);
            s.setImg(img);
            s.setCategoryId(categoryId);

            serviceDAO dao = new serviceDAO();
            boolean check = dao.insert(s);

            if (check) {
                response.sendRedirect(request.getContextPath() + "/admin/service");
                return;
            } else {
                CategoryDAO cdao = new CategoryDAO();
                request.setAttribute("categories", cdao.getAll());
                request.setAttribute("error", "Can not create");
                request.getRequestDispatcher("/views/admin/service/create.jsp").forward(request, response);
                return;
            }

        } catch (Exception e) {
            CategoryDAO cdao = new CategoryDAO();
            request.setAttribute("categories", cdao.getAll());
            request.setAttribute("error", "Can not create 2");
            request.getRequestDispatcher("/views/admin/service/create.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}