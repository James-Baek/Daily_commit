package com.ssafy.model.dto;

public class EmployeeTest {

	public static void main(String[] args) {
//		EmployeeManager manager = new EmployeeManager();
		EmployeePolyManger manager = new EmployeePolyManger();
		manager.add(new Employee("1", "saffy", 5000000));
//		manager.add(new Employee("1", "saffy", 5000000));
		manager.add(new Manager("2", "홍길동", 5000000,"대리"));
		manager.add(new Engineer("3", "고길동", 5000000,"둘리 괴롭히기"));
		System.out.println("=============등록 후 사원 정보===============");
		System.out.println(manager.search("1"));
		System.out.println(manager.search("2"));
		System.out.println(manager.search("3"));
		System.out.println(manager.search("4"));
		System.out.println(manager.search("4"));
	}

}
