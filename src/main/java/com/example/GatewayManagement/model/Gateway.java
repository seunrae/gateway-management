package com.example.GatewayManagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Gateway {
    @Id
    @GeneratedValue
    private Long gatewayId;
    private String serialNumber;
    private String name;
    private String ipv4Address;
    @OneToMany(mappedBy = "gateway",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PeripheralDevice> peripheralDevices;
}

