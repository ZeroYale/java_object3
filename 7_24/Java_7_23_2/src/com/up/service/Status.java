package com.up.service;

public class Status {

	private final String NAME;
	
	public Status(String name) {
		super();
		this.NAME = name;
	}
	
	//¿ÕÏÐ
	public static final Status FREE = new Status("FREE");
	//ÐÝ¼Ù
	public static final Status VOCATION = new Status("VOCATION");
	//Ã¦Âµ
	public static final Status BUSY = new Status("BUSY");

	public String getNAME() {
		return NAME;
	}

	@Override
	public String toString() {
		return NAME;
	}
}
