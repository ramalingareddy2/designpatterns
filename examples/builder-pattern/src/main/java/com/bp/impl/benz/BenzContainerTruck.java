package com.bp.impl.benz;

import com.bp.api.Truck;

public class BenzContainerTruck extends Truck {
	protected long length;
	protected long width;

	public BenzContainerTruck(String registrationNo, String engineNo, String chasisNo) {
		super(registrationNo, engineNo, chasisNo);
	}

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public long getWidth() {
		return width;
	}

	public void setWidth(long width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return "BenzContainerTruck [length=" + length + ", width=" + width + ", registrationNo=" + registrationNo
				+ ", engineNo=" + engineNo + ", chasisNo=" + chasisNo + ", color=" + color + ", capacity=" + capacity
				+ ", modelName=" + modelName + ", cubicCapacity=" + cubicCapacity + ", tyres=" + tyres
				+ ", manufacturer=" + manufacturer + ", permitType=" + permitType + "]";
	}

}
