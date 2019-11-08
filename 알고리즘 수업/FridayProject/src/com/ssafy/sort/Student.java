package com.ssafy.sort;

public class Student{
	private String name;
	private int age;
	private int math;
	private int cla;
	
	public Student() {}
	public Student(String name, int age, int math, int cla) {
		this.name = name;
		this.age = age;
		this.math = math;
		this.cla = cla;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getCla() {
		return cla;
	}
	public void setCla(int cla) {
		this.cla = cla;
	}
	public String toString() {
		return name;
	}
	public String score() {
		return Integer.toString(math);
	}

}
