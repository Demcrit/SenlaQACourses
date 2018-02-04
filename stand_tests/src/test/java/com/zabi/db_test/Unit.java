package com.zabi.db_test;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unit")
public class Unit {
	@Id
	private int unit_id;
	private String unit_name;

	public long getUnit_id() {
		return unit_id;
	}

	public String getUnit_name() {
		return unit_name;
	}

	public void setUnit_id(int unit_id) {
		this.unit_id = unit_id;
	}

	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}
}