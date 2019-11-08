package com.ssafy.model.dto;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		HashMap<Integer, Object> map1 = new HashMap<>();
		/**
		 * put(key, value) : 데이터 추가
		 */
		map1.put(1, "hello");
		map1.put(2, new Employee("1", "1", 1));
		map1.put(1, "world");
		System.out.println(map1);
		System.out.println(map1.get(2));
		
		//keySet() : map에 저장된 key값만 추출
		Set<Integer> keys = map1.keySet();
		for(Integer key : keys) {
			System.out.println(key);
		}
		
		//values() : map에 저장된 value값만 추출
		Collection<Object> values = map1.values();
		for(Object value : values) {
			System.out.println(value);
		}
	}

}
