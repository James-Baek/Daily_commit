package WS;

import java.util.Scanner;

public class WS1_친구관계_백창현 {
	static boolean[][] map;
	static boolean[] visited;
	static int V;
	static int E;
	static int max;
	static String ans;
	public static void sendMSG(int idx, int cnt, String txt) {
		if(max < cnt) {
			ans = txt;
			max = cnt;
		}
		for(int i = 0; i < V; i++) {
			if(map[idx][i]) {
				if(visited[idx]) continue;
				visited[idx] = true;
				sendMSG(i, cnt+1,txt+(char)('A'+idx)+"에서 "+(char)('A'+i)+"로 전달\n");
				visited[idx] = false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		map = new boolean[V][V];
		visited = new boolean[V];
		max = 0;
		ans = "";
		for(int i = 0; i < E; i++) {
			char tempA = sc.next().charAt(0);
			char tempB = sc.next().charAt(0);
			int r = tempA - 'A';
			int c = tempB - 'A';
			map[r][c] = true;
			map[c][r] = true;
		}
		
		sendMSG(0,0,"");
		System.out.println(max);
		System.out.println(ans);
	}

}
