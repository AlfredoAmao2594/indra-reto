package com.reto.tecnico.indra.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateRequestDto {

    private double amount;
    private String moneyOrigin;
    private String moneyDestiny;

}
