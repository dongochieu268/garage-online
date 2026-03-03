/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Service;

/**
 *
 * @author ADMIN
 */
public class serviceDAO extends DBContext{
    PreparedStatement stm;
    ResultSet rs;
    public List<Service> getAll(){
        List<Service> services = new ArrayList<>();
        try{
            stm = connection.prepareCall("select * from Services");
            rs = stm.executeQuery();
            while(rs.next()){
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                services.add(new Service(id, name, price, description));
            }
        }catch(SQLException e){
        
        }
        return services;
    }
    
    public Service getById(int id){
        Service service = null;
        try{
            stm = connection.prepareCall("select * from Services where id = ?");
            stm.setInt(1, id);
            rs = stm.executeQuery();
            
            while(rs.next()){
                int id1  = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                service = new Service(id, name, price, description);
            }
        }catch(SQLException e){
            
        }
        return service;
    }
    
    public boolean insert(Service s){
        try{
            stm = connection.prepareCall("insert into Services (name, price, description) values (?,?,?)");
            stm.setString(1, s.getName());
            stm.setDouble(2, s.getPrice());
            stm.setString(3, s.getDescription());
            stm.executeUpdate();
            
        }catch(SQLException e){
            return false;
        }
        return true;
    }
   
}
