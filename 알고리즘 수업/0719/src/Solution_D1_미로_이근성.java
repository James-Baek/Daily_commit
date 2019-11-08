import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
	// N*N 미로(좌표는 1,1부터)
	// 각 칸에는 동서남북으로 문이 있다
	// 밖으로 나올 수 있는 점퍼
	// 점퍼를 통해 밖으로 나왔거나 N*N칸을 벗어나면 좌표는 0,0으로 바뀜
	// 3 <= N <= 20
	// 출발점 좌표에서 제시된 이동 칸 수만큼 반복적으로 이동
	//////////////////입력/////////////////////
	// 첫 줄 Tc								//
	// 배열의 크기 N, 출발점 좌표, 점퍼의 개수			//
	// 점퍼의 좌표								//
	// 방향 지시의 개수							//
	// 방향,이동칸수(1: 상, 2: 우, 3: 하, 4: 좌)	//
	//////////////////////////////////////////
	// 출력 : 다음 목적지의 좌표
public class Solution_D1_미로_이근성 {
	
	static int N,x,y;	
	static int[][] map;
	static int move_num;
	static int[] dir,dx;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub			
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // N * N
			x = Integer.parseInt(st.nextToken()); // 출발점의 x좌표
			y = Integer.parseInt(st.nextToken()); // 출발점의 y좌표
			int J = Integer.parseInt(st.nextToken()); // 점퍼의 개수 
			
			map = new int[N+1][N+1];		
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < J; j++) { 
				int jx = Integer.parseInt(st2.nextToken());
				int jy = Integer.parseInt(st2.nextToken());
				map[jx][jy] = 9; // 점퍼 위치 설정
			}
			
			move_num = Integer.parseInt(br.readLine()); // 방향 지시 개수
			dir = new int[move_num];
			dx = new int[move_num];
			
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			for (int i = 0; i < move_num; i++) {
				dir[i] = Integer.parseInt(st3.nextToken()); //이동할 방향
				dx[i] = Integer.parseInt(st3.nextToken());  //이동할 거리
			}
			miro(tc);
		}
	}
	private static void miro(int tc) {
		// TODO Auto-generated method stub
		int nr,nc;
		
		int[] dirX = {-1,0,1,0};
		int[] dirY = {0,1,0,-1};
		
		// 방향,이동칸수(1: 상, 2: 우, 3: 하, 4: 좌)
		A:
			for (int i = 0; i < move_num; i++) {
				nr = x;
				nc = y;
				// 이동
				for (int j = 0; j < dx[i]; j++) {
					nr += dirX[dir[i] - 1]; 
					nc += dirY[dir[i] - 1];
					if(nr < 1 || nr > N || nc < 1 || nc > N 
							|| map[nr][nc] == 9)  { // 줄을 나누면 디버깅할 때 조건의 참거짓을 확인할 수 있다.
						x = y = 0;
						break A;
					}
				}
				x = nr;
				y = nc;
			}
		System.out.println("#" + tc + " "+ x + " " + y);		
	}

}
