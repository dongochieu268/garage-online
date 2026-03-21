/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author -HP-
 */
public class User {
    public int id;
    public String name;
    public String phone;
    public String passWord;
    public int roleId;
    public double balance;
    
    public User() {
    }

    public User(int id, String name, String phone, String passWord, int roleId, double balance) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.passWord = passWord;
        this.roleId = roleId;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", phone=" + phone + ", passWord=" + passWord + ", roleId=" + roleId + ", balance=" + balance + '}';
    }

    
}
