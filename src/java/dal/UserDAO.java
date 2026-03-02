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
public class UserDAO extends DBContext{
    PreparedStatement stm;
    ResultSet rs;
    
    public User GetById (int id){
        User user = null;
        try{
            String strSQL = "select * from User where id = ?";
            stm = connection.prepareCall(strSQL);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt("Id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String password = rs.getString("password");
                String role = rs.getString("role");
                user = new User(Id, name, phone, password, role);
            }
        }catch(Exception ex){
            System.out.println("GetById:" + ex.getMessage());
        }
        return user;
    }
    
    
}
