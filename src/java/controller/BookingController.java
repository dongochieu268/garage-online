/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BookingDAO;
import dal.VehicleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Booking;
import model.User;
import model.Vehicle;

/**
 *
 * @author -HP-
 */
@WebServlet(name = "BookingController", urlPatterns = {"/book"})
public class BookingController extends HttpServlet {

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
            out.println("<title>Servlet BookingController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookingController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        String serviceId = request.getParameter("serviceId");
        if (u == null) {
            session.setAttribute("redirect", "book?serviceId=" + serviceId);
            response.sendRedirect("Login");
            return;
        }
        String price = request.getParameter("price");
        VehicleDAO vdao = new VehicleDAO();
        request.setAttribute("vehicles", vdao.getAll());
        request.setAttribute("serviceId", serviceId);
        request.setAttribute("price", price);
        request.getRequestDispatcher("/views/user/book/book.jsp").forward(request, response);
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

        String serviceId_raw = request.getParameter("serviceId");
        String vehicleId_raw = request.getParameter("vehicleId");
        String des = request.getParameter("problemDescription");
        String price_raw = request.getParameter("price");

        int serviceId = Integer.parseInt(serviceId_raw);
        int vehicleId = Integer.parseInt(vehicleId_raw);

        User u = (User) request.getSession().getAttribute("user");

        if (u == null) {
            response.sendRedirect("Login");
            return;
        }

        double price = 0;

        if (price_raw != null && !price_raw.isEmpty()) {
            price = Double.parseDouble(price_raw);
        }

        Booking b = new Booking();

        b.setUserId(u.getId());
        b.setServiceId(serviceId);
        b.setVehicleId(vehicleId);
        b.setProblemDescription(des);
        b.setStatusId(1); // Pending
        b.setBookingDate(new java.sql.Timestamp(System.currentTimeMillis()));
        b.setTotalPrice(price);

        BookingDAO dao = new BookingDAO();
        dao.insert(b);

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
