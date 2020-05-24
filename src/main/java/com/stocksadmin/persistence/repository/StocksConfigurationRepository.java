package com.stocksadmin.persistence.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stocksadmin.model.entity.StocksConfiguration;

@Repository
public interface StocksConfigurationRepository extends JpaRepository<StocksConfiguration, String> {

	@Query("SELECT c FROM stocksconfiguration c WHERE c.active = true")
	List<StocksConfiguration> findActiveStocks();

	@Query("SELECT c FROM stocksconfiguration c WHERE c.uuid = uuid")
	StocksConfiguration findStocks(@Param("uuid") UUID uuid);

	@Query("SELECT EXISTS(SELECT 1 FROM stocksconfiguration c WHERE c.id = :uuid)")
	boolean existsByUUID(@Param("uuid") UUID uuid);

	StocksConfiguration save(@Param("StocksConfiguration") StocksConfiguration stocksConfiguration);

	void deleteByUUID(@Param("uuid") UUID uuid) throws EmptyResultDataAccessException;

}
