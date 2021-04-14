package com.templatemethod.beans;

public class Identity {
	private String uniqueNo;
	private String identityType;
	private String issuedBy;

	public Identity() {
		super();
	}

	public Identity(String uniqueNo, String identityType, String issuedBy) {
		super();
		this.uniqueNo = uniqueNo;
		this.identityType = identityType;
		this.issuedBy = issuedBy;
	}

	public String getUniqueNo() {
		return uniqueNo;
	}

	public void setUniqueNo(String uniqueNo) {
		this.uniqueNo = uniqueNo;
	}

	public String getIdentityType() {
		return identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

}
