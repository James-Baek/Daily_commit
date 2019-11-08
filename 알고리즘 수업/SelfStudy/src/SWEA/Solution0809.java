package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution0809 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int ans = 0;
			int N = Integer.parseInt(br.readLine());
			int limit = N/2;
			for(int i = 0; i < N; i++) {
				char[] row = br.readLine().toCharArray();
				for(int j = Math.abs(limit); j < N-Math.abs(limit); j++) {
					ans += Integer.parseInt(row[j]+"");
				}
				limit = limit - 1;
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}

}
