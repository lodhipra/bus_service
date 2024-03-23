package com.transport.bus_service.repository;

import com.transport.bus_service.entity.RegistrationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationDetail, Long> {

    Optional<RegistrationDetail> findByUserName(String userName);
}
