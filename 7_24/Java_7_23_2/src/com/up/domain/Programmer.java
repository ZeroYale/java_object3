package com.up.domain;

import com.up.service.*;

public class Programmer extends Employee{
	
	private int memberId;
	private Status status = Status.FREE;
	private Equipment equipment;

	public Programmer(){
		super();
	}
	
	public Programmer(int id,String name,int age,double salary,Equipment equipment){
		super(id,name,age,salary);
		this.equipment = equipment;
	}
	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	protected String getMemberDetails(){
		return getMemberId() + "/" + getDetails();
	}
	
	public String getDetailsForTeam(){
		return getMemberDetails() +"\t����Ա";
	}
	

	@Override
	public String toString() {
		return getDetails() + "\t����Ա\t" + status + "\t\t\t" + equipment.getDescription();
		//return super.toString() + "\t����Ա\t" + status + "\t\t\t" + equipment.getDescription();
	}
	
}
