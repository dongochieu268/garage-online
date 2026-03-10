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
            String strSQL = "select * from Users where id = ?";
            stm = connection.prepareCall(strSQL);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt("Id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String password = rs.getString("password");
                String role = rs.getString("role");
                user = new User();
                user.setName(name);
                user.setPhone(phone);
                user.setPassWord(password);
                user.setRole(role);
            }
        } catch (Exception ex) {
            System.out.println("GetById:" + ex.getMessage());
        }
        return user;
    }

    public boolean insert(User user) {

        try {
            String strSQL = "INSERT INTO [dbo].[Users]\n"
                    + "           ([name]\n"
                    + "           ,[phone]\n"
                    + "           ,[password]\n"
                    + "           ,[role])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            stm = connection.prepareCall(strSQL);
            stm.setString(1, user.getName());
            stm.setString(2, user.getPhone());
            stm.setString(3, user.getPassWord());
            stm.setString(4, user.getRole());
            stm.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("insert:" + ex.getMessage());
        }
        return false;
    }   

    public boolean checkLogin(String phone, String password) {
        try {
            String strSQL = "select * from Users where phone = ? and passWord = ?";
            stm = connection.prepareCall(strSQL);
            stm.setString(1, phone);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception ex) {
            System.out.println("checkLogin:" + ex.getMessage());
        }
        return false;
    }
}
