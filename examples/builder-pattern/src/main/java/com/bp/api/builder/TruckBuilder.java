package com.bp.api.builder;

import com.bp.api.Truck;

abstract public class TruckBuilder {
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

	public abstract Truck build();

	public String registrationNo() {
		return registrationNo;
	}

	public TruckBuilder registrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
		return this;
	}

	public String engineNo() {
		return engineNo;
	}

	public TruckBuilder engineNo(String engineNo) {
		this.engineNo = engineNo;
		return this;
	}

	public String chasisNo() {
		return chasisNo;
	}

	public TruckBuilder chasisNo(String chasisNo) {
		this.chasisNo = chasisNo;
		return this;
	}

	public String color() {
		return color;
	}

	public TruckBuilder color(String color) {
		this.color = color;
		return this;
	}

	public int capacity() {
		return capacity;
	}

	public TruckBuilder capacity(int capacity) {
		this.capacity = capacity;
		return this;
	}

	public String modelName() {
		return modelName;
	}

	public TruckBuilder modelName(String modelName) {
		this.modelName = modelName;
		return this;
	}

	public int cubicCapacity() {
		return cubicCapacity;
	}

	public TruckBuilder cubicCapacity(int cubicCapacity) {
		this.cubicCapacity = cubicCapacity;
		return this;
	}

	public int tyres() {
		return tyres;
	}

	public TruckBuilder tyres(int tyres) {
		this.tyres = tyres;
		return this;
	}

	public String manufacturer() {
		return manufacturer;
	}

	public TruckBuilder manufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
		return this;
	}

	public String permitType() {
		return permitType;
	}

	public TruckBuilder permitType(String permitType) {
		this.permitType = permitType;
		return this;
	}

}
