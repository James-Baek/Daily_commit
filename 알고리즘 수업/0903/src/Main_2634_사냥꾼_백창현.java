import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_2634_사냥꾼_백창현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] hunter = new int[M];
		int[][] target = new int[N][2];
		int cnt = 0;
		
		st = new StringTokenizer(br.readLine());
//		HashMap<Integer,ArrayList<Integer>> hm = new HashMap<Integer,ArrayList<Integer>>();
//		for(int i = 0; i < M; i++) {
//			int temp = Integer.parseInt(st.nextToken());
//			ArrayList<Integer> chaning = hm.get(temp%3);
//			if(chaning == null) {
//				ArrayList<Integer> ch = new ArrayList<Integer>();
//				ch.add(temp);
//				hm.put(temp%3, ch);
//			}else {
//				chaning.add(temp);
//				hm.put(temp%3, chaning);
//			}
//		}
//		
		for(int i = 0; i < M; i++) {
			hunter[i] = Integer.parseInt(st.nextToken());
		}
//		Arrays.sort(hunter);
//		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
//			ArrayList<Integer> chaning = hm.get(x%3);
//			if(chaning == null) {
//				
//			}
			
			if(y > L) break;
			for(int j = 0; j < M; j++) {
				if(Math.abs(hunter[j] - x) + y <= L) {
					cnt++;
					break;
				}
			}
		}
//		Arrays.sort(target, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return Integer.compare(o1[0], o2[0]);
//			}
//		});
		
		System.out.println(cnt);
	}

}
