package HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3812_호중이의큐브색칠_백창현_미완성 {
	static int X, Y, Z, A, B, C, N;
	static int[] ans;
	static long[] ax, ay, az, D2, D3;
	
	public static void color_num(long[] out, int a, int x, int n){
	    for (int i = 0; i < n; i++) {
	        out[i] = (a + 1) / n + (x - a) / n;
	        if (i < (a + 1) % n)
	            out[i]++;
	        if (i < (x - a) % n)
	            out[i]++;
	    }
	    out[0]--;
	}
	public static void product(long[] a, long[] b, long[] c, int n){
	    for (int i = 0; i < n; i++) {
	        int j = i;
	        long sum = 0;
	        for (int k = 0; k < n; k++) {
	            sum += a[j] * b[k];
	            if (j > 0)
	                j--;
	            else
	                j = j + n - 1;
	        }
	        c[i] = sum;
	    }
	}
	
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
			
			ax = new long[N];
			ay = new long[N];
			az = new long[N];
			D2 = new long[N];
			D3 = new long[N];

			color_num(ax, A, X, N);
	        color_num(ay, B, Y, N);
	        color_num(az, C, Z, N);
	        product(ax, ay, D2, N);
	        product(D2, az, D3, N);
	        
			System.out.print("#"+t+" ");
			for(int i = 0; i < N; i++) {
				System.out.print(D3[i]+" ");
			}
			System.out.println();
		}
	}

}
