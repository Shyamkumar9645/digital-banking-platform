package com.project.digital_banking_platform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "transfer_limits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferLimit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long limitId;

    @Column(nullable = false, length = 20)
    private String accountType;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal dailyLimit;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal singleTransactionLimit;

    // Getters and Setters
}
