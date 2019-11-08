import java.util.Arrays;
import java.util.Scanner;

public class DisjointSetTest {
	static int[] parents;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = sc.nextInt();
		
		parents = new int[N];
		
		//1.make set : 원소들 각각 개별적인 집합으로 만듦(즉, 자신이 루트노드가 되도록)
		Arrays.fill(parents, -1);
		
		for(int i = 0; i < count; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println(union(a,b));
		}
		System.out.println(find(0) + "//" +find(1));
		System.out.println(find(3) + "//" +find(4));
		System.out.println(find(2) + "//" +find(3));
	}

	private static boolean union(int a, int b) {
		// 2. find set : 자신이 속한 집합 찾기
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot) { // 3. union set : 두 노드의 집합이 다르면 합치기
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}

	private static int find(int a) {
		if(parents[a] < 0) return a;  // 루트노드면 자신의 번호 리턴
		// 루트노드가 아니면 부모노드 따라가서 루트노드 알아온다.
		// path compression : 리턴받은 루트노드의 값으로 자신의 부모로 갱신
		return parents[a] = find(parents[a]);
	}
	

}
