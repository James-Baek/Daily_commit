package com.ssafy.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArraySortTest {
	static class IntComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {

			return -(o1-o2);
		}
	}
	
	static class STComparator implements Comparator<Student>{
		@Override
		public int compare(Student o1, Student o2) {
			if(o1.getAge() < o2.getAge()) return -1;
			return 0;
		}
	}
	public static void main(String[] args) {
		int[] arr = {2,40,3,2,10};
		Student st1 = new Student("endy",10,20,1);
		Student st2 = new Student("call",15,90,2);
		Student st3 = new Student("mice",21,100,3);
		Student st4 = new Student("james",17,60,1);
		Student st5 = new Student("cook",12,70,1);
		Student st6 = new Student("any",16,30,1);
		
		ArrayList<Student> st_arr = new ArrayList<Student>();
		
		st_arr.add(st1);
		st_arr.add(st2);
		st_arr.add(st3);
		st_arr.add(st4);
		st_arr.add(st5);
		st_arr.add(st6);

		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		Integer[] arr2 = {2,40,3,2,10};
		Arrays.sort(arr2, new IntComparator());
		System.out.println(Arrays.toString(arr2));
		Collections.sort(st_arr, new STComparator());
		System.out.println(st_arr);
		for(Student temp : st_arr) {
			System.out.print(temp.getMath()+" ");
		}
	}
}
