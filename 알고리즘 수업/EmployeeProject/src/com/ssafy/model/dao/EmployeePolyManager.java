package com.ssafy.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.model.dto.Employee;
import com.ssafy.view.CanNotFoundException;
import com.ssafy.view.DuplicateException;

public class EmployeePolyManager implements EmployeeDao {
	/**
	 * 다형성을 배열에 적용 
	 * 다형성에 의해 모든 sub 타입은 super으로 형변환이 자동으로 되기 때문에 
	 * Super타입의 배열 하나만 선언하면 sub타입의 객체도 저장할 수 있다. 
	 */
	private List<Employee> emps;
	private String fileName = "employee.dat";
	
	public EmployeePolyManager() {
//		emps = new LinkedList<Employee>();
		load();
	}
	
	public void load() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		File file = null;
		try {
			file = new File(fileName);
			// exists() : 지정한 경로에 파일이 있으면 true, 없으면 false
			if(file.exists() && file.canRead()) {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				emps = (List)ois.readObject();
			}else {
				emps = new LinkedList<Employee>();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ois != null) try {ois.close();} catch(Exception e) {}
			if(fis != null) try {fis.close();} catch(Exception e) {}
		}
		
	}
	public int findIndex(String empno) {
		if(empno !=null) {
			for (int i = 0, size = emps.size(); i < size; i++) {
				if(empno.equals(emps.get(i).getEmpno())) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public Employee search(String empno) throws CanNotFoundException {
		int index = findIndex(empno);
		if(index > -1) {
			return emps.get(index);
		}else {
			String msg = String.format("%s번 사원번호는 등록되지 않았습니다.", empno);
			throw new CanNotFoundException(msg);
		}
	}
	
	public void add(Employee emp) throws DuplicateException{
		System.out.println("Employee를 저장합니다.");
		if(emp != null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			if(index > -1) {
				String msg = String.format("%s번 사원번호는 이미 등록된 사원번호입니다.", empno);
				throw new DuplicateException(msg);
			}else {
				emps.add(emp);
			}
		}else {
			throw new DuplicateException("등록할 사원 정보를 입력해 주세요.");
		}
	}
	public void update(Employee emp) throws CanNotFoundException {
		if(emp !=null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			if(index>-1) {
				emps.set(index, emp);
			}else {
				System.out.println("수정할 사원번호가 등록되지 않았습니다.");
				String msg = String.format("%s번 사원번호는 등록되지 않았습니다.", empno);
				throw new CanNotFoundException(msg);
			}
		}else{
			System.out.println("수정할 사원의 정보를 입력해 주세요");
		}
	}
	public void remove(String empno) {
		int index = findIndex(empno);
		if(index > -1) {
			emps.remove(index);
		}else {
			System.out.println("삭제할 사원번호가 등록되지 않았습니다.");
		}
	}
	public void save() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(emps);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(oos!=null)try {oos.close();}catch(Exception e) {}
			if(fos!=null)try {fos.close();}catch(Exception e) {}
		}
	}
	public void print() {
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}
	public void close() {
		save();
		System.exit(0);
	}
	public List<Employee> searchAll() {
		return emps;
	}
	public void setEmployees(List<Employee> emps) {
		this.emps = emps;
	}
}




























