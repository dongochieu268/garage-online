/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.sql.Timestamp;


/**
 *
 * @author ADMIN
 */
public class BookingInfo {

    private int id;
    private String userName;
    private String phone;
    private String serviceName;
    private String vehicleName;
    private String problemDescription;
    private Timestamp bookingDate;
    private String statusName;
    private double totalPrice;

    public BookingInfo() {
    }

    public BookingInfo(int id, String userName, String phone, String serviceName, String vehicleName, String problemDescription, Timestamp bookingDate, String statusName, double totalPrice) {
        this.id = id;
        this.userName = userName;
        this.phone = phone;
        this.serviceName = serviceName;
        this.vehicleName = vehicleName;
        this.problemDescription = problemDescription;
        this.bookingDate = bookingDate;
        this.statusName = statusName;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public Timestamp getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Timestamp bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "BookingInfo{" + "id=" + id + ", userName=" + userName + ", phone=" + phone + ", serviceName=" + serviceName + ", vehicleName=" + vehicleName + ", problemDescription=" + problemDescription + ", bookingDate=" + bookingDate + ", statusName=" + statusName + ", totalPrice=" + totalPrice + '}';
    }

    
}
