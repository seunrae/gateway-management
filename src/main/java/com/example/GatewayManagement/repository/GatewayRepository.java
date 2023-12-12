package com.example.GatewayManagement.repository;

import com.example.GatewayManagement.model.Gateway;
import com.example.GatewayManagement.model.PeripheralDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GatewayRepository extends JpaRepository<Gateway, Long> {
}
