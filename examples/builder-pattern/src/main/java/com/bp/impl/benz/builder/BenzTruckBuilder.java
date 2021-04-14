package com.bp.impl.benz.builder;

import com.bp.api.Truck;
import com.bp.api.builder.TruckBuilder;
import com.bp.impl.benz.BenzContainerTruck;

public class BenzTruckBuilder extends TruckBuilder {

	@Override
	public Truck build() {
		Truck truck = null;

		truck = new BenzContainerTruck(registrationNo, engineNo, chasisNo);
		truck.setCapacity(capacity);
		truck.setColor(color);
		truck.setCubicCapacity(cubicCapacity);
		truck.setManufacturer(manufacturer);
		truck.setModelName(modelName);
		truck.setPermitType(permitType);
		truck.setTyres(tyres);

		return truck;
	}

}
