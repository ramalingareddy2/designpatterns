package com.bp.impl.tata.builder;

import com.bp.api.Truck;
import com.bp.api.builder.TruckBuilder;
import com.bp.impl.tata.TataDumperTruck;

public class TataTruckBuilder extends TruckBuilder {
	@Override
	public Truck build() {
		Truck truck = null;

		truck = new TataDumperTruck(registrationNo, engineNo, chasisNo);
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
