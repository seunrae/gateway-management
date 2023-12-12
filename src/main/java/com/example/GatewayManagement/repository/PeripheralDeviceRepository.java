package com.example.GatewayManagement.repository;

import com.example.GatewayManagement.model.PeripheralDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeripheralDeviceRepository extends JpaRepository<PeripheralDevice, Long> {
}
