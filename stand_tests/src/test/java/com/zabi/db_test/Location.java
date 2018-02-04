package com.zabi.db_test;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {
	@Id
	private int location_id;
	private String country;
	private String city;
	private String office;
	private String name;

	public long getLocation_id() {
		return location_id;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getOffice() {
		return office;
	}

	public String getName() {
		return name;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public void setName(String name) {
		this.name = name;
	}
}
