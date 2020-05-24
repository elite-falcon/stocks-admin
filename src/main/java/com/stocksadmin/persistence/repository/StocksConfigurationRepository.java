package com.stocksadmin.persistence.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stocksadmin.model.entity.StocksConfiguration;

public interface StocksConfigurationRepository extends JpaRepository<StocksConfiguration, UUID> {

	@Query("SELECT c FROM StocksConfiguration c WHERE c.uuid = :uuid")
	StocksConfiguration findByUuid(@Param("uuid") UUID uuid);

	@Query("SELECT c FROM StocksConfiguration c WHERE c.active = true")
	List<StocksConfiguration> findActive();

	@Query("SELECT true FROM StocksConfiguration c WHERE c.uuid = :uuid")
	boolean existsByUuid(@Param("uuid") UUID uuid);

	StocksConfiguration save(@Param("StocksConfiguration") StocksConfiguration stocksConfiguration);

	void deleteByUuid(@Param("uuid") UUID uuid) throws EmptyResultDataAccessException;

}
