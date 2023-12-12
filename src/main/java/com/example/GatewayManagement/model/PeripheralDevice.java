package com.example.GatewayManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PeripheralDevice {
    @Id
    @GeneratedValue
    private Long UID;
    private String vendor;
    @CreationTimestamp
    private LocalDate created;
    private STATUS status;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "gatewayId")
    private Gateway gateway;
}
