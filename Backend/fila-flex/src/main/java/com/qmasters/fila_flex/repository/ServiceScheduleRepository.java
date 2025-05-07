package com.qmasters.fila_flex.repository;

import com.qmasters.fila_flex.model.ServiceSchedule;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceScheduleRepository extends JpaRepository<ServiceSchedule, Long> {
}
