/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.User;

/**
 *
 * @author -HP-
 */
public class TestUserDAO extends DBContext{
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();

        // ===== 1. TEST INSERT =====
        User newUser = new User(0, "testUser", "0123456789", "123", 2, 1000);
        boolean insertResult = dao.insert(newUser);
        System.out.println("Insert: " + insertResult);

        // ===== 2. TEST LOGIN =====
        User loginUser = dao.checkLogin("testUser", "123");
        System.out.println("Login: " + loginUser);

        // ===== 3. TEST GET BY ID =====
        if (loginUser != null) {
            User u = dao.GetById(loginUser.getId());
            System.out.println("GetById: " + u);

            // ===== 4. TEST UPDATE BALANCE =====
            boolean update = dao.updateBalance(u.getId(), 5000);
            System.out.println("Update Balance: " + update);

            // Check lại
            User updatedUser = dao.GetById(u.getId());
            System.out.println("After Update: " + updatedUser);
        }
    }
}
