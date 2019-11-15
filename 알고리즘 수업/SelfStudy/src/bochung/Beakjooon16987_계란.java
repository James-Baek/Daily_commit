package bochung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjooon16987_계란 {

	private static int N;
	private static int[] s;
	private static int[] w;
	private static int maxCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 계란의 개수 N (1 <= N <= 8)
		StringTokenizer st;
		
		s = new int[N]; // 내구도
		w = new int[N]; // 무게
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			s[i] = Integer.parseInt(st.nextToken()); // 계란의 내구도 1 <= s <= 300
			w[i] = Integer.parseInt(st.nextToken()); // 계란의 무게 1 <= w <= 300
		}
		maxCnt = 0; // 깨진 계란의 최대값
		dfs(0,0);
		System.out.println(maxCnt);
		
	} // end of main

	/** 
	 *  index 번째의 계란을 하나 들어서 다른 (깨지지 않은)계란을 타격한다. cnt : 현재까지 깨진 개수
	 */
	private static void dfs(int index, int cnt) {
		// 계란이 0,1개 남았으면 최대값 업데이트 후 리턴
		if(s[index] <= 0) {
			dfs(index+1, cnt);
			return;
		}
// 재귀 파트
		// index 번째꺼 계란이 깨져있으면 다음턴으로 넘어감 재귀호출
	// 반복문
		for(int i = 0; i < N; i++) {
			if(i == index) continue; // 자기계란으로 자기를 깰 수 없음
			if(s[i] <= 0) continue; // 내구도가 0 이하 : 깨진 계란은 때릴수 없음 다음으로 넘어감
			// 계란을 index꺼 들어 나머지 다른 계란을 내리침
			// 		부딪힌 계란이 서로 무게만큼 내구도가 깎임 i, index
			s[i] -= w[index];
			s[index] -= w[i];
			//		내구도가 0 이하가 되면 깨진계란임
			int tempCnt = 0;
			if(s[i] <= 0) tempCnt++; // 깨졌니?
			if(s[index] <=0) tempCnt++; // 깨졌니?
			//		재귀호출 다음턴 index+1, cnt+이번에 깨진개수
			dfs(index+1, cnt+tempCnt);
			//		다음 턴을 위해서 변경했던 값을 원복시킴 (내구도를 다시 + 복구)
			s[i] += w[index];
			s[index] += w[i];
		}
	}
	

} // end of class
