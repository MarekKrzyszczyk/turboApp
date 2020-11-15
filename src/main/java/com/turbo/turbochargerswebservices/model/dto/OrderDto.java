package com.turbo.turbochargerswebservices.model.dto;

import java.util.List;

public class OrderDto {

    private Long id;

    private String orderDate;

    private String status;

    private String turbocharger;

    private List<String> parts;

    private String reason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTurbocharger() {
        return turbocharger;
    }

    public void setTurbocharger(String turbocharger) {
        this.turbocharger = turbocharger;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<String> getParts() {
        return parts;
    }

    public void setParts(List<String> parts) {
        this.parts = parts;
    }
}
