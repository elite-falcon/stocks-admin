package com.stocksadmin.model.entity;

import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stocksconfiguration")
public class StocksConfiguration implements SerializableEntity {

	@Id
	@Column(name = "uuid")
	private UUID uuid;

	@Basic
	@Column(name = "code")
	private String code;

	@Basic
	@Column(name = "createdAt")
	private long createdAt;

	@Basic
	@Column(name = "modifiedAt")
	private long modifiedAt;

	@Basic
	@Column(name = "active")
	private boolean active;

	public StocksConfiguration() {

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
}
