/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

/**
 *
 * @author Admin
 */


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Role;

public class RoleDAO extends DBContext {

    // lấy tất cả role
    public List<Role> getAll() {

        List<Role> list = new ArrayList<>();

        String sql = "SELECT * FROM roles";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Role r = new Role(
                        rs.getInt("id"),
                        rs.getString("name")
                );

                list.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // lấy role theo id
    public Role getById(int id) {

        String sql = "SELECT * FROM roles WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Role(
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
