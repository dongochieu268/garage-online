/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Admin
 */
@WebServlet("/topup")
public class toUpController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet toUpController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet toUpController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // chưa login
        if (user == null) {
            response.sendRedirect("login");
            return;
        }

        String amountRaw = request.getParameter("amount");

        // check input
        if (amountRaw == null || amountRaw.isEmpty()) {
            session.setAttribute("msg", "Vui lòng nhập số tiền!");
            response.sendRedirect("history");
            return;
        }

        double amount;

        try {
            amount = Double.parseDouble(amountRaw);
        } catch (Exception e) {
            session.setAttribute("msg", "Số tiền không hợp lệ!");
            response.sendRedirect("history");
            return;
        }

        // check > 0
        if (amount <= 0) {
            session.setAttribute("msg", "Số tiền phải > 0!");
            response.sendRedirect("history");
            return;
        }

        UserDAO uDAO = new UserDAO();

        // cập nhật DB
        boolean success = uDAO.addBalance(user.getId(), amount);

        if (success) {
            // update session
            user.setBalance(user.getBalance() + amount);
            session.setAttribute("user", user);

            session.setAttribute("msg", "Nạp tiền thành công!");
        } else {
            session.setAttribute("msg", "Nạp tiền thất bại!");
        }

        response.sendRedirect("history");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
