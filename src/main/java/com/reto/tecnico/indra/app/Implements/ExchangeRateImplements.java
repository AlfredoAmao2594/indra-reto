package com.reto.tecnico.indra.app.Implements;

import com.reto.tecnico.indra.app.dto.ExchangeRateRequestDto;
import com.reto.tecnico.indra.app.dto.ExchangeRateResponseDto;
import com.reto.tecnico.indra.app.entity.ExchangeRate;
import com.reto.tecnico.indra.app.exception.ExchangeRateNotFoundException;
import com.reto.tecnico.indra.app.repository.ExchangeRateRepository;
import com.reto.tecnico.indra.app.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ExchangeRateImplements implements ExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Override
    public ExchangeRateResponseDto exchangeRateResponse(ExchangeRateRequestDto exchangeRateRequest) {
        try {
            ExchangeRate exchange = exchangeRateRepository.findByMoneyOriginAndMoneyDestiny(exchangeRateRequest.getMoneyOrigin().toUpperCase(), exchangeRateRequest.getMoneyDestiny().toUpperCase())
                    .orElseThrow(()-> new ExchangeRateNotFoundException("Tipo de Cambio no encontrado"));

            BigDecimal amount = BigDecimal.valueOf(exchangeRateRequest.getAmount());

            BigDecimal rate = exchange.getCode();

            BigDecimal newValue = rate.multiply(amount).setScale(2, RoundingMode.HALF_UP);

            ExchangeRateResponseDto exchangeResponse = new ExchangeRateResponseDto();
            exchangeResponse.setAmount(exchangeRateRequest.getAmount());
            exchangeResponse.setAmountConvert(newValue.doubleValue());
            exchangeResponse.setMoneyOrigin(exchangeRateRequest.getMoneyOrigin().toUpperCase());
            exchangeResponse.setMoneyDestiny(exchangeRateRequest.getMoneyDestiny().toLowerCase());
            exchangeResponse.setCode(rate);

            return exchangeResponse;
        }catch (ExchangeRateNotFoundException e){
            throw e;
        }catch (Exception e) {
            throw new RuntimeException("Error inesperado al procesar la solicitud de tipo de cambio: " + e.getMessage(), e);
        }

    }

    @Override
    public ExchangeRate exchangeRate(ExchangeRateRequestDto exchangeRateRequest) {
        try {
            ExchangeRate exchange = exchangeRateRepository.findByMoneyOriginAndMoneyDestiny(exchangeRateRequest.getMoneyOrigin().toUpperCase(), exchangeRateRequest.getMoneyDestiny().toUpperCase())
                    .orElseThrow(()-> new ExchangeRateNotFoundException("Tipo de Cambio no encontrado"));

            exchange.setCode(BigDecimal.valueOf(exchangeRateRequest.getAmount()));
            return exchangeRateRepository.save(exchange);

        }catch (ExchangeRateNotFoundException e){
            throw e;
        }catch (Exception e) {
            throw new RuntimeException("Error inesperado al procesar la solicitud de tipo de cambio: " + e.getMessage(), e);
        }
    }
}
