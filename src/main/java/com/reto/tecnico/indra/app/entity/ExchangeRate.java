package com.reto.tecnico.indra.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exchange_rate")
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "money_origin", nullable = false)
    private String moneyOrigin;

    @Column(name = "money_destiny", nullable = false)
    private String moneyDestiny;

    @Column(name = "code", precision = 10, scale = 2)
    private BigDecimal code;

}
