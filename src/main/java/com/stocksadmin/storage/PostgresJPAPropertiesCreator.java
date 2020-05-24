package com.stocksadmin.storage;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.dialect.PostgreSQL94Dialect;
import org.springframework.stereotype.Component;

@Component
public class PostgresJPAPropertiesCreator implements JPAPropertiesCreator {

	@Override
	public Map<String, Object> createJPAConfiguration() {
		Map<String, Object> postgre = new HashMap<>();

		// Defines the SQL dialect to Postgres specific
		postgre.put(org.hibernate.cfg.Environment.DIALECT, PostgreSQL94Dialect.class.getName());
		postgre.put(org.hibernate.cfg.Environment.SHOW_SQL, true);

		return postgre;

	}
}
