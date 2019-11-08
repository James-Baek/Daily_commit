import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_3812 {
	static int X, Y, Z, A, B, C, N;
	static int[] ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			Z = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			ans = new int[N];
			
			for(int i = 0 ; i < X; i++) {
				for(int j = 0; j < Y; j++) {
					for(int k = 0; k < Z; k++) {
						int temp = (Math.abs(i-A) + Math.abs(j-B) + Math.abs(k-C)) % N;
						
						ans[temp]++;
					}
				}
			}
			
			System.out.print("#"+t+" ");
			for(int i = 0; i < N; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
		}
		
	}
}
