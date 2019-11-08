package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3074ver2 {
	static int N, M;
	static Long[] line;
	
	public static Long binary_search(long lower, long upper) {
		long sum = 0;
		long mid = (lower + upper) / 2;
		
		for(int i = 0; i < N; i++) {
			sum += mid / line[i];
		}
		if(lower == upper) return lower;
		if(sum >= M) return binary_search(lower,mid);
		else return binary_search(mid+1,upper);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			line = new Long[N+1];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				line[i] = Long.parseLong(st.nextToken());
			}
			System.out.printf("#%d %d\n", t, binary_search(1, (long)1e18));
		}
	}
}
