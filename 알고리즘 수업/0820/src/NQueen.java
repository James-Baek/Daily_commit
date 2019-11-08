import java.util.Scanner;

public class NQueen {
	static int size, answer;
	static boolean[] col;
	static boolean[] slash;
	static boolean[] bSlash;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			size = sc.nextInt();
			answer = 0;
			col = new boolean[size+1];
			slash = new boolean[2*size+1]; // 좌하향
			bSlash = new boolean[2*size]; // 우하향
			tryQueen(1);
			System.out.printf("#%d %d\n", t, answer);
		}
	}
	static void tryQueen(int row) {
		if(row > size) {
			answer++;
			return;			
		}
		// 현재 행의 모든 열에 놓아보는 시도
		for(int i = 1; i <= size; ++i) {
			if(col[i] || slash[row+i] || bSlash[row-i+size]) continue; // 불가능한 상황
			col[i] = slash[row+i] = bSlash[row-i+size] = true;
			tryQueen(row+1);
			col[i] = slash[row+i] = bSlash[row-i+size] = false;
		}
	}

}
