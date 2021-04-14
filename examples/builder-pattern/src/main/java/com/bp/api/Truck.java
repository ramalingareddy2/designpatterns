package com.bp.api;

import java.io.IOException;
import java.util.Properties;

import com.bp.api.builder.TruckBuilder;

public abstract class Truck {
	protected String registrationNo;
	protected String engineNo;
	protected String chasisNo;
	protected String color;
	protected int capacity;
	protected String modelName;
	protected int cubicCapacity;
	protected int tyres;
	protected String manufacturer;
	protected String permitType;

	public Truck(String registrationNo, String engineNo, String chasisNo) {
		this.registrationNo = registrationNo;
		this.engineNo = engineNo;
		this.chasisNo = chasisNo;
	}

	public static TruckBuilder newBuilder(String registrationNo, String engineNo, String chasisNo)
			throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		TruckBuilder truckBuilder = null;
		String builderImplClass = null;
		Properties props = null;
		Class<?> clazz = null;

		props = new Properties();
		props.load(Truck.class.getClassLoader().getResourceAsStream("env.properties"));
		builderImplClass = props.getProperty("com.bp.api.builder");
		clazz = Class.forName(builderImplClass);
		truckBuilder = (TruckBuilder) clazz.newInstance();

		return truckBuilder.registrationNo(registrationNo).chasisNo(chasisNo).engineNo(engineNo);
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getChasisNo() {
		return chasisNo;
	}

	public void setChasisNo(String chasisNo) {
		this.chasisNo = chasisNo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getCubicCapacity() {
		return cubicCapacity;
	}

	public void setCubicCapacity(int cubicCapacity) {
		this.cubicCapacity = cubicCapacity;
	}

	public int getTyres() {
		return tyres;
	}

	public void setTyres(int tyres) {
		this.tyres = tyres;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getPermitType() {
		return permitType;
	}

	public void setPermitType(String permitType) {
		this.permitType = permitType;
	}

}
