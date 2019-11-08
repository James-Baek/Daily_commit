package com.ssafy.model.dto;

import java.util.HashSet;

/**
 * Set
 * - 데이터 중복을 허용하지 않음
 * - 저장한 순서대로 저장되지 않음
 * - index가 없음
 * - add(Object o), contains(Object o), remove(Object o)에서  데이터가 중복됐는지 확인하기 위해 equals(Object o)와 hashCode()를 호출한다.
 */
public class SetTest {

	public static void main(String[] args) {
		HashSet<Object> set = new HashSet<Object>();
		System.out.println(set.add("hello"));
		System.out.println(set.add("hello"));
		System.out.println(set.add(256));
		System.out.println(set.add(3.14));
		System.out.println(set.add(new Employee("1", "ssafy", 300)));
		System.out.println(set.add(new Employee("1", "ssafy", 300)));
		System.out.println(set);
		
		for(Object obj : set) {
			System.out.println(obj);
		}
	}

}
