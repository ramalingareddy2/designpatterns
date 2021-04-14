package com.dp.plans.decorator;

import java.util.Arrays;
import java.util.List;

import com.dp.plans.MedicalInsurancePlan;

public class PremiumBenefitsMedicalInsurancePlan extends MedicalInsurancePlan {
	private MedicalInsurancePlan medicalInsurancePlan;

	public PremiumBenefitsMedicalInsurancePlan(MedicalInsurancePlan medicalInsurancePlan) {
		super("Premium " + medicalInsurancePlan.getPlanName(), "Premium");
		this.medicalInsurancePlan = medicalInsurancePlan;
	}

	@Override
	public List<String> planBenefits() {
		List<String> planBenefits = null;

		planBenefits = medicalInsurancePlan.planBenefits();
		planBenefits.add("Dental Coverage");
		planBenefits.add("No pre-approval for hospitalization");

		return planBenefits;
	}

	@Override
	public List<String> networkCoverages() {
		return Arrays.asList(new String[] { "All Hospitals in Metropolitins" });
	}

}
