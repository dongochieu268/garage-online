/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author -HP-
 */
public class UserDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;

    public User GetById(int id) {
        User user = null;
        try {
            String strSQL = "SELECT id, name, phone, password, role_id, balance FROM Users WHERE id = ?";
            stm = connection.prepareStatement(strSQL);
            stm.setInt(1, id);
            rs = stm.executeQuery();

            if (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("password"),
                        rs.getInt("role_id"),
                        rs.getDouble("balance")
                );
            }
        } catch (Exception ex) {
            System.out.println("GetById: " + ex.getMessage());
        }
        return user;
    }

    public boolean insert(User user) {
        try {
            String strSQL = "INSERT INTO Users (name, phone, password, role_id, balance) VALUES (?, ?, ?, ?, ?)";

            stm = connection.prepareStatement(strSQL);
            stm.setString(1, user.getName());
            stm.setString(2, user.getPhone());
            stm.setString(3, user.getPassWord()); // đúng với class
            stm.setInt(4, user.getRoleId());
            stm.setDouble(5, user.getBalance());

            stm.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("insert: " + ex.getMessage());
        }
        return false;
    }

    public User checkLogin(String username, String password) {
        try {
            String strSQL = "SELECT id, name, phone, password, role_id, balance FROM Users WHERE name = ? AND password = ?";
            stm = connection.prepareStatement(strSQL);
            stm.setString(1, username);
            stm.setString(2, password);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("password"), // map vào passWord
                        rs.getInt("role_id"),
                        rs.getDouble("balance")
                );
            }
        } catch (Exception ex) {
            System.out.println("checkLogin: " + ex.getMessage());
        }
        return null;
    }

    public boolean updateBalance(int userId, double newBalance) {
        try {
            String strSQL = "UPDATE Users SET balance = ? WHERE id = ?";
            stm = connection.prepareStatement(strSQL);
            stm.setDouble(1, newBalance);
            stm.setInt(2, userId);

            int rows = stm.executeUpdate();
            return rows > 0;
        } catch (Exception ex) {
            System.out.println("updateBalance: " + ex.getMessage());
        }
        return false;
    }

    public boolean deductBalance(int userId, double amount) {
        String sql = "UPDATE users SET balance = balance - ? WHERE id = ? AND balance >= ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDouble(1, amount);
            ps.setInt(2, userId);
            ps.setDouble(3, amount);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addBalance(int userId, double amount) {
        String sql = "UPDATE users SET balance = balance + ? WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDouble(1, amount);
            ps.setInt(2, userId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
