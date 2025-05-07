package com.qmasters.fila_flex.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ServiceSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private List<String> days; //lista com os dias da semana cujo atendimento é realizado

    public ServiceSchedule() {
    }
    public ServiceSchedule(List<String> days) {
        this.days = days;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }
}
