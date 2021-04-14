package com.dp.plans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxBupaMedicalInsurancePlan extends MedicalInsurancePlan {
	public MaxBupaMedicalInsurancePlan() {
		super("max bupa", "general");
	}

	@Override
	public List<String> planBenefits() {
		List<String> planBenefits = new ArrayList<String>();
		planBenefits.addAll(Arrays.asList(new String[] { "Lower Copay", "With 48 hours of claim settlement",
				"Cashless Facility in Network hospitals" }));

		return planBenefits;
	}

	@Override
	public List<String> networkCoverages() {
		return Arrays.asList(new String[] { "Maxcure Hospital", "Apollo Hospital", "Yashoda", "Prime Hospitals" });
	}

}
