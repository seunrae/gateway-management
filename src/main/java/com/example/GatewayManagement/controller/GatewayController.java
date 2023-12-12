package com.example.GatewayManagement.controller;

import com.example.GatewayManagement.model.Gateway;
import com.example.GatewayManagement.model.PeripheralDevice;
import com.example.GatewayManagement.repository.GatewayRepository;
import com.example.GatewayManagement.service.GatewayService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class GatewayController {
    private final GatewayService gatewayService;
    @PostMapping("/create")
    public Gateway createGateway(@RequestBody Gateway gateway){
      return gatewayService.createGateway(gateway);
    }
    @GetMapping("/all")
    public List<Gateway> getAllGateway(){
        return gatewayService.getAllGateway();
    }
    @GetMapping("/{id}")
    public Optional<Gateway> getGatewayById(@PathVariable Long id){
        return gatewayService.getGatewayById(id);
    }

    @PutMapping("/update/{id}")
    public Gateway updateGateway(@RequestBody Gateway gateway, @PathVariable Long id){
        return gatewayService.updateGateway(id, gateway);
    }

    @DeleteMapping("delete/{id}")
    public String deleteGateway(@PathVariable Long id) {
        return gatewayService.deleteGateway(id);
    }

    @PostMapping("create-device/{id}")
    public Gateway addDevice(@PathVariable Long id,@RequestBody PeripheralDevice peripheralDevice) {
        return gatewayService.addDevice(id, peripheralDevice);
    }
    @DeleteMapping("remove-device/{gatewayId}/{peripheralDeviceId}")
    public String remove(@PathVariable Long gatewayId, @PathVariable Long peripheralDeviceId){
        return gatewayService.removeDevice(gatewayId, peripheralDeviceId);
    }
}
