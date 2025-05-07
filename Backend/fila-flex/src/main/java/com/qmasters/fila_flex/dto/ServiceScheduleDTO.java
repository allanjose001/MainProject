package com.qmasters.fila_flex.dto;

import java.util.List;

public class ServiceScheduleDTO {
    private List<String> days;

    public ServiceScheduleDTO() {
    }

    public ServiceScheduleDTO(List<String> days) {
        this.days = days;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }
}
