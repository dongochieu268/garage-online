package controller;

import dal.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/auth/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        if (name == null || name.trim().isEmpty()
                || password == null || password.trim().isEmpty()
                || phone == null || phone.trim().isEmpty()
                || !phone.matches("^0[0-9]{9}$")) {

            request.setAttribute("error", "Enter again");
            request.getRequestDispatcher("/views/auth/register.jsp").forward(request, response);
            return;
        }

        UserDAO dao = new UserDAO();
        User user = new User();
        user.setName(name.trim());
        user.setPhone(phone.trim());
        user.setPassWord(password.trim());
        user.setRoleId(2);
        user.setBalance(0);

        boolean isRegister = dao.insert(user);
        if (!isRegister) {
            request.setAttribute("error", "Can not register! Duplicate phonenumber!");
            request.getRequestDispatcher("/views/auth/register.jsp").forward(request, response);
            return;
        }

        response.sendRedirect("Login");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}