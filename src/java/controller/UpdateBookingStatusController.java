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

          
            if (booking != null && "Done".equalsIgnoreCase(booking.getStatusName())) {
                request.setAttribute("booking", booking);
                request.setAttribute("statuses", sdao.getAll());
                request.setAttribute("error", "Booking already DONE, cannot update!");
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

    @Override
    public String getServletInfo() {
        return "Update booking status controller";
    }
}
