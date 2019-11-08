import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SWEA5644무선충전 {
	static int max;
	static int M, A; //이동 시간, BC 개수
	static int[] a;
	static int[] b;
	
	static int[] a_ans;
	static int[] b_ans;
	
				// 0가만히, 1상, 2우, 3하, 4좌
	static int[] dr = {0,-1,0,1,0}; 
	static int[] dc = {0,0,1,0,-1};
	
	//충전소
	static int[][] BC;
	
	//지도
	static int[][] map;
	static int[][] visited;
	
	static int ans;
	
	public static void charging(int cnt, int ar, int ac, int br, int bc) {
		int adist = 0;
		int bdist = 0;
		
		int aBC = -1;
		int bBC = -1;
		
		ArrayList<Integer> aList = new ArrayList<Integer>();
		ArrayList<Integer> bList = new ArrayList<Integer>();
		
		for(int i = 0; i < A; i++) {
			int temp_a = Math.abs(BC[i][0] - ar) + Math.abs(BC[i][1] - ac);
			int temp_b = Math.abs(BC[i][0] - br) + Math.abs(BC[i][1] - bc);
			if( temp_a <= BC[i][2]) {
				aList.add(BC[i][3]);
				if(adist < BC[i][3]) {
					adist = BC[i][3];
					aBC = i;
				}
			}
			if( temp_b <= BC[i][2]) {
				bList.add(BC[i][3]);
				if(bdist < BC[i][3]) {
					bdist = BC[i][3];
					bBC = i;
				}
			}
		}
		
		aList.sort(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return -1*Integer.compare(o1, o2);
			}
		});
		bList.sort(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return -1*Integer.compare(o1, o2);
			}
		});
		
		if(aBC == -1 || bBC == -1) {
			
		}else if(aBC == bBC && aBC != -1 && bBC != -1) {
			if(aList.size() > bList.size()) {		
				if(bList.size() != 0) {
					adist = aList.get(1);
				}else {
					
				}
			}else if(aList.size() < bList.size()){
				adist /= 2;
				bdist /= 2;
			}
		}
		ans += adist;
		ans += bdist;
		a_ans[cnt] = adist;
		b_ans[cnt] = bdist;
	}
	
	public static void move() {
		int ar = 0;
		int ac = 0;
		
		int br = 9;
		int bc = 9;
		visited[ar][ac] = 1;
		visited[br][bc] = 1;
		charging(0, ar, ac, br, bc);
		
		for(int i = 0; i < M; i++) {
			ar += dr[a[i]];
			ac += dc[a[i]];
			br += dr[b[i]];
			bc += dc[b[i]];
			visited[ar][ac] = 1;
			visited[br][bc] = 1;
			charging(i+1, ar, ac, br, bc);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			max = 0;
			M = sc.nextInt();
			A = sc.nextInt();
			
			a = new int[M];
			b = new int[M];
			a_ans = new int[M+1];
			b_ans = new int[M+1];
			
			BC = new int[A][4];
			for(int i = 0; i < M; i++) {
				a[i] = sc.nextInt();
			}
			for(int i = 0; i < M; i++) {
				b[i] = sc.nextInt();
			}
			
			for(int i = 0; i < A; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				int cover = sc.nextInt();
				int perfo = sc.nextInt();
				
				BC[i][0] = c - 1;
				BC[i][1] = r - 1;
				BC[i][2] = cover;
				BC[i][3] = perfo;
			}
			// 인풋 끝
			
			map = new int[10][10];
			visited = new int[10][10];
			ans = 0;
			
			move();
			
			System.out.printf("#%d %d\n", t, ans);
		}
	}

}
