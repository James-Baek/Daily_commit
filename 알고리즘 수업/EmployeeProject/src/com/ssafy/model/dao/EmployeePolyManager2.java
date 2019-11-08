package com.ssafy.model.dao;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import com.ssafy.model.dto.Employee;
public class EmployeePolyManager2 implements EmployeeDao {
	/**
	 * 다형성을 배열에 적용 
	 * 다형성에 의해 모든 sub 타입은 super으로 형변환이 자동으로 되기 때문에 
	 * Super타입의 배열 하나만 선언하면 sub타입의 객체도 저장할 수 있다. 
	 */
	private HashMap<String, Employee> emps;
	public EmployeePolyManager2() {
		emps = new HashMap<String, Employee>();
	}
	
	public Employee search(String empno) {
		Employee emp = emps.get(empno);
		if(emp == null) {
			return null;    //exception을 던질 예정 
		}else {
			return emp;
		}
	}
	public void add(Employee emp) {
		if(emp != null) {
			String empno = emp.getEmpno();
			Employee find = emps.get(empno);
			if(find !=null) {
				System.out.println("이미 등록된 사원번호입니다.");
			}else {
				emps.put(empno, emp);
			}
		}
	}
	public void update(Employee emp) {
		if(emp !=null) {
			String empno = emp.getEmpno();
			Employee find = emps.get(empno);
			if(find !=null) {
				System.out.println("수정할 사원번호가 등록되지 않았습니다.");
			}else {
				emps.put(empno, emp);
			}
		}else{
			System.out.println("수정할 사원의 정보를 입력해 주세요");
		}
	}
	public void remove(String empno) {
		Employee find = emps.get(empno);
		if(find !=null) {
			System.out.println("삭제할 사원번호가 등록되지 않았습니다.");
		}else {
			emps.remove(empno);
		}
	}
	public void print() {
		for (Employee employee : emps.values()) {
			System.out.println(employee);
		}
	}
	public void close() {
		System.exit(0);
	}
	public List<Employee> searchAll() {
		return (List)emps.values();
	}
	public void setEmployees(List<Employee> emps) {
		for (Employee emp : emps) {
			this.emps.put(emp.getEmpno(), emp);
		}
	}
}




























