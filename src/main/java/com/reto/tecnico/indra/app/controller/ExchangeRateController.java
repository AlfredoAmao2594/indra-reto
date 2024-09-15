package com.reto.tecnico.indra.app.controller;

import com.reto.tecnico.indra.app.Implements.ExchangeRateImplements;
import com.reto.tecnico.indra.app.dto.ExchangeRateRequestDto;
import com.reto.tecnico.indra.app.dto.ExchangeRateResponseDto;
import com.reto.tecnico.indra.app.entity.ExchangeRate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exchangeRate")
@RequiredArgsConstructor
public class ExchangeRateController {

    @Autowired
    private ExchangeRateImplements exchangeRateImplements;

    @PostMapping("/change")
    public ResponseEntity<ExchangeRateResponseDto> convertMoney(@RequestBody ExchangeRateRequestDto exchangeRequest){
        ExchangeRateResponseDto exchangeResponse = exchangeRateImplements.exchangeRateResponse(exchangeRequest);

        return ResponseEntity.ok(exchangeResponse);
    }

    @PostMapping("/update")
    public ResponseEntity<ExchangeRate> updateExchange(@RequestBody ExchangeRateRequestDto exchangeRequest){
        ExchangeRate exchangeRateNew = exchangeRateImplements.exchangeRate(exchangeRequest);

        return  ResponseEntity.ok(exchangeRateNew);
    }
}
