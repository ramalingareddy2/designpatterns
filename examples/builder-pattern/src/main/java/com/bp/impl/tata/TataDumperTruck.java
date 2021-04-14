package com.bp.impl.tata;

import com.bp.api.Truck;

public class TataDumperTruck extends Truck {
	protected double maxWeight;

	public TataDumperTruck(String registrationNo, String engineNo, String chasisNo) {
		super(registrationNo, engineNo, chasisNo);
	}

	public double getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}

	@Override
	public String toString() {
		return "TataTruck [maxWeight=" + maxWeight + ", registrationNo=" + registrationNo + ", engineNo=" + engineNo
				+ ", chasisNo=" + chasisNo + ", color=" + color + ", capacity=" + capacity + ", modelName=" + modelName
				+ ", cubicCapacity=" + cubicCapacity + ", tyres=" + tyres + ", manufacturer=" + manufacturer
				+ ", permitType=" + permitType + "]";
	}

}
