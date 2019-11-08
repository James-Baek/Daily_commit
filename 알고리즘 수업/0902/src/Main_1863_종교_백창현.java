import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1863_종교_백창현 {
	static int[] root;
	static boolean[] visited;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		root = new int[N+1];
		cnt = 0;
		
		if(N == 1) {
			System.out.println(1);
			return;
		}
		if(M == 0) {
			System.out.println(N);
			return;
		}
		
		Arrays.fill(root, -1);
		for(int i = 0; i < M; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a,b);
		}
		
		for(int r = 0; r < root.length; r++) {
			if(root[r] == -1 ) {
				cnt++;
			}
		}
		
		
		System.out.println(cnt-1);
	}
	
	public static boolean union(int a, int b) {
		// 2. find set : 자신이 속한 집합 찾기
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot) { // 3. union set : 두 노드의 집합이 다르면 합치기
			root[bRoot] = aRoot;
			return true;
		}
		return false;
	}
	
	public static int find(int a) {
		if(root[a] < 0) return a;  // 루트노드면 자신의 번호 리턴
		// 루트노드가 아니면 부모노드 따라가서 루트노드 알아온다.
		// path compression : 리턴받은 루트노드의 값으로 자신의 부모로 갱신
		return root[a] = find(root[a]);
	}
}
