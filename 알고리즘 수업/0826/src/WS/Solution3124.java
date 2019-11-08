package WS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution3124 {
	static int[] root;
	static int[][] vertex;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= t; t++) {
			long ans = 0;
			int V = sc.nextInt();
			int E = sc.nextInt();
			vertex = new int[E][3];
			root = new int[V+1];
			Arrays.fill(root, -1);
			int cnt = 0;
			
			for(int i = 0; i < E; i++) {
				vertex[i][0] = sc.nextInt();
				vertex[i][1] = sc.nextInt();
				vertex[i][2] = sc.nextInt();
			}
			
			Arrays.sort(vertex, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					
					return o1[2] > o2[2] ? 1 : -1;
				}
			});
			
			for(int i = 0; i < E; i++) {
				if(union(vertex[i][0], vertex[i][1])) {
					ans += vertex[i][2];
					cnt++;
				}
				if(cnt == V-1) break;
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) {
			return false;
		}else {
			root[bRoot] = aRoot; // bRoot 루트 aRoot로 변경
			return true;
		}
	}

	private static int find(int a) {
		if(root[a] < 0) return a;  // 루트노드면 자신의 번호 리턴
		// 루트노드가 아니면 부모노드 따라가서 루트노드 알아온다.
		// path compression : 리턴받은 루트노드의 값으로 자신의 부모로 갱신
		return root[a] = find(root[a]);
	}
}
