package com.dp.test;

import com.dp.plans.MaxBupaMedicalInsurancePlan;
import com.dp.plans.decorator.PremiumBenefitsMedicalInsurancePlan;

public class DPTest {
	public static void main(String[] args) {
		PremiumBenefitsMedicalInsurancePlan plan = new PremiumBenefitsMedicalInsurancePlan(
				new MaxBupaMedicalInsurancePlan());
		System.out.println("plan name : " + plan.getPlanName());
		System.out.println("plan type : " + plan.getPlanType());

		System.out.println("plan benefits:" + plan.planBenefits());
		System.out.println("coverage networks : " + plan.networkCoverages());

	}
}
