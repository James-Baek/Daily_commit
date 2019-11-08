package com.ssafy.model.dto;

public class Engineer extends Employee {
	private String skill;

	public Engineer() {	}
	public Engineer(String empno, String name, int salary, String skill) {
		super(empno, name, salary);
		this.skill = skill;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String toString() {
		return super.toString()+" 보유기술:" + skill;
	}
	
}
