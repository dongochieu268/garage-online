/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author ADMIN
 */
public class BookingInfo {
    private int id;
    private String userName;
    private String userPhone;
    private String serviceName;
    private String vehicleType;
    private String problemDescription;
    private LocalDateTime bookingDate;
    private String status;
    private BigDecimal totalPrice;

    public BookingInfo() {
    }

    public BookingInfo(int id, String userName, String userPhone, String serviceName, String vehicleType, String problemDescription, LocalDateTime bookingDate, String status, BigDecimal totalPrice) {
        this.id = id;
        this.userName = userName;
        this.userPhone = userPhone;
        this.serviceName = serviceName;
        this.vehicleType = vehicleType;
        this.problemDescription = problemDescription;
        this.bookingDate = bookingDate;
        this.status = status;
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

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "BookingInfo{" + "id=" + id + ", userName=" + userName + ", userPhone=" + userPhone + ", serviceName=" + serviceName + ", vehicleType=" + vehicleType + ", problemDescription=" + problemDescription + ", bookingDate=" + bookingDate + ", status=" + status + ", totalPrice=" + totalPrice + '}';
    }

    
    
    
}
