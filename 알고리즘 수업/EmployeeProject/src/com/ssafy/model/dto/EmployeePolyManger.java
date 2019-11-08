package com.ssafy.model.dto;

import java.util.*;

public class EmployeePolyManger implements EmployeeDao {
	/**
	 * 다형성을 배열에 적용
	 * 다형성에 의해 모든 sub 타입은 super으로 형변환이 자동으로 되기 때문에
	 * super타입의 배열 하나만 선언하면 sub타입의 객체도 저장할 수 있다.
	 */

	private List<Employee> emps;

	/**
	 * 다음 저장 위치, 현재 저장된 수
	 */
	
	private int empIndex;

	public EmployeePolyManger() {
		emps = new LinkedList<Employee>();
	}
	
	/* (non-Javadoc)
	 * @see com.ssafy.model.dto.EmployeeDao#findIndex(java.lang.String)
	 */

	@Override
	public int findIndex(String empno) {
		if(empno != null) {
			for(int i = 0; i < empIndex; i++) {
				if(empno.equals(emps.get(i).getEmpno())) {
					return i;
				}
			}
		}
		return -1;
	}
	/* (non-Javadoc)
	 * @see com.ssafy.model.dto.EmployeeDao#search(java.lang.String)
	 */
	@Override
	public Employee search(String empno) {
		int index = findIndex(empno);
		if(index > -1) {
			return emps.get(index);
		}else {
			return null;
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
	
	/* (non-Javadoc)
	 * @see com.ssafy.model.dto.EmployeeDao#add(com.ssafy.model.dto.Employee)
	 */
	@Override
	public void add(Employee emp) {
		System.out.println("Employee를 저장합니다.");
		if(emp != null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			if(index > -1) {
				System.out.println("이미 등록된 사원번호입니다.");
			}else {
				emps.add(emp);
			}
		}
	}
	/* (non-Javadoc)
	 * @see com.ssafy.model.dto.EmployeeDao#update(com.ssafy.model.dto.Employee)
	 */
	@Override
	public void update(Employee emp) {
		if(emp != null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			if(index > -1) {
				emps.set(index, emp);
			}else {
				System.out.println("수정할 사원번호가 등록되지 않았씁니다.");
			}
		}else {
			System.out.println("수정할 사원의 정보를 입력해 주세요.");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ssafy.model.dto.EmployeeDao#remove(java.lang.String)
	 */
	@Override
	public void remove(String empno) {
		int index = findIndex(empno);
		if(index > -1) {
			emps.remove(index);
		}else {
			System.out.println("삭제할 사원번호가 등록되지 않았습니다.");
		}
	}
	
	public void print() {
		for(Employee employee : emps){
			System.out.println(employee);
		}
	}
	
	public void close() {
		System.exit(0);
	}
	public List<Employee> serchAll(){
		return emps;
	}
	public void setEmployees(List<Employee> emps) {
		this.emps = emps;
	}
	
}
