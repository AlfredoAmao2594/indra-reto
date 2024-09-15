package com.reto.tecnico.indra.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateResponseDto {

    private double amount;
    private double amountConvert;
    private String moneyOrigin;
    private String moneyDestiny;
    private BigDecimal code;
}
