package com.transport.bus_service.repository;

import com.transport.bus_service.entity.BusDetail;
import com.transport.bus_service.entity.LoginDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<BusDetail, Long> {

}
