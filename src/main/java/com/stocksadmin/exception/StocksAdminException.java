package com.stocksadmin.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StocksAdminException extends Exception {

	public static final String NO_DATA = "No data";
	public static final String DELETION = "Delete of stocks configuration failed.";
	public static final String ALREADY_EXISTS = "Stocks configuration already exists.";
	public static final String CREATION = "Creation of stocks configuration failed.";

	protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getSimpleName());

	public StocksAdminException(String message) {
		super(message);
	}

}
