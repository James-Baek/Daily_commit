package com.ssafy.model.dto;

import java.util.*;

public class EmployeePolyManger2 implements EmployeeDao {
	/**
	 * 다형성을 배열에 적용
	 * 다형성에 의해 모든 sub 타입은 super으로 형변환이 자동으로 되기 때문에
	 * super타입의 배열 하나만 선언하면 sub타입의 객체도 저장할 수 있다.
	 */

	private HashMap<String, Employee> emps;

	/**
	 * 다음 저장 위치, 현재 저장된 수
	 */
	
	private int empIndex;

	public EmployeePolyManger2() {
		emps = new HashMap<String, Employee>();
	}
	

	@Override
	public Employee search(String empno) {
		Employee emp = emps.get(empno);
		if(emp == null) {
			return null;     // Exception을 던질 예정
		}else {
			return emp;
		}
	}
	
	/**
	 *  사원번호에 해당한 사원을 찾아서 정보를 리턴하는 기능의 함수
	 */
//	public String search(String empno) {
//		if(empno != null) {
//			for(int i = 0; i < empIndex; i++) {
//				if(empno.equals(emps[i].getEmpno())) {
//					return emps[i].toString();
//				}
//			}
//		}
//		return String.format("사원번호 %s번은 등록된 사원번호가 아닙니다.", empno);
//	}
	

	@Override
	public void add(Employee emp) {
		System.out.println("Employee를 저장합니다.");
		if(emp != null) {
			String empno = emp.getEmpno();
			Employee find = emps.get(empno);
			if(find != null) {
				System.out.println("이미 등록된 사원번호입니다.");
			}else {
				emps.put(empno,  emp);
			}
		}
	}

	@Override
	public void update(Employee emp) {
		if(emp != null) {
			String empno = emp.getEmpno();
			Employee find = emps.get(empno);
			if(find != null) {
				System.out.println("수정할 사원번호가 등록되지 않았씁니다.");
			}else {
				emps.put(empno, emp);
			}
		}else {
			System.out.println("수정할 사원의 정보를 입력해 주세요.");
		}
	}
	

	@Override
	public void remove(String empno) {
		Employee find = emps.get(empno);
		if(find != null) {
			System.out.println("삭제할 사원번호가 등록되지 않았습니다.");
		}else {
			emps.remove(empno);
		}
	}
	
	public void print() {
		for(Employee employee : emps.values()){
			System.out.println(employee);
		}
	}
	
	public void close() {
		System.exit(0);
	}
	public List<Employee> serchAll(){
		return (List)emps.values();
	}
	public void setEmployees(List<Employee> emps) {
		for(Employee emp : emps) {
			this.emps.put(emp.getEmpno(), emp);
		}
	}


	@Override
	public int findIndex(String empno) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
