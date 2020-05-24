package com.stocksadmin.storage;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stocksadmin.exception.NoDataException;
import com.stocksadmin.exception.StocksAdminException;
import com.stocksadmin.model.dto.Stocks;
import com.stocksadmin.model.dto.StocksTransformation;
import com.stocksadmin.model.entity.StocksConfiguration;
import com.stocksadmin.persistence.repository.StocksConfigurationRepository;

@Component
public class StocksConfigurationStorage {

	private static Logger logger = LogManager.getLogger(StocksConfigurationStorage.class);

	@Autowired
	private StocksConfigurationRepository stocksConfigurationRepository;

	@Autowired
	private StocksTransformation stocksTransformation;

	/**
	 * @return
	 * @throws NoDataException
	 */
	public List<Stocks> findAll() throws NoDataException {
		return treatResultSet(stocksConfigurationRepository.findAll());
	}

	public List<Stocks> findAllActiveStocks() throws NoDataException {
		return treatResultSet(stocksConfigurationRepository.findActiveStocks());
	}

	private List<Stocks> treatResultSet(List<StocksConfiguration> stocksConfigurationList) throws NoDataException {
		if (stocksConfigurationList.isEmpty()) {
			throw new NoDataException(StocksAdminException.NO_DATA);
		}
		logger.info("retrieved {} stocks", stocksConfigurationList.size());
		return stocksTransformation.transformToStocks(stocksConfigurationList);
	}

}
