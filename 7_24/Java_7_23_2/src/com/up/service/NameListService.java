package com.up.service;

import com.up.domain.Architect;
import com.up.domain.Designer;
import com.up.domain.Employee;
import com.up.domain.Equipment;
import com.up.domain.Programmer;

import static com.up.service.Data.*;

public class NameListService {
	
	private Employee[] employees;
	
	public NameListService(){
		employees = new Employee[EMPLOYEES.length];
		
		
		for(int i=0;i<employees.length;i++){
			//��ȡͨ�õ�����
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);
			
			//�豸�ӿ�
			Equipment eq;
			//����
			double bonus;
			//��Ʊ
			int stock;
			
			switch(type){
			case Data.EMPLOYEE:
				//ͬһ��
				employees[i] = new Employee(id,name,age,salary);
				break;
			case Data.PROGRAMMER:
				eq = createEquipment(i);
				//����ת��
				employees[i] = new Programmer(id,name,age,salary,eq);
				break;
			case Data.DESIGNER:
				eq = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				//����ת��
				employees[i] = new Designer(id,name,age,salary,eq,bonus);
				break;
			case Data.ARCHITECT:
				eq = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				//����ת��
				employees[i] = new Architect(id,name,age,salary,eq,bonus,stock);
				break;
			}
		}
	}
	
	
	private Equipment createEquipment(int index){           
		int type = Integer.parseInt(EQIPMENTS[index][0]);
		
		switch(type){
		case PC:
			return new PC(EQIPMENTS[index][1],EQIPMENTS[index][2]);
		case NOTEBOOK:
			double price = Double.parseDouble(EQIPMENTS[index][2]);
			return new NoteBook(EQIPMENTS[index][1],price);
		case PRINTER:
			return new Printer(EQIPMENTS[index][1],EQIPMENTS[index][2]);
		}
		return null;
	}

	public Employee[] getAllEmployees() {
		return employees;
	}
	
	public Employee getEmployee(int id) throws TeamException{
		for(Employee e : employees){
			if(e.getId() == id)
				return e;
		}
		throw new TeamException("��Ա��������");
	}

}





















