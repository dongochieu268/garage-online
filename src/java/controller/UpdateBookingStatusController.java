package controller;

import dal.BookingDAO;
import dal.StatusDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BookingInfo;

@WebServlet(name = "UpdateBookingStatusController", urlPatterns = {"/admin/updateBookingStatus"})
public class UpdateBookingStatusController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id_raw = request.getParameter("id");

        try {
            int id = Integer.parseInt(id_raw);

            BookingDAO bdao = new BookingDAO();
            StatusDAO sdao = new StatusDAO();

            BookingInfo booking = bdao.getBookingById(id);

            if (booking == null) {
                response.sendRedirect(request.getContextPath() + "/admin/booking");
                return;
            }

            request.setAttribute("booking", booking);
            request.setAttribute("statuses", sdao.getAll());
            request.getRequestDispatcher("/views/admin/booking/updateStatus.jsp").forward(request, response);

        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/admin/booking");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id_raw = request.getParameter("id");
        String statusId_raw = request.getParameter("statusId");

        BookingDAO bdao = new BookingDAO();
        StatusDAO sdao = new StatusDAO();

        try {
            int id = Integer.parseInt(id_raw);
            int statusId = Integer.parseInt(statusId_raw);

            BookingInfo booking = bdao.getBookingById(id);

            if (booking == null) {
                response.sendRedirect(request.getContextPath() + "/admin/booking");
                return;
            }

            int currentStatusOrder = getStatusOrder(booking.getStatusName());

            if (currentStatusOrder == 5) {
                request.setAttribute("booking", booking);
                request.setAttribute("statuses", sdao.getAll());
                request.setAttribute("error", "Booking is already Done, admin cannot update.");
                request.getRequestDispatcher("/views/admin/booking/updateStatus.jsp").forward(request, response);
                return;
            }

            if (statusId == 5) {
                request.setAttribute("booking", booking);
                request.setAttribute("statuses", sdao.getAll());
                request.setAttribute("error", "Admin cannot update status to Done. Done is updated automatically after customer payment.");
                request.getRequestDispatcher("/views/admin/booking/updateStatus.jsp").forward(request, response);
                return;
            }

            if (statusId != currentStatusOrder + 1) {
                request.setAttribute("booking", booking);
                request.setAttribute("statuses", sdao.getAll());
                request.setAttribute("error", "Status must follow: Pending -> Confirmed -> Repairing -> Completed");
                request.getRequestDispatcher("/views/admin/booking/updateStatus.jsp").forward(request, response);
                return;
            }

            boolean check = bdao.updateStatus(id, statusId);

            if (check) {
                response.sendRedirect(request.getContextPath() + "/admin/booking");
            } else {
                booking = bdao.getBookingById(id);
                request.setAttribute("booking", booking);
                request.setAttribute("statuses", sdao.getAll());
                request.setAttribute("error", "Can not update status");
                request.getRequestDispatcher("/views/admin/booking/updateStatus.jsp").forward(request, response);
            }

        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/admin/booking");
        }
    }

    private int getStatusOrder(String statusName) {
        if (statusName == null) {
            return 0;
        }

        switch (statusName.trim().toLowerCase()) {
            case "pending":
                return 1;
            case "confirmed":
                return 2;
            case "repairing":
                return 3;
            case "completed":
                return 4;
            case "done":
                return 5;
            default:
                return 0;
        }
    }

    @Override
    public String getServletInfo() {
        return "Update booking status controller";
    }
}