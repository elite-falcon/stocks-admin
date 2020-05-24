package com.stocksadmin.model.dto;

import java.util.UUID;

public class Stocks implements StocksDTO {

	private UUID uuid;
	private String code;
	private long createdAt;
	private long modifiedAt;
	private boolean active;

	public Stocks() {

	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	public long getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(long modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return new StringBuilder().append(this.getUuid()).append(this.getCode()).toString();
	}
}
