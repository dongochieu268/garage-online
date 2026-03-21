/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BookingDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.BookingInfo;
import model.User;

/**
 *
 * @author Admin
 */
@WebServlet("/pay")
public class paymentController extends HttpServlet {

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
            out.println("<title>Servlet paymentController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet paymentController at " + request.getContextPath() + "</h1>");
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

        if (user == null) {
            response.sendRedirect("login");
            return;
        }

        String idRaw = request.getParameter("id");
        if (idRaw == null) {
            response.sendRedirect("history");
            return;
        }

        int bookingId = Integer.parseInt(idRaw);

        BookingDAO bDAO = new BookingDAO();
        UserDAO uDAO = new UserDAO();

        BookingInfo b = bDAO.getBookingById(bookingId);

        if (b == null) {
            session.setAttribute("msg", "Booking không tồn tại!");
            response.sendRedirect("history");
            return;
        }

        // chỉ thanh toán khi Completed
        if (!b.getStatusName().equalsIgnoreCase("Completed")) {
            session.setAttribute("msg", "Chỉ thanh toán khi Completed!");
            response.sendRedirect("history");
            return;
        }

        // kiểm tra tiền
        if (user.getBalance() < b.getTotalPrice()) {
            session.setAttribute("msg", "Không đủ tiền!");
            response.sendRedirect("history");
            return;
        }

        // trừ tiền
        boolean ok = uDAO.updateBalance(user.getId(), user.getBalance() - b.getTotalPrice());

        if (ok) {
            bDAO.markAsPaid(bookingId); // DONE = 5

            user.setBalance(user.getBalance() - b.getTotalPrice());
            session.setAttribute("user", user);

            session.setAttribute("msg", "Thanh toán thành công!");
        } else {
            session.setAttribute("msg", "Thanh toán thất bại!");
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
