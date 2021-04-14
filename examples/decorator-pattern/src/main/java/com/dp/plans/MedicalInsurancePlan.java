package com.dp.plans;

import java.util.List;

public abstract class MedicalInsurancePlan {
	protected String planName;
	protected String planType;

	public MedicalInsurancePlan(String planName, String planType) {
		this.planName = planName;
		this.planType = planType;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	abstract public List<String> planBenefits();

	abstract public List<String> networkCoverages();
}
