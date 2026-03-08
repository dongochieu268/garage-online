/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.util.List;
import model.Booking;
import java.sql.*;

import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class BookingDAO extends DBContext{
    
    
 
    //user dat lich
    void insert (Booking b){
            String sql = "INSERT INTO bookings "
            + "( service_id, vehicle_type, problem_description, booking_date, status, total_price) "
            + "VALUES ( ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement ps = connection.prepareStatement(sql)) {

        
        ps.setInt(1,b.getServiceId());
        ps.setString(2, b.getVehicleType());
        ps.setString(3, b.getProblemDescription());
        ps.setTimestamp(4,Timestamp.valueOf(b.getBookingDate()));
        ps.setString(5, b.getStatus());
        ps.setBigDecimal(6, b.getTotalPrice());

        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    
    //user xem lich su theo user_id
    List<Booking> getByUserId(int UserId){
        List<Booking> list = new ArrayList<>();
        String sql =  "SELECT * FROM users WHERE id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

        ps.setInt(1, UserId);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Booking b = new Booking(
                    rs.getInt("id"),
                    rs.getInt("userId"),
                    rs.getInt("serviceId"),
                    rs.getString("vehicleType"),
                    rs.getString("problemDescription"),
                    rs.getTimestamp("bookingDate").toLocalDateTime(),
                    rs.getString("status"),
                    rs.getBigDecimal("totalPrice")
            );
            list.add(b);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;

    }
    
    // Admin xem all
    List<Booking> getAll(){
        
    List<Booking> list = new ArrayList<>();
    String sql = "SELECT * FROM bookings";

    try (PreparedStatement ps = connection.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Booking b = new Booking(
                    rs.getInt("id"),
                    rs.getInt("userId"),
                    rs.getInt("serviceId"),
                    rs.getString("vehicleType"),
                    rs.getString("problemDescription"),
                    rs.getTimestamp("bookingDate").toLocalDateTime(),
                    rs.getString("status"),
                    rs.getBigDecimal("totalPrice")
            );
            list.add(b);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
    }
    
    //update Status
    void updateStatus(int id , String status){
            String sql = "UPDATE bookings SET status = ? WHERE id = ?";

    try (PreparedStatement ps = connection.prepareStatement(sql)) {

        ps.setString(1, status);
        ps.setInt(2, id);
        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    
}


