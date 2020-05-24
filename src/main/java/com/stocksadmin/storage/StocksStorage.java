package com.stocksadmin.storage;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.stocksadmin.exception.AlreadyExistsException;
import com.stocksadmin.exception.CreateException;
import com.stocksadmin.exception.NoDataException;
import com.stocksadmin.exception.StocksAdminException;
import com.stocksadmin.model.dto.Stocks;
import com.stocksadmin.model.dto.StocksTransformation;
import com.stocksadmin.model.entity.StocksConfiguration;
import com.stocksadmin.persistence.repository.StocksConfigurationRepository;

@Repository
public class StocksStorage {

	private static Logger logger = LogManager.getLogger(StocksStorage.class);

	@Autowired
	private StocksConfigurationRepository stocksConfigurationRepository;

	@Autowired
	private StocksTransformation stocksTransformation;

	/**
	 * @return
	 * @throws NoDataException
	 */
	public List<Stocks> findAllStocks() throws StocksAdminException {
		return treatResultSet(stocksConfigurationRepository.findAll());
	}

	/**
	 * @return
	 * @throws StocksAdminException
	 */
	public List<Stocks> findAllActiveStocks() throws StocksAdminException {
		return treatResultSet(stocksConfigurationRepository.findActive());
	}

	/**
	 * @param uuid
	 * @return
	 * @throws NoDataException
	 */
	public Stocks findStock(UUID uuid) throws NoDataException {
		if (stocksConfigurationRepository.existsByUuid(uuid)) {
			throw new NoDataException(StocksAdminException.NO_DATA);
		}
		StocksConfiguration stocksConfiguration = stocksConfigurationRepository.findByUuid(uuid);
		return stocksTransformation.transformToStocks(stocksConfiguration);
	}

	/**
	 * @param stocks
	 * @return
	 * @throws StocksAdminException
	 */
	public Stocks createStock(Stocks stocks) throws StocksAdminException {
		if (stocksConfigurationRepository.existsByUuid(stocks.getUuid())) {
			throw new AlreadyExistsException(StocksAdminException.ALREADY_EXISTS);
		}
		return treatSave(stocksTransformation.transformToStocksConfiguration(stocks));
	}

	/**
	 * @param uuid
	 * @throws StocksAdminException
	 */
	@Transactional
	public void deleteStockByUUID(UUID uuid) throws StocksAdminException {
		try {
			stocksConfigurationRepository.deleteByUuid(uuid);
			logger.info("Stocks configuration {} delete successfully", uuid);
		}
		catch (EmptyResultDataAccessException e) {
			logger.error("Could not delete stocks configuration {}", uuid);
			throw new StocksAdminException(StocksAdminException.DELETION);
		}
	}

	/**
	 * @param stocksConfigurationList
	 * @return
	 * @throws NoDataException
	 */
	private List<Stocks> treatResultSet(List<StocksConfiguration> stocksConfigurationList) throws NoDataException {
		if (stocksConfigurationList.isEmpty()) {
			throw new NoDataException(StocksAdminException.NO_DATA);
		}
		logger.info("Retrieved {} stocks", stocksConfigurationList.size());
		return stocksTransformation.transformToStocksList(stocksConfigurationList);
	}

	/**
	 * @param stocksConfiguration
	 * @return
	 * @throws CreateException
	 */
	private Stocks treatSave(StocksConfiguration stocksConfiguration) throws CreateException {
		StocksConfiguration storedStocksConfiguration = stocksConfigurationRepository.save(stocksConfiguration);
		if (Objects.isNull(storedStocksConfiguration)) {
			logger.error("Could not create stocks configuration {}", stocksConfiguration.getCode());
			throw new CreateException(StocksAdminException.CREATION);
		}
		Stocks stocks = stocksTransformation.transformToStocks(storedStocksConfiguration);
		logger.info("Created stocks configuration: {}", stocks.toString());
		return stocks;
	}

}
