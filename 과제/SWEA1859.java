package ssafy;

import java.util.*;

public class SWEA1859 {	
	static int max;
	static int maxidx;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Stack<Integer> st = new Stack<Integer>();
		int T = Integer.parseInt(sc.nextLine());

		for(int t = 1; t <= T; ++t) {
			max = 0;
			maxidx = 0;
			
			long ans = 0;
			int N = Integer.parseInt(sc.nextLine());
			Integer[] num = new Integer[N];
			String[] input = sc.nextLine().split(" ");
			
			for(int i = 0; i < input.length; i++) {
				num[i] = Integer.parseInt(input[i]);
				if(max < num[i]) {
					max = num[i];
					maxidx = i;
				}
			}

			for(String temp : input) {
				int n = Integer.parseInt(temp);
				if(st.isEmpty()) {
					st.push(n);
				}else {
					if(st.peek() > n && st.peek() >= max) {
						int top = st.pop();
						while(!st.isEmpty()) {
							ans += (top-st.pop());
						}
						find(num);
					}
					st.push(n);
				}
			}
            if(!st.isEmpty()){
			int top2 = st.pop();
			while(!st.isEmpty()) {
				int temp = st.pop();
				if(top2 < temp) {
					break;
				}
				ans += (top2-temp);
			}
            }
			System.out.printf("#%d %d\n", t, ans);
		}
	}
	
	public static void find(Integer[] num) {		
		Integer[] nextnum = new Integer[num.length - maxidx -1];
		max = 0;
		for(int i = maxidx+1; i < num.length; i++) {
			if(max < num[i]) {
				max = num[i];
				maxidx = i;
			}
		}
	}
}
