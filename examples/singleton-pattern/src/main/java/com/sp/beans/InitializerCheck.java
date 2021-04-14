package com.sp.beans;

public class InitializerCheck {

	public InitializerCheck() {
		System.out.println("Constructor");
	}

	{
		System.out.println("Instance block");
	}
	static {
		System.out.println("static-block");
	}

}
