package com.transport.bus_service.repository;

import com.transport.bus_service.entity.LoginDetail;
import com.transport.bus_service.entity.RegistrationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<LoginDetail, Long> {

    Optional<LoginDetail> findByUserNameORUser_Email (String username , String email);

}
