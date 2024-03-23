package com.transport.bus_service.repository;

import com.transport.bus_service.entity.BusDetail;
import com.transport.bus_service.entity.TicketDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<TicketDetail, Long> {

    List<TicketDetail> findByBus_BusNumberAndJourney(String number, LocalDateTime journey);



}
