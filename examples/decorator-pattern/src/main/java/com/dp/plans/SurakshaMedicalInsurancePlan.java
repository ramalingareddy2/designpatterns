package com.dp.plans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SurakshaMedicalInsurancePlan extends MedicalInsurancePlan {

	public SurakshaMedicalInsurancePlan() {
		super("suraksha", "general");
	}

	@Override
	public List<String> planBenefits() {
		// fetch benefits based on planName and Type from database and return
		List<String> planBenefits = new ArrayList<String>();
		planBenefits.addAll(Arrays.asList(new String[] { "Lower copay", "Within 48 hours of claim settlement" }));

		return planBenefits;
	}

	@Override
	public List<String> networkCoverages() {
		return Arrays.asList(new String[] { "Apollo Hospital", "Yashoda" });
	}

}
