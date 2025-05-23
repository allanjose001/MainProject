package com.qmasters.fila_flex.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointment_types")
public class AppointmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appointment_type_details_id")
    private AppointmentTypeDetails appointmentTypeDetails;
    
    //deve ser preenchida pela estimativa de tempo de atendimento gerado pelo formulario
    @Column
    private Integer estimatedTime; // Em minutos

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adress_id")   
    private Adress adress;

    @OneToMany(mappedBy = "appointmentType", cascade = CascadeType.ALL, orphanRemoval = true) //talvez remover orphanRemoval para não apagar os appointments
    private List<Appointment> appointments;

    @JsonManagedReference //talvez só usar o JsonIgnore na classe Evaluation
    @OneToMany(mappedBy = "appointmentType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evaluation> evaluations = new ArrayList<>();

    @OneToMany(mappedBy = "appointmentType", cascade = CascadeType.ALL, orphanRemoval = true)
    //@JsonManagedReference
    private List<ServiceSchedule> serviceSchedule;

    //Construtores

    public AppointmentType() {
        this.appointments = new ArrayList<>();
        this.serviceSchedule = new ArrayList<>();
    }
    
    public AppointmentType(AppointmentTypeDetails appointmentTypeDetails, Integer estimatedTime, Adress adress) {
        this.appointmentTypeDetails = appointmentTypeDetails;
        this.estimatedTime = estimatedTime;
        this.adress = adress;
        this.appointments = new ArrayList<>();
        this.serviceSchedule = new ArrayList<>();
    }
    
    //Getters e Setters

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public AppointmentTypeDetails getAppointmentTypeDetails() {
        return appointmentTypeDetails;
    }

    public void setAppointmentTypeDetails(AppointmentTypeDetails appointmentTypeDetails) {
        this.appointmentTypeDetails = appointmentTypeDetails;
    }

    public Integer getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Integer estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public Adress getAdress() {
        return adress;
    }
    
    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getAdressAsString() {// Retorna o endereço como uma String
        if (adress != null) {
            return adress.toString(); 
        }
        return null;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public void setName(String name) {
        appointmentTypeDetails.setName(name);
    }

    public String getName() {
        return appointmentTypeDetails.getName();
    }

    public void setDescription(String description) {
        appointmentTypeDetails.setDescription(description);
    }

    public String getDescription() {
        return appointmentTypeDetails.getDescription();
    }

    public void setCategory(List<String> category) {
        appointmentTypeDetails.setCategory(category);
    }

    public List<String> getCategory() {
        return appointmentTypeDetails.getCategory();
    }

    public void setPrice(double price) {
        appointmentTypeDetails.setPrice(price);
    }

    public double getPrice() {
        return appointmentTypeDetails.getPrice();
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        appointmentTypeDetails.setAppointmentDate(appointmentDate);
    }

    public LocalDate getAppointmentDate() {
        return appointmentTypeDetails.getAppointmentDate();
    }

    public void setRequiredDocumentation(List<String> requiredDocumentation) {
        appointmentTypeDetails.setRequiredDocumentation(requiredDocumentation);
    }

    public List<String> getRequiredDocumentation() {
        return appointmentTypeDetails.getRequiredDocumentation();
    }

    public List<ServiceSchedule> getServiceSchedule() {
        return serviceSchedule;
    }

    public void setServiceSchedule(List<ServiceSchedule> serviceSchedule) {
        this.serviceSchedule = serviceSchedule;
    }
}

