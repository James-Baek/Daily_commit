package SWEA;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SWEA5672 {
	static int N;
	static int l_pivot;
	static int r_pivot;
	static Deque<Character> bird;
	static String ans;
	
	public static void findPivot() {
		char left = bird.peekFirst();
		char right = bird.peekLast();
		Deque<Character> leftD = new LinkedList<Character>();
		Deque<Character> rightD = new LinkedList<Character>();
		l_pivot = 0;
		r_pivot = 0;
		
		if(bird.size() == 1) {
			ans += bird.pollFirst();
			return;
		}else if(bird.size() == 2) {
			if(left > right) {
				ans += bird.pollLast();
				ans += bird.pollFirst();
			}else {
				ans += bird.pollFirst();
				ans += bird.pollLast();
			}
			return;
		}
		while(true) {
			left = bird.peekFirst();
			right = bird.peekLast();
			if(left == right) {
				leftD.offerLast(bird.pollFirst());
				rightD.offerFirst(bird.pollLast());
				left = bird.peekFirst();
				right = bird.peekLast();
				if(leftD.peekFirst() < left) {
					ans += leftD.pollFirst();
				}else {
					l_pivot++;
				}
				if(rightD.peekLast() < right) {
					ans += rightD.pollLast();
				}else {
					r_pivot++;
				}
			}else if(left > right) {
				while(true) {
					right = bird.peekLast();
					if(left > right) {
						rightD.offerFirst(bird.pollLast());
						r_pivot++;
					}else {
						break;
					}
				}
				break;
			}else if(left < right) {
				while(true) {
					left = bird.peekFirst();
					if(left < right) {
						leftD.offerLast(bird.pollFirst());
						l_pivot++;
					}else {
						break;
					}
				}
				break;
			}
		}
	
		
		int min = l_pivot < r_pivot ? l_pivot : r_pivot;
		if(l_pivot > r_pivot) {
			while(!leftD.isEmpty()) {
				ans += leftD.pollFirst();
			}
			while(!rightD.isEmpty()) {
				ans += rightD.pollLast();
			}
		}else {
			while(!rightD.isEmpty()) {
				ans += rightD.pollLast();
			}
			while(!leftD.isEmpty()) {
				ans += leftD.pollFirst();
			}
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			ans = "";
			N = sc.nextInt();
			sc.nextLine();
			bird = new LinkedList<Character>();
			l_pivot = 0;
			r_pivot = 0;
			
			for(int i = 0; i < N; i++) {
				String name = sc.nextLine();
				bird.offer(name.charAt(0));
			}
			
			while(!bird.isEmpty()) {
				char left = bird.peekFirst();
				char right = bird.peekLast();
				
				if(left > right) {
					ans += bird.pollLast();
					continue;
				}else if(left < right) {
					ans += bird.pollFirst();
					continue;
				}
				if(left == right) {
					findPivot();
				}
			}
			System.out.printf("#%d %s\n", t, ans);
		}
		
	}

}
