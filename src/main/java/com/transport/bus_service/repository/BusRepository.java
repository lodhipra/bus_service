package com.transport.bus_service.repository;

import com.transport.bus_service.entity.BusDetail;
import com.transport.bus_service.entity.LoginDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusRepository extends JpaRepository<BusDetail, Long> {

    Optional<BusDetail> findByBusNumber(String number);
}
