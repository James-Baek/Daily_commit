import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D1_로봇_이근성 {
	// A : 우
	// B : 좌,우
	// C : 상,하,좌,우
	// 벽을 만나면 멈추고, 다른 로봇이 있던 초기 위치를 못넘어감
	// 이동위치는 0부터 시작, 3<= N <=20
	//////////////////입력/////////////////////
	// 첫 줄 Tc								//
	// 배열의 크기 N								//
	// 각 배열의 값(S : 공백, W : 벽, A,B,C :로봇)	//
	//////////////////////////////////////////
	// 출력 : 모든 로봇의 이동거리 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
				int N = Integer.parseInt(br.readLine()); // N*N
				int dist = 0; // 모든 로봇의 이동 거리
				String[][] robot = new String[N][N];
				
				
				for (int i = 0; i < N; i++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					for (int j = 0; j < N; j++) {
						robot[i][j] = st.nextToken();
					}
				}
				int[] dirR = {-1,1,0,0};
				int[] dirC = {0,0,-1,1};
				int nr,nc; // new row, new column
				
				for (int i = 0; i < robot.length; i++) {
					for (int j = 0; j < robot[i].length; j++) {
						if(robot[i][j].equals("A")) { // A로봇이면
							nr = i;
							nc = j;
							while(true) {
								nc += dirC[3]; // 오른쪽으로
								if(nr < 0 || nr >= N || nc < 0 || nc >= N) break; // index를 넘어가면 break 
								if(!robot[nr][nc].equals("S")) // 다음 index가 빈칸이 아니면
									break;
								dist++; // 이동거리를 추가
							}
						}
						if(robot[i][j].equals("B"))// B로봇이면
							for (int k = 2; k < dirC.length; k++) {
								nr = i;
								nc = j;
								while(true) {
									nc += dirC[k]; // 좌,우로
									if(nr < 0 || nr >= N || nc < 0 || nc >= N) break; // index를 넘어가면 break
									if(!robot[nr][nc].equals("S")) // 다음 index가 빈칸이 아니면
										break;
									dist++; // 이동거리를 추가
								}
							}
						if(robot[i][j].equals("C")) {
							for (int k = 0; k < dirC.length; k++) {
								nr = i;
								nc = j; 
								while(true) {
									nr += dirR[k];
									nc += dirC[k]; // 상,하,좌,우
									if(nr < 0 || nr >= N || nc < 0 || nc >= N) break; // index를 넘어가면 break
									if(!robot[nr][nc].equals("S")) // 다음 index가 빈칸이 아니면
										break;
									dist++; // 이동거리를 추가
								}
							}
						}
					}
				}
				
				System.out.println("#"+tc + " " + dist);
		}
	}

}
