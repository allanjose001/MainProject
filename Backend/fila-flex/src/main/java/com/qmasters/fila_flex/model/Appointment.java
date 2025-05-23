package com.qmasters.fila_flex.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qmasters.fila_flex.model.enums.AppointmentStatus;
import com.qmasters.fila_flex.util.PriorityCondition;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "appointments")
public class Appointment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "appointment_type_id", nullable = false)
    @JsonIgnore
    private AppointmentType appointmentType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;
    
    @Column(nullable = false) //mudei para "scheduled" para não ter muita repetição de "appointment"
    private LocalDateTime scheduledDateTime; //dia que ocorrera o agendamento

    private LocalDateTime createdDateTime; //horario que foi criado o agendamento

    @NotNull(message = "É obrigatório informar a condição de prioridade")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING) //Usando para salvar o enum como string no banco de dados, e não como um número.
    private PriorityCondition priorityCondition;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;
  
    private LocalDateTime checkInTime; //horario que a pessoa chegou no local
  
    private LocalDateTime startTime; //horario que a pessoa foi atendida
  
    private LocalDateTime endTime; //horario que o atendimento foi finalizado

    //=================================variaveis Transients======================================
    //as variaveis transients não são obrigatorias nesta classe, mas baseado na ordem que elas estão
    //listadas aqui, elas serão exibidas desta mesma ordem no Insomnia

    @Column(nullable = false)
    private Integer queueOrder;

    //=================================Construtores======================================

    public Appointment() {
    }

    public Appointment(AppointmentType appointmentType, User user, LocalDateTime scheduledDateTime) {
        this.appointmentType = appointmentType;
        this.user = user;
        this.scheduledDateTime = scheduledDateTime;
        this.createdDateTime = LocalDateTime.now();//registra a hora atual
        this.queueOrder = 0; //Valor temporário, será atualizado pelo service.
        this.priorityCondition = PriorityCondition.NO_PRIORITY; //Valor padrão, para alterar usar o setter.
        this.status = AppointmentStatus.MARKED;
    }

    //================================Getters e Setters Transients================================
    //se remover estes getters, as variaveis transients não serão exibidas no Insomnia
    //por mais que nem estejam sendo chamados no DTO ou em outro lugar

    public String getAppointmentTypeDetailsName() {
        if (appointmentType != null && appointmentType.getAppointmentTypeDetails() != null) {
            return appointmentType.getAppointmentTypeDetails().getName();
        }
        return null;
    }

    public String getAppointmentTypeDescription() {
        if (appointmentType != null && appointmentType.getAppointmentTypeDetails() != null) {
            return appointmentType.getAppointmentTypeDetails().getDescription();
        }
        return null;
    }

    public List<String> getAppointmentTypeCategory() {
        if (appointmentType != null && appointmentType.getAppointmentTypeDetails() != null) {
            return appointmentType.getAppointmentTypeDetails().getCategory();
        }
        return new ArrayList<>(); 
    }

    public String getAppointmentTypePrice() {
        if (appointmentType != null && appointmentType.getAppointmentTypeDetails() != null) {
            return String.valueOf(appointmentType.getAppointmentTypeDetails().getPrice());
        }
        return null;
    }

    public String getAppointmentTypeAppointmentDate() {
        if (appointmentType != null && appointmentType.getAppointmentTypeDetails() != null) {
            return appointmentType.getAppointmentTypeDetails().getAppointmentDate().toString();
        }
        return null;
    }

    public List<String> getAppointmentTypeRequiredDocumentation() {
        if (appointmentType != null && appointmentType.getAppointmentTypeDetails() != null) {
            return appointmentType.getAppointmentTypeDetails().getRequiredDocumentation();
        }
        return new ArrayList<>();
    }

    public Adress getAppointmentTypeAdress() {
        if (appointmentType != null && appointmentType.getAdress() != null) {
            return appointmentType.getAdress();
        }
        return null;
    }

    public String getUserEmail() {
        if (user != null && user.getEmail() != null) {
            return user.getEmail();
        }
        return null;
    }

    public String getUserId() {
        if (user != null && user.getId() != null) {
            return user.getId().toString();
        }
        return null;
    }

    //==================================Getters e Setters===================================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppointmentType getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(AppointmentType appointmentType) {
        this.appointmentType = appointmentType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getScheduledDateTime() {
        return scheduledDateTime;
    }

    public void setScheduledDateTime(LocalDateTime scheduledDateTime) {
        this.scheduledDateTime = scheduledDateTime;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Integer getQueueOrder() {
        return queueOrder;
    }

    public void setQueueOrder(Integer queueOrder) {
        this.queueOrder = queueOrder;
    }

    public PriorityCondition getPriorityCondition() {
        return priorityCondition;
    }

    public void setPriorityCondition(PriorityCondition priorityCondition) {
        this.priorityCondition = priorityCondition;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;

    }
}
