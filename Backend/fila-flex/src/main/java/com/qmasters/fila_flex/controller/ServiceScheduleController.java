package com.qmasters.fila_flex.controller;

import com.qmasters.fila_flex.dto.ServiceScheduleDTO;
import com.qmasters.fila_flex.model.ServiceSchedule;
import com.qmasters.fila_flex.service.ServiceScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/service-schedule")
public class ServiceScheduleController {

    private final ServiceScheduleService serviceScheduleService;

    public ServiceScheduleController(ServiceScheduleService serviceScheduleService) {
        this.serviceScheduleService = serviceScheduleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ServiceSchedule>> getAllServiceSchedules() {
        return ResponseEntity.ok(serviceScheduleService.listAll());
    }

    @PostMapping("/create")
    public ResponseEntity<ServiceSchedule> createServiceSchedule(@RequestBody ServiceScheduleDTO serviceScheduleDTO) {
        var serviceSchedule = serviceScheduleService.saveServiceSchedule(serviceScheduleDTO);
        return ResponseEntity.ok(serviceSchedule);
    }

    @GetMapping("/find-id/{id}")
    public ResponseEntity<Optional<ServiceSchedule>> getServiceScheduleById(@PathVariable Long id) {
        var serviceSchedule = serviceScheduleService.findById(id);
        if (serviceSchedule.isEmpty()) {
            throw new NoSuchElementException("Cronograma do serviço não encontrado");
        }
        return ResponseEntity.ok(serviceSchedule);
    }

    @DeleteMapping("/delete-id/{id}")
    public ResponseEntity<String> deleteServiceScheduleById(@PathVariable Long id) {
        try {
            serviceScheduleService.deleteServiceSchedule(id);
            return ResponseEntity.ok("Cronograma do serviço removido com sucesso");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
