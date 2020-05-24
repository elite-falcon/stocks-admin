package com.stocksadmin.model.entity;

import java.util.Objects;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STOCKSCONFIGURATION")
public class StocksConfiguration implements SerializableEntity {

	@Id
	@Column(name = "uuid", updatable = false, nullable = false)
	private UUID uuid;

	@Basic
	@Column(name = "code")
	private String code;

	@Basic
	@Column(name = "createat")
	private long createdAt;

	@Basic
	@Column(name = "modifiedat")
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof StocksConfiguration))
			return false;
		StocksConfiguration that = (StocksConfiguration) o;
		return Objects.equals(uuid, that.uuid) && Objects.equals(code, that.code) && Objects
				.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt)
				&& active == that.active;
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, code, createdAt, modifiedAt, active);
	}

}
