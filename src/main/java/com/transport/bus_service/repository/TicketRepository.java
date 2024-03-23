package com.transport.bus_service.repository;

import com.transport.bus_service.entity.BusDetail;
import com.transport.bus_service.entity.TicketDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketDetail, Long> {

}
