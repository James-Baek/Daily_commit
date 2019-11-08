package com.ssafy.step3.sort;

import java.util.Arrays;

public class QuickSort {
	static int[] num = {2,9,6,8,10,3,11,15,1};
	
	public static void swap(int[] list, int from, int to) {
		int temp = list[from];
		list[from] = list[to];
		list[to] = temp;
	}
	
//	public static void quick(int L, int R) {
//		if(R == L) return; // 집합의 크기 1
//		
//		int[] result = new int[num.length];
//		int pivot = 0;
//		boolean lF = false;
//		boolean rF = false;
//		
//		while(L<R) {
//			if(num[L] < num[pivot]) L++;
//			else lF = true;
//			if(num[R] > num[pivot]) R++;
//			else rF = true;
//			
//			if(lF & rF) {
//				swap(R,L);
//				break;
//			}
//		}
//	}
	
	public static int fixPivot(int[] list, int begin, int end) {
		int i, j, pivot;
		i=j=begin;
		pivot=end;
		while(j < end) {
			if(list[j] <= list[pivot]) {
				swap(list, i++, j);
			}
			++j;
		}
		swap(list, i,pivot);
		return i;
	}

	public static void main(String[] args) {
		int[] list = {69,10,30,2,16,8,31,22};
		System.out.println(Arrays.toString(list));
		fixPivot(list,0,num.length-1);
		
		System.out.println(Arrays.toString(list));
		
	}

}
