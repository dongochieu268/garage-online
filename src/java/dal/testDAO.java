/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import model.Booking;

/**
 *
 * @author Admin
 */
public class testDAO {

    public static void main(String[] args) {
        DBContext db = new DBContext();
        System.out.println(db.getConnection() != null ? "✅ DB OK" : "❌ DB FAIL");
        BookingDAO dao = new BookingDAO();
//        Booking b = new Booking();
//        b.setServiceId(3);            // phải tồn tại trong bảng Services
//        b.setVehicleType("Motorbike");
//        b.setProblemDescription("bao tri");
//        b.setBookingDate(LocalDateTime.now());
//        b.setStatus("Pending");
//        b.setTotalPrice(new BigDecimal("100000"));
//
//        dao.insert(b);
        List<Booking> list = dao.getByUserId(3);

        if (list.isEmpty()) {
            System.out.println("Không có booking nào!");
        } else {
            for (Booking b : list) {
                System.out.println("ID: " + b.getId());
                System.out.println("Vehicle: " + b.getVehicleType());
                System.out.println("Date: " + b.getBookingDate());
                System.out.println("Status: " + b.getStatus());
                System.out.println("--------------------");
            }
        }
    }
}
