package com.stocksadmin.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.stocksadmin.model.entity.StocksConfiguration;

public class StocksTransformation {

	/**
	 * @param stocksConfiguration
	 * @return
	 */
	public Stocks transformToStocks(StocksConfiguration stocksConfiguration) {
		Stocks stocks = new Stocks();
		stocks.setUuid(stocksConfiguration.getUuid());
		stocks.setCode(stocksConfiguration.getCode());
		stocks.setCreatedAt(stocksConfiguration.getCreatedAt());
		stocks.setModifiedAt(stocksConfiguration.getModifiedAt());
		stocks.setActive(stocksConfiguration.isActive());
		return stocks;
	}

	/**
	 * @param stocks
	 * @return
	 */
	public StocksConfiguration transformToStocksConfiguration(Stocks stocks) {
		StocksConfiguration stocksConfiguration = new StocksConfiguration();
		stocksConfiguration.setUuid(stocks.getUuid());
		stocksConfiguration.setCode(stocks.getCode());
		stocksConfiguration.setCreatedAt(stocks.getCreatedAt());
		stocksConfiguration.setModifiedAt(stocks.getModifiedAt());
		stocksConfiguration.setActive(stocks.isActive());
		return stocksConfiguration;
	}

	/**
	 * @param stocksConfigurationsList
	 * @return
	 */
	public List<Stocks> transformToStocksList(List<StocksConfiguration> stocksConfigurationsList) {
		List<Stocks> stocksList = new ArrayList();

		for (StocksConfiguration stocksConfiguration : stocksConfigurationsList) {
			Stocks stocks = new Stocks();
			stocks.setUuid(stocksConfiguration.getUuid());
			stocks.setCode(stocksConfiguration.getCode());
			stocks.setCreatedAt(stocksConfiguration.getCreatedAt());
			stocks.setModifiedAt(stocksConfiguration.getModifiedAt());
			stocks.setActive(stocksConfiguration.isActive());
			stocksList.add(stocks);
		}
		return stocksList;
	}
}
