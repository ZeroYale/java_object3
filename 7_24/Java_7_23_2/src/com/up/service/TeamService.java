package com.up.service;

import com.up.domain.Architect;
import com.up.domain.Designer;
import com.up.domain.Employee;
import com.up.domain.Programmer;

public class TeamService {

	private static int counter = 1; // �����Զ������Ŷӳ�Ա��memberId
	private final int MAX_MEMBER = 5; // �Ŷ���������
	private Programmer[] team = new Programmer[MAX_MEMBER];// ���浱ǰ�Ŷӳ�Ա
	private int total = 0; // �Ŷ�ʵ������

	// ����team�����г���Ա���ɵ�����
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];

		for (int i = 0; i < total; i++) {
			team[i] = this.team[i];
		}
		return team;
	}

	public void addMember(Employee e) throws TeamException {
		// �ж��Ŷ������Ƿ�����
		if (total >= MAX_MEMBER) {
			throw new TeamException("��Ա����,�޷����");
		}

		// �ж��Ƿ��ǿ�����Ա(Programmer,Designer,Architect)
		if (!(e instanceof Programmer)) {
			throw new TeamException("�ó�Ա���ǿ�����Ա,�޷����");
		}

		Programmer p = (Programmer) e;

		// �жϸ�Ա���Ƿ��Ѿ����
		if (isExist(p)) {
			throw new TeamException("��Ա���Ѿ��ڱ��Ŷ���");
		}

		// �жϸ�Ա���Ƿ����
		if (p.getStatus().getNAME().equals("BUSY")) {
			throw new TeamException("��Ա������ĳ�Ŷӳ�Ա");
		} else if (p.getStatus().getNAME().equals("VOCATION")) {
			throw new TeamException("��Ա�������ݼ�,�޷����");
		}

		// �Ŷ�������ֻ����һ���ܹ�ʦ
		// �Ŷ�������ֻ�����������ʦ
		// �Ŷ�������ֻ������������Ա

		// �洢Programmer
		int numOfPrg = 0;
		// �洢Designer
		int numOfDsgn = 0;
		// �洢Architect
		int numOfArch = 0;

		for (int i = 0; i < total; i++) {
			if (team[i] instanceof Architect) {
				numOfArch++;
			} else if (team[i] instanceof Designer) {
				numOfDsgn++;
			} else if (team[i] instanceof Programmer) {
				numOfPrg++;
			}
		}

		if (p instanceof Architect) {
			if (numOfArch >= 1)
				throw new TeamException("�Ŷ�������ֻ����һ���ܹ�ʦ");
		} else if (p instanceof Designer) {
			if (numOfDsgn >= 2)
				throw new TeamException("�Ŷ�������ֻ�����������ʦ");
		} else if (p instanceof Programmer) {
			if (numOfPrg >= 3)
				throw new TeamException("�Ŷ�������ֻ������������Ա");
		}

		// ��ӵ�����
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);
		team[total++] = p;
	}

	// �жϸ�Ա���Ƿ��Ѿ����
	private boolean isExist(Programmer p) {
		for (int i = 0; i < total; i++) {
			if (team[i].getId() == p.getId()) {
				return true;
			}
		}
		return false;
	}
	
	
	
	//ɾ��ָ��memberId�ĳ���Ա
	public void removeMember(int memberId) throws TeamException{
		int n = 0;
		//��ָ��memberId��Ա��,��ɾ��
		//��ԭ�Ŷ�Ա��Free״̬
		for(;n<total;n++){
			if(team[n].getMemberId()==memberId){
				team[n].setStatus(Status.FREE);
				break;
			}
		}
	
		//�������һ��,���Ҳ���,���쳣   
		if(n ==  total){
			throw new TeamException("�Ҳ����ó�Ա,�޷�ɾ��");
		}
		
		//�����Ԫ�ظ���ǰ���Ԫ��
		for(int i=n+1;i<total;i++){
			team[i-1] = team[i];
		}
		
		team[--total] = null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
