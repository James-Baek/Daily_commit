package com.ssafy.model.dao;

import java.util.List;

import com.ssafy.model.dto.Employee;
import com.ssafy.view.CanNotFoundException;
import com.ssafy.view.DuplicateException;

public interface EmployeeDao {
	/**
	 * 사원번호에 해당한  사원을 찾아서 정보를 리턴하는 기능의 함수 
	 * @param empno
	 * @return
	 */
	Employee search(String empno) throws CanNotFoundException;

	/**
	 * 사원 정보를 등록하는 기능
	 * @param emp
	 */
	void add(Employee emp) throws DuplicateException;

	/**
	 * 사원 정보를 수정하는 기능 
	 * @param emp
	 */
	void update(Employee emp) throws CanNotFoundException;

	/**
	 * 사원정보를 삭제하는 기능
	 * @param empno
	 */
	void remove(String empno) throws CanNotFoundException;

	void close();
	
	List<Employee> searchAll();
}


