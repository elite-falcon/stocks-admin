package com.stocksadmin.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocksadmin.model.entity.StocksConfiguration;

public interface StocksConfigurationRepository extends JpaRepository<StocksConfiguration, String> {

}
