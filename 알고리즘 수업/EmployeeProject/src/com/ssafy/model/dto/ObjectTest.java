package com.ssafy.model.dto;

public class ObjectTest {

	public static void main(String[] args) {
		Employee emp1 = new Employee("1", "ssafy", 3500000);
		Employee emp2 = new Employee("1", "ssafy", 3500000);
		
		System.out.printf("emp1.hashCode() : %d\n", emp1.hashCode());
		System.out.printf("emp2.hashCode() : %d\n", emp2.hashCode());
		System.out.printf("emp1 == emp2 : %b\n", emp1 == emp2);
		System.out.printf("emp1.equals(emp2) : %b\n", emp1.equals(emp2));
		
		// 모든 클래스는 Object의  sub이므로 Object타입으로 자동 형변환이 된다.
		Object o = emp1;
	}

}
