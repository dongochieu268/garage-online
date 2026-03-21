/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Vehicle;

public class VehicleDAO extends DBContext {

    // lấy tất cả vehicle
    public List<Vehicle> getAll() {

        List<Vehicle> list = new ArrayList<>();

        String sql = "SELECT * FROM vehicles";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Vehicle v = new Vehicle(
                        rs.getInt("id"),
                        rs.getString("name")
                );

                list.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // lấy vehicle theo id
    public Vehicle getById(int id) {

        String sql = "SELECT * FROM vehicles WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Vehicle(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}