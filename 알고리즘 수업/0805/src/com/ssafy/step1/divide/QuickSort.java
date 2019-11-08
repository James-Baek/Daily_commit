package com.ssafy.step1.divide;

import java.util.Arrays;

public class QuickSort {
	static int[] num = {2,9,6,8,10,3,11,15,1};
	
	public static void swap(int from, int to) {
		int temp = num[from];
		num[from] = num[to];
		num[to] = temp;
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
		int pivot, left, right, temp;
		pivot = begin;
		left = begin + 1;
		right = end;
		
		do {
			// left : 피봇보다 같거나 큰 값 찾아 움직임(작으면 계속 오른쪽으로...)
			while(left < end && list [left] < list[pivot]) left++;
			// right : 피봇보다 작은 값 찾아 움직임(같거나 크면 계속 왼쪽으로...)
			while(right>begin && list[right] >= list[pivot]) right--;
			
			if(left < right) {
				temp = list[left];
				list[left] = list[right];
				list[right] = temp;
			}
			
		}while(left < right);

		temp = list[pivot];
		list[pivot] = list[right];
		list[right] = temp;
		
		return right;
	}
	
	public static void main(String[] args) {
		int[] list = {69,10,30,2,16,8,31,22};
		System.out.println(Arrays.toString(list));
		
		
	}

}
