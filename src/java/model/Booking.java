/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.math.BigDecimal;
/**
 *
 * @author Admin
 */
public class Booking {
    private int id;
    private int userId;
    private int serviceId;
    private String vehicleType;
    private String problemDescription;
    private LocalDateTime bookingDate;
    private String status;
    private BigDecimal totalPrice;

    public Booking() {
    }

    public Booking(int id, int userId, int serviceId, String vehicleType, String problemDescription, LocalDateTime bookingDate, String status, BigDecimal totalPrice) {
        this.id = id;
        this.userId = userId;
        this.serviceId = serviceId;
        this.vehicleType = vehicleType;
        this.problemDescription = problemDescription;
        this.bookingDate = bookingDate;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Booking{" + "id=" + id + ", userId=" + userId + ", serviceId=" + serviceId + ", vehicleType=" + vehicleType + ", problemDescription=" + problemDescription + ", bookingDate=" + bookingDate + ", status=" + status + ", totalPrice=" + totalPrice + '}';
    }

  
}
