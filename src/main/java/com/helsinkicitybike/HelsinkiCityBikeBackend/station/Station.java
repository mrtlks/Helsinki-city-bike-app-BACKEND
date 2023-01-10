package com.helsinkicitybike.HelsinkiCityBikeBackend.station;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Station {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int station_id;
	private String station_name;
	private String station_address;
	private String station_city;
	private String x;
	private String y;

	public Station() {
		super();
		this.station_name = null;
		this.station_address = null;
		this.station_city = null;
	}

	public Station(String station_name) {
		super();
		this.station_name = station_name;
	}

	public Station(String station_name, String station_address, String station_city) {
		super();
		this.station_name = station_name;
		this.station_address = station_address;
		this.station_city = station_city;

	}

	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}

	public int getStation_id() {
		return station_id;
	}

	public String getStation_name() {
		return station_name;
	}

	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}

	public String getStation_address() {
		return station_address;
	}

	public void setStation_address(String station_address) {
		this.station_address = station_address;
	}

	public String getStation_city() {
		return station_city;
	}

	public void setStation_city(String station_city) {
		this.station_city = station_city;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

}