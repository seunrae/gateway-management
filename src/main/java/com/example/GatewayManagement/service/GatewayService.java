package com.example.GatewayManagement.service;

import com.example.GatewayManagement.model.Gateway;
import com.example.GatewayManagement.model.PeripheralDevice;

import java.util.List;
import java.util.Optional;

public interface GatewayService {
    Gateway createGateway(Gateway gateway);
    Optional<Gateway> getGatewayById(Long id);
    List<Gateway> getAllGateway();
    Gateway updateGateway(Long id, Gateway gateway);
    String deleteGateway(Long id);
    Gateway addDevice(Long id,PeripheralDevice peripheralDevice);
    String removeDevice(Long gatewayId, Long peripheralDeviceId);
}
