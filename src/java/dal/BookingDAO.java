package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Booking;
import model.BookingInfo;

public class BookingDAO extends DBContext {

    // ================= USER ĐẶT LỊCH =================
    public void insert(Booking b) {

        String sql = "INSERT INTO bookings "
                + "(user_id, service_id, vehicle_id, problem_description, booking_date, status_id, total_price) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, b.getUserId());
            ps.setInt(2, b.getServiceId());
            ps.setInt(3, b.getVehicleId());
            ps.setString(4, b.getProblemDescription());
            ps.setTimestamp(5, b.getBookingDate());
            ps.setInt(6, b.getStatusId());
            ps.setDouble(7, b.getTotalPrice());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ================= USER XEM LỊCH SỬ =================
    public List<BookingInfo> getByUserId(int userId) {

        List<BookingInfo> list = new ArrayList<>();

        String sql = """
            SELECT 
                b.id,
                u.name as userName,
                u.phone,
                s.name as serviceName,
                v.name as vehicleName,
                b.problem_description,
                b.booking_date,
                st.name as statusName,
                b.total_price
            FROM bookings b
            JOIN users u ON b.user_id = u.id
            JOIN services s ON b.service_id = s.id
            JOIN vehicles v ON b.vehicle_id = v.id
            JOIN statuses st ON b.status_id = st.id
            WHERE b.user_id = ?
            ORDER BY b.booking_date DESC
        """;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                BookingInfo b = new BookingInfo(
                        rs.getInt("id"),
                        rs.getString("userName"),
                        rs.getString("phone"),
                        rs.getString("serviceName"),
                        rs.getString("vehicleName"),
                        rs.getString("problem_description"),
                        rs.getTimestamp("booking_date"),
                        rs.getString("statusName"),
                        rs.getDouble("total_price")
                );

                list.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // ================= ADMIN XEM TẤT CẢ =================
    public List<BookingInfo> getAll() {

        List<BookingInfo> list = new ArrayList<>();

        String sql = """
            SELECT 
                b.id,
                u.name as userName,
                u.phone,
                s.name as serviceName,
                v.name as vehicleName,
                b.problem_description,
                b.booking_date,
                st.name as statusName,
                b.total_price
            FROM bookings b
            JOIN users u ON b.user_id = u.id
            JOIN services s ON b.service_id = s.id
            JOIN vehicles v ON b.vehicle_id = v.id
            JOIN statuses st ON b.status_id = st.id
            ORDER BY b.booking_date DESC
        """;

        try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                BookingInfo b = new BookingInfo(
                        rs.getInt("id"),
                        rs.getString("userName"),
                        rs.getString("phone"),
                        rs.getString("serviceName"),
                        rs.getString("vehicleName"),
                        rs.getString("problem_description"),
                        rs.getTimestamp("booking_date"),
                        rs.getString("statusName"),
                        rs.getDouble("total_price")
                );

                list.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // ================= UPDATE STATUS =================
    public void updateStatus(int bookingId, int statusId) {

        String sql = "UPDATE bookings SET status_id = ? WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, statusId);
            ps.setInt(2, bookingId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ================= GET BOOKING BY ID =================
    public BookingInfo getBookingById(int id) {

        String sql = """
            SELECT 
                b.id,
                u.name as userName,
                u.phone,
                s.name as serviceName,
                v.name as vehicleName,
                b.problem_description,
                b.booking_date,
                st.name as statusName,
                b.total_price
            FROM bookings b
            JOIN users u ON b.user_id = u.id
            JOIN services s ON b.service_id = s.id
            JOIN vehicles v ON b.vehicle_id = v.id
            JOIN statuses st ON b.status_id = st.id
            WHERE b.id = ?
        """;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new BookingInfo(
                        rs.getInt("id"),
                        rs.getString("userName"),
                        rs.getString("phone"),
                        rs.getString("serviceName"),
                        rs.getString("vehicleName"),
                        rs.getString("problem_description"),
                        rs.getTimestamp("booking_date"),
                        rs.getString("statusName"),
                        rs.getDouble("total_price")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // ================= FILTER STATUS + PAGINATION =================
    public List<BookingInfo> filterBookings(Integer statusId, int page, int pageSize) {

        List<BookingInfo> list = new ArrayList<>();

        String sql = """
            SELECT 
                b.id,
                u.name as userName,
                u.phone,
                s.name as serviceName,
                v.name as vehicleName,
                b.problem_description,
                b.booking_date,
                st.name as statusName,
                b.total_price
            FROM bookings b
            JOIN users u ON b.user_id = u.id
            JOIN services s ON b.service_id = s.id
            JOIN vehicles v ON b.vehicle_id = v.id
            JOIN statuses st ON b.status_id = st.id
            WHERE (? IS NULL OR b.status_id = ?)
            ORDER BY b.booking_date DESC
            OFFSET ? ROWS FETCH NEXT ? ROWS ONLY
        """;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setObject(1, statusId);
            ps.setObject(2, statusId);
            ps.setInt(3, (page - 1) * pageSize);
            ps.setInt(4, pageSize);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                BookingInfo b = new BookingInfo(
                        rs.getInt("id"),
                        rs.getString("userName"),
                        rs.getString("phone"),
                        rs.getString("serviceName"),
                        rs.getString("vehicleName"),
                        rs.getString("problem_description"),
                        rs.getTimestamp("booking_date"),
                        rs.getString("statusName"),
                        rs.getDouble("total_price")
                );

                list.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // ================= COUNT BOOKING =================
    public int countBookings(Integer statusId) {

        String sql = """
            SELECT COUNT(*)
            FROM bookings
            WHERE (? IS NULL OR status_id = ?)
        """;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setObject(1, statusId);
            ps.setObject(2, statusId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
    // them doan nay

    public double getTotalRevenue() {
        String sql = "SELECT COALESCE(SUM(total_price),0) FROM Bookings";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getTotalBookings() {
        String sql = "SELECT COUNT(*) FROM Bookings";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public String getTopService() {
        String sql = """
        SELECT TOP 1 s.name
        FROM Bookings b
        JOIN Service s ON b.service_id = s.id
        GROUP BY s.name
        ORDER BY COUNT(*) DESC
    """;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return "N/A";
    }

    public List<BookingInfo> getRecentBookings() {
        List<BookingInfo> list = new ArrayList<>();

        String sql = """
        SELECT TOP 5 
            b.id, u.name, u.phone, s.name, v.name,
            b.problem_description, b.booking_date, st.name, b.total_price
        FROM bookings b
        JOIN users u ON b.user_id = u.id
        JOIN services s ON b.service_id = s.id
        JOIN vehicles v ON b.vehicle_id = v.id
        JOIN statuses st ON b.status_id = st.id
        ORDER BY b.booking_date DESC
    """;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new BookingInfo(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getTimestamp(7),
                        rs.getString(8),
                        rs.getDouble(9)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
