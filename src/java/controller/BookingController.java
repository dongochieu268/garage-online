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
import java.sql.Timestamp;

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
        String price = request.getParameter("price");

        // Nếu chưa login
        if (u == null) {
            session.setAttribute("redirect", "book?serviceId=" + serviceId + "&price=" + price);
            response.sendRedirect("Login");
            return;
        }

        if (serviceId == null || serviceId.isEmpty()) {
            response.sendRedirect("services"); // quay về danh sách service
            return;
        }

        // Lấy danh sách xe của user
        VehicleDAO vdao = new VehicleDAO();
        request.setAttribute("vehicles", vdao.getAll());

        // Truyền serviceId + price sang JSP
        request.setAttribute("serviceId", serviceId);
        request.setAttribute("price", price != null ? price : "0");

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

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");

        if (u == null) {
            response.sendRedirect("Login");
            return;
        }

        // Lấy dữ liệu từ form
        String serviceId_raw = request.getParameter("serviceId");
        String vehicleId_raw = request.getParameter("vehicleId");
        String des = request.getParameter("problemDescription");
        String price_raw = request.getParameter("price");

        int serviceId = 0;
        int vehicleId = 0;
        double price = 0;

        try {
            if (serviceId_raw != null && !serviceId_raw.isEmpty()) {
                serviceId = Integer.parseInt(serviceId_raw);
            }
            if (vehicleId_raw != null && !vehicleId_raw.isEmpty()) {
                vehicleId = Integer.parseInt(vehicleId_raw);
            } else {
                throw new Exception("Vehicle chưa chọn!");
            }
            if (price_raw != null && !price_raw.isEmpty()) {
                price = Double.parseDouble(price_raw);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("services");
            return;
        }

        // Tạo Booking object
        Booking b = new Booking();
        b.setUserId(u.getId());
        b.setServiceId(serviceId);
        b.setVehicleId(vehicleId);
        b.setProblemDescription(des);
        b.setStatusId(1); // Pending
        b.setBookingDate(new Timestamp(System.currentTimeMillis()));
        b.setTotalPrice(price);

        // Insert DB
        BookingDAO dao = new BookingDAO();
        dao.insert(b);

        // Redirect sang trang history
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
