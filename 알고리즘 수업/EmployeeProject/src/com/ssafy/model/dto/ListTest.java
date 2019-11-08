package com.ssafy.model.dto;
import java.util.*;

/**
 * - 저장한 순서대로 저장된다.
 * - index는 0번부터 size() -1 까지
 * - 중복 저장이 됨.
 * - 중간 갑일할 경우 0번부터 size() 까지
 * 	 범위를 벗어나면 IndexOutOfBoundsException발생
 *
 */
public class ListTest {

	public static void main(String[] args) {
//		ArrayList arr = new ArrayList();
		LinkedList arr = new LinkedList<Integer>();
		
		arr.add("hello");
		arr.add("hello");
		arr.add(256);
		arr.add(3.14);
		arr.add(new Employee("1","ssafy", 100));
		arr.add(3, true);
//		arr.add(7, true); // IndexOutOfBoundsException
		System.out.println(arr);
		
//		get(int index) : index번째 해당하는 데이터 추출
		System.out.println("3's index : "+arr.get(3));
		
		/**
		 * indexOf(Object o), lastIndexOf(object o), contains(Object o), remove(Object o) 함수는
		 * 해당 기능을 수행하기 위해 equals(Object o)를 호출해서 객체 비교한다.
		 */
		int index = arr.indexOf(new Employee("1", "ssafy", 100));
		System.out.println("index : "+ index);
		
		/**
		 * java5부터 Collection에 Generic을 적용
		 * - 생성할때 지정한 type만 저장한다.
		 * - 추출시 형변환을 할 필요가 없다.
		 */
		
		ArrayList<Employee> emps = new ArrayList<Employee>();
		emps.add(new Employee("1", "ssafy", 300));
		emps.add(new Manager("2", "홍길동", 300, "대리"));
		
		Employee emp = emps.get(0);
		System.out.println(emp);
	}

}
