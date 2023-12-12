package com.example.GatewayManagement.service.impl;

import com.example.GatewayManagement.model.Gateway;
import com.example.GatewayManagement.model.PeripheralDevice;
import com.example.GatewayManagement.model.STATUS;
import com.example.GatewayManagement.repository.GatewayRepository;
import com.example.GatewayManagement.repository.PeripheralDeviceRepository;
import com.example.GatewayManagement.service.GatewayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GatewayServiceImpl implements GatewayService {
    private final GatewayRepository gatewayRepository;
    private final PeripheralDeviceRepository peripheralDeviceRepository;
    @Override
    public Gateway createGateway(Gateway gateway) {
        UUID uuid = UUID.randomUUID();
        gateway.setSerialNumber(uuid.toString());
        return gatewayRepository.save(gateway);
    }

    @Override
    public Optional<Gateway> getGatewayById(Long id) {
        return gatewayRepository.findById(id);
    }

    @Override
    public List<Gateway> getAllGateway() {
        return gatewayRepository.findAll();
    }

    @Override
    public Gateway updateGateway(Long id, Gateway gateway) {
        Gateway updateGateway = gatewayRepository.findById(id).get();
        updateGateway.setName(gateway.getName());
        updateGateway.setIpv4Address(gateway.getIpv4Address());
        updateGateway.setPeripheralDevices(new ArrayList<>());
        gatewayRepository.save(updateGateway);
        return updateGateway;
    }

    @Override
    public String deleteGateway(Long id) {
        Gateway gateway = gatewayRepository.findById(id).orElseThrow(() -> new IllegalStateException("id not found"));
        gatewayRepository.delete(gateway);
        return "gateway deleted";
    }

    @Override
    public Gateway addDevice(Long id,PeripheralDevice peripheralDevice) {
        Gateway gateway = gatewayRepository.findById(id).get();
        List<PeripheralDevice> peripheralDevices = gateway.getPeripheralDevices();

        if (peripheralDevices.size() < 10) {
            peripheralDevice.setGateway(gateway);
            gateway.getPeripheralDevices().add(peripheralDevice);
            return gatewayRepository.save(gateway);
        }
        throw new IllegalStateException("maximum number of devices exceeded");
    }

    @Override
    public String removeDevice(Long gatewayId, Long peripheralDeviceId) {
        Gateway gateway = gatewayRepository.findById(gatewayId).get();
        PeripheralDevice peripheralDevice = peripheralDeviceRepository.findById(peripheralDeviceId).get();
        gateway.getPeripheralDevices().remove(peripheralDevice);
        peripheralDeviceRepository.delete(peripheralDevice);
        gatewayRepository.save(gateway);
        return "device removed";
    }
}
