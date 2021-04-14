package com.bp.test;

import java.io.IOException;

import com.bp.api.Truck;

public class BPTest {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

		Truck truck = Truck.newBuilder("TS 01 TH 3093", "eg02903", "ch233").color("blue").capacity(1000)
				.cubicCapacity(2000).manufacturer("Benz").modelName("Container").permitType("all india").tyres(10)
				.build();
		System.out.println(truck);
	}
}
