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
import model.Category;

public class CategoryDAO extends DBContext {

    // lấy tất cả category
    public List<Category> getAll() {

        List<Category> list = new ArrayList<>();

        String sql = "SELECT * FROM categories";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Category c = new Category(
                        rs.getInt("id"),
                        rs.getString("name")
                );

                list.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // lấy category theo id
    public Category getById(int id) {

        String sql = "SELECT * FROM categories WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Category(
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