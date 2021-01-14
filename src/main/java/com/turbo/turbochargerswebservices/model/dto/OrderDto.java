package com.turbo.turbochargerswebservices.model.dto;

import com.turbo.turbochargerswebservices.model.entity.*;

import java.time.LocalDate;
import java.util.List;

public class OrderDto extends AbstractBaseEntity {

    private Long id;

    private LocalDate orderDate;

    private String notes;

    private boolean deleted;

    private String orderNumber;

    private Status status;

    private Turbocharger turbocharger;

    private List<Part> parts;

    private Reason reason;

    private UserDto seller;

    private UserDto technician;

    public OrderDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Turbocharger getTurbocharger() {
        return turbocharger;
    }

    public void setTurbocharger(Turbocharger turbocharger) {
        this.turbocharger = turbocharger;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }

    public UserDto getSeller() {
        return seller;
    }

    public void setSeller(UserDto seller) {
        this.seller = seller;
    }

    public UserDto getTechnician() {
        return technician;
    }

    public void setTechnician(UserDto technician) {
        this.technician = technician;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
