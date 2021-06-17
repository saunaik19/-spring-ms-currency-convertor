package com.saurabh.example.currencyexchangeservice.repository;

import com.saurabh.example.currencyexchangeservice.dto.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface ExchangeRepository extends JpaRepository<ExchangeValue, Integer> {

    ExchangeValue findByFromAndTo(String from,String to);
}
