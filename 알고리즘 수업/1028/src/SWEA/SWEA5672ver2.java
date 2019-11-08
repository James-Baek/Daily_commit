package SWEA;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SWEA5672ver2 {
	static int N;
	static int l_pivot;
	static int r_pivot;
	static ArrayList<Character> bird;
//	static String ans;
	static Deque<Character> ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
//			ans = "";
			N = sc.nextInt();
			sc.nextLine();
			bird = new ArrayList<Character>();
			ans = new LinkedList<Character>();
			
			for(int i = 0; i < N; i++) {
				String name = sc.nextLine();
				bird.add(name.charAt(0));
			}
			
			if(bird.size() % 2 == 0) {
				l_pivot = bird.size()/2 - 1;
				r_pivot = bird.size()/2;
			}else {
				l_pivot = bird.size()/2;
				r_pivot = bird.size()/2;
			}
			
			System.out.printf("#%d %s\n", t, ans);
		}
	}

}
