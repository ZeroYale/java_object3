package com.up.view;

import com.up.domain.Employee;
import com.up.domain.Programmer;
import com.up.service.NameListService;
import com.up.service.TeamException;
import com.up.service.TeamService;

public class TeamView {

	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();
	
	public void enterMainMenu() {

		boolean loopFlag = true;

		do {
			listAllEmployees();

			System.out.println("1-�Ŷ��б�   2-����Ŷӳ�Ա   -3ɾ���Ŷӳ�Ա   -4�˳�  ��ѡ��(1-4):");
			char key = TSUtility.readMenuSelection();
			switch (key) {
			case '1':
				listTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.println("ȷ���Ƿ��˳�(Y/N):");
				char yn = TSUtility.readConfirmSelection();
				if (yn == 'Y') {
					loopFlag = false;
				}
				break;
			}
		} while (loopFlag);
	}

	// ��ʾ����Ա����Ա
	private void listAllEmployees() {
		System.out.println("------------------------------------�����Ŷӵ������--------------------------------");
		Employee[] emps = listSvc.getAllEmployees();
		if (emps.length == 0) {
			System.out.println("û�пͻ���¼");
		} else {
			System.out.println("ID\t����\t����\t����\tְλ\t״̬\t����\t��Ʊ\t�����豸");
			for (Employee e : emps) {
				// ����ת��
				System.out.println(e);
			}
			System.out.println("----------------------------------------------------------------------------------");
		}
	}

	// ��ʾ�����Ŷӳ�Ա�б�
	private void listTeam() {
		System.out.println("-------------------------------------�Ŷӳ�Ա�б�---------------------------------------------");
		Programmer[] team = teamSvc.getTeam();
		
		if(team.length==0){
			System.out.println("�����Ŷ�Ŀǰû�г�Ա");
		}else{
			System.out.println("TID/ID\t����\t����\t����\tְλ\t����\t��Ʊ");
			
			for(Programmer p : team){
				System.out.println("  " + p.getDetailsForTeam());
			}
		}
		System.out.println("---------------------------------------------------------------------------------------------");
		//���س�������...
		TSUtility.readReturn();
	}

	// ��ӳ�Ա���Ŷ�
	private void addMember() {
		System.out.println("-------------------------------------��ӳ�Ա---------------------------------------------");
		System.out.println("������Ҫ��ӵ�Ա��ID:");
		int id = TSUtility.readInt();
		
		//����id��ѯ��Ա���Ƿ���� 
		try {
			Employee e = listSvc.getEmployee(id);
			teamSvc.addMember(e);
			System.out.println("��ӳɹ�");
		} catch (TeamException e) {
			System.out.println("���ʧ��,ԭ��:" + e.getMessage());
		}
		
		//���س�������...
		TSUtility.readReturn();
		
	}

	// ���ŶӴ�ɾ��ָ��id�ĳ�Ա
	public void deleteMember()  {
		System.out.println("-------------------------------------ɾ����Ա---------------------------------------------");
		System.out.println("������Ҫɾ��Ա����TID:");
		int id = TSUtility.readInt();
		System.out.println("ȷ���Ƿ�ɾ��(Y/N):");
		char yn = TSUtility.readConfirmSelection();
		if(yn=='N')
		return;
		
		try {
			teamSvc.removeMember(id);
			System.out.println("ɾ���ɹ�");
		} catch (TeamException e) {
			System.out.println("ɾ��ʧ��,ԭ��:" + e.getMessage());
		}
		//���س�������...
		TSUtility.readReturn();
		
	}

	public static void main(String[] args) {
		TeamView view = new TeamView();
		view.enterMainMenu();
	}

}
