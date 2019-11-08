package com.ssafy.model.dto;

public class StringTest {

	public static void main(String[] args) {
		/**
		 * String은 유일하게 new 생성자(~)를 통하지 않아도 객체를 생성할 수 있다.
		 * - new 생성자(~) : 매번 heap에 객체가 생성도니다.
		 * - new 생성자(~)를 사용하지 않은 경우 : Constance Pool에 없으면 생성하고 있는 경우 해당 객체의 참조값만 전달 받는다.
		 * String은 클래스로 유일하게  + 연산을 허용
		 *  문자열 + anyType = 문자열
		 */
		String str1 = "hello";
		String str2 = "hello";
		String str3 = new String("hello");
		String str4 = new String("hello");
		
		System.out.printf("str1 == str2 : %b \n", str1 == str2);
		System.out.printf("str1 == str3 : %b \n", str1 == str3);
		System.out.printf("str3 == str4 : %b \n", str3 == str4);
		
		str1 += "world";
		str1 += 256;
		str1 += new Employee("1", "ssafy", 100);
		System.out.println(str1);
		
		StringBuffer sb1; // 싱크로나이징 함. 느림.
		StringBuilder sb2; // 싱크로나이징 안 함. 빠름.
		
		/**
		 * public String[] split(String 구분자)
		 * 문자열을 구분자를 기준으로 subString하는 기능
		 */
		
		String[] tokens = "hello world java ssafy".split(" ");
		for(String token : tokens) {
			System.out.println(token);
		}
		
		/**
		 * format(String format, Object ...o)
		 * %s : 문자열
		 * %d : 정수
		 * %f : 실수
		 * %b : 논리
		 * %c : 문자
		 * 
		 */
		String str = String.format("%d번 사원번호", 1);
		System.out.println(str);
	}

}
