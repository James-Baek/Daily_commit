package com.ssafy.model.dto;

public interface EmployeeDao {

	/**
	 * 사원번호에 해당하는 사원정보가 저장된 배열의 index를 리턴
	 * @param empno 찾을 사원 번호
	 * @return  사원번호에 해당하는 사원이 저장된 index를 리턴
	 * 			못 찾을 경우 -1을 리턴
	 */

	int findIndex(String empno);

	/**
	 * 다형성을 리턴타입에 적용
	 * 다형성에 의해 모든 sub 타입은 super으로 형변환이 자동으로 되기 때문에
	 * 리턴타입을 super로 선언하면 sub도 리턴할 수 있다.
	 * public Employee getEmployee(){
	 * 	return new Manger();
	 * }
	 * 
	 */
	Employee search(String empno);

	/**
	 * 
	 * @param emp
	 */
	void add(Employee emp);

	void update(Employee emp);

	void remove(String empno);

}