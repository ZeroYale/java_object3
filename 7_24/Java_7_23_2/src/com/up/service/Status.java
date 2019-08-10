package com.up.service;

public class Status {

	private final String NAME;
	
	public Status(String name) {
		super();
		this.NAME = name;
	}
	
	//����
	public static final Status FREE = new Status("FREE");
	//�ݼ�
	public static final Status VOCATION = new Status("VOCATION");
	//æµ
	public static final Status BUSY = new Status("BUSY");

	public String getNAME() {
		return NAME;
	}

	@Override
	public String toString() {
		return NAME;
	}
}
