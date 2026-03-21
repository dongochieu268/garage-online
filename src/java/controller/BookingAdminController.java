package controller;

import dal.BookingDAO;
import dal.serviceDAO;
import dal.StatusDAO;
import dal.VehicleDAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BookingInfo;

@WebServlet(name = "BookingAdminController", urlPatterns = {"/admin/booking"})
public class BookingAdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BookingDAO bdao = new BookingDAO();
        StatusDAO sdao = new StatusDAO();
        serviceDAO serviceDAO = new serviceDAO();
        VehicleDAO vehicleDAO = new VehicleDAO();

        String statusIdRaw = request.getParameter("statusId");
        String serviceIdRaw = request.getParameter("serviceId");
        String vehicleIdRaw = request.getParameter("vehicleId");

        Integer statusId = null;
        Integer serviceId = null;
        Integer vehicleId = null;

        try {
            if (statusIdRaw != null && !statusIdRaw.trim().isEmpty()) {
                statusId = Integer.parseInt(statusIdRaw);
            }
        } catch (Exception e) {
            statusId = null;
        }

        try {
            if (serviceIdRaw != null && !serviceIdRaw.trim().isEmpty()) {
                serviceId = Integer.parseInt(serviceIdRaw);
            }
        } catch (Exception e) {
            serviceId = null;
        }

        try {
            if (vehicleIdRaw != null && !vehicleIdRaw.trim().isEmpty()) {
                vehicleId = Integer.parseInt(vehicleIdRaw);
            }
        } catch (Exception e) {
            vehicleId = null;
        }

        List<BookingInfo> bookings = bdao.filterBookings(statusId, serviceId, vehicleId);

        request.setAttribute("bookings", bookings);
        request.setAttribute("statuses", sdao.getAll());
        request.setAttribute("services", serviceDAO.getAll());
        request.setAttribute("vehicles", vehicleDAO.getAll());

        request.setAttribute("selectedStatusId", statusId);
        request.setAttribute("selectedServiceId", serviceId);
        request.setAttribute("selectedVehicleId", vehicleId);

        request.getRequestDispatcher("/views/admin/booking/booking.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Booking admin controller";
    }
}