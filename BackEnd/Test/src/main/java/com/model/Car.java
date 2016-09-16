package com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "car")
public class Car implements Serializable {
	
	private String fk;	// same as the ssid of the user
	private Integer id; 
	private Float km;
	private String brand;
	private String model;
	private Integer engine;
	private Date lastService;
	private Float fuelCompsumption;
	
	public Car(String brand, String model, Integer engine, Date lastService, Float fuelCompsumption,Integer id,String fk) {
		super();
		this.fk=fk;
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.engine = engine;
		this.lastService = lastService;
		this.fuelCompsumption = fuelCompsumption;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@Column(name = "km")
	public Float getKm() {
		return km;
	}
	public void setKm(Float km) {
		this.km = km;
	}
	@Column(name ="fk")
	public String getFk() {
		return fk;
	}
	public void setFk(String fk) {
		this.fk = fk;
	}
	@Id
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "brand")
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Column(name = "Model")
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Column(name = "engine")
	public Integer getEngine() {
		return engine;
	}
	public void setEngine(Integer engine) {
		this.engine = engine;
	}
	@Column(name = "lastservice")
	public Date getLastService() {
		return lastService;
	}
	public void setLastService(Date lastService) {
		this.lastService = lastService;
	}
	@Column(name = "fuelconsumption")
	public Float getFuelCompsumption() {
		return fuelCompsumption;
	}
	public void setFuelCompsumption(Float fuelCompsumption) {
		this.fuelCompsumption = fuelCompsumption;
	}
	
	

}
