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
    private int vehicleId;
    private String problemDescription;
    private LocalDateTime bookingDate;
    private int statusId;
    private BigDecimal totalPrice;

    public Booking() {
    }

    public Booking(int id, int userId, int serviceId, int vehicleId, String problemDescription, LocalDateTime bookingDate, int statusId, BigDecimal totalPrice) {
        this.id = id;
        this.userId = userId;
        this.serviceId = serviceId;
        this.vehicleId = vehicleId;
        this.problemDescription = problemDescription;
        this.bookingDate = bookingDate;
        this.statusId = statusId;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
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

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Booking{" + "id=" + id + ", userId=" + userId + ", serviceId=" + serviceId + ", vehicleId=" + vehicleId + ", problemDescription=" + problemDescription + ", bookingDate=" + bookingDate + ", statusId=" + statusId + ", totalPrice=" + totalPrice + '}';
    }

   
}
