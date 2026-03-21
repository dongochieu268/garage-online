/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Status;

public class StatusDAO extends DBContext {

    // lấy tất cả status
    public List<Status> getAll() {

        List<Status> list = new ArrayList<>();

        String sql = "SELECT * FROM statuses";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Status s = new Status(
                        rs.getInt("id"),
                        rs.getString("name")
                );

                list.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // lấy status theo id
    public Status getById(int id) {

        String sql = "SELECT * FROM statuses WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Status(
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
