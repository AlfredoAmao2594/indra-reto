package com.reto.tecnico.indra.app.repository;

import com.reto.tecnico.indra.app.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate,Long> {

    Optional<ExchangeRate> findByMoneyOriginAndMoneyDestiny(String moneyOrigin, String moneyDestiny);
}
