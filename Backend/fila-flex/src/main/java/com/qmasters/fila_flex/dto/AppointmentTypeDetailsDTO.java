package com.qmasters.fila_flex.dto;

import java.time.LocalDate;
import java.util.List;

public class AppointmentTypeDetailsDTO {
    private String name;
    private String description;
    private List<String> category;
    private double price;
    private LocalDate appointmentDate;
    private List<String> requiredDocumentation;

    public AppointmentTypeDetailsDTO() {}

    public AppointmentTypeDetailsDTO(String name, String description, List<String> category, double price, LocalDate appointmentDate, List<String> requiredDocumentation) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.appointmentDate = appointmentDate;
        this.requiredDocumentation = requiredDocumentation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public List<String> getRequiredDocumentation() {
        return requiredDocumentation;
    }

    public void setRequiredDocumentation(List<String> requiredDocumentation) {
        this.requiredDocumentation = requiredDocumentation;
    }
    
}
