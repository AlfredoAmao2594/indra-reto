package com.reto.tecnico.indra.app.service;

import com.reto.tecnico.indra.app.dto.ExchangeRateRequestDto;
import com.reto.tecnico.indra.app.dto.ExchangeRateResponseDto;
import com.reto.tecnico.indra.app.entity.ExchangeRate;

public interface ExchangeRateService {

    public ExchangeRateResponseDto exchangeRateResponse (ExchangeRateRequestDto exchangeRateRequest);
    public ExchangeRate exchangeRate (ExchangeRateRequestDto exchangeRateRequest);
}
