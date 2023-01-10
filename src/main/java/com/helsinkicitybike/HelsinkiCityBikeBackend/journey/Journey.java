package com.helsinkicitybike.HelsinkiCityBikeBackend.journey;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.helsinkicitybike.HelsinkiCityBikeBackend.station.Station;

@Entity
public class Journey {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String departureTime;
	private String returnTime;
	private int departureStationId;
	private String departureStationName;
	private int returnStationId;
	private String returnStationName;
	private int coveredDistance;
	private int duration;
	

	public Journey() {
		super();
		this.departureTime = null;
		this.returnTime = null;
		this.departureStationName = null;
		this.returnStationName = null;

	}

	public Journey(String departureTime, String returnTime, String departureStationName, String returnStationName,
			Station station) {
		super();
		this.departureTime = departureTime;
		this.returnTime = returnTime;
		this.departureStationName = departureStationName;
		this.returnStationName = returnStationName;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartureStationName() {
		return departureStationName;
	}

	public void setDepartureStationName(String departureStationName) {
		this.departureStationName = departureStationName;
	}

	public String getReturnStationName() {
		return returnStationName;
	}

	public void setReturnStationName(String returnStationName) {
		this.returnStationName = returnStationName;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	public int getDepartureStationId() {
		return departureStationId;
	}

	public void setDepartureStationId(int departureStationId) {
		this.departureStationId = departureStationId;
	}

	public int getReturnStationId() {
		return returnStationId;
	}

	public void setReturnStationId(int returnStationId) {
		this.returnStationId = returnStationId;
	}

	public int getCoveredDistance() {
		return coveredDistance;
	}

	public void setCoveredDistance(int coveredDistance) {
		this.coveredDistance = coveredDistance;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
