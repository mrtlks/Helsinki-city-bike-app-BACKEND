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
	private int fid;
	private String name;
	private String nimi;
	private String namn;
	private String station_address;
	private String adress;
	private String stad;
	private String operaattor;
	private String kapasiteet;
	private String station_city;
	private String x;
	private String y;
	private boolean isremovable;
	private boolean editable;
	
	
	// lisää puuttuvat mitä on tietokannassa
	// private String nimi = name;
	

	public Station() {
		super();
		this.name = null;
		this.station_address = null;
		this.station_city = null;
		this.x = null;
		this.y = null;
	
	}

	public Station(String name) {
		super();
		this.name = name;
	}

	public Station(String name, String station_address, String station_city, String x, String y ) {
		super();
		this.name = name;
		this.station_address = station_address;
		this.station_city = station_city;
		this.x = x;
		this.y =y;

	}
	
			

	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}

	public int getStation_id() {
		return station_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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


	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}

	public String getStad() {
		return stad;
	}

	public void setStad(String stad) {
		this.stad = stad;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getOperaattor() {
		return operaattor;
	}

	public void setOperaattor(String operaattor) {
		this.operaattor = operaattor;
	}

	public String getKapasiteet() {
		return kapasiteet;
	}

	public void setKapasiteet(String kapasiteet) {
		this.kapasiteet = kapasiteet;
	}

	public boolean getIsremovable() {
		return isremovable;
	}

	public void setIsremovable(boolean isremovable) {
		this.isremovable = isremovable;
	}

	public boolean getEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

}
