import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B17472_다리만들기2_정구헌 {
	static int N, M;
	static int[][] map;
	static boolean[][] bMap;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };// 상하좌우

	static class Edge implements Comparable<Edge> {
		int from, to, len;

		Edge(int f, int t, int l) {
			this.from = f;
			this.to = t;
			this.len = l;
		}

		@Override
		public int compareTo(Edge o) {
			int res = this.len - o.len;
			if (res == 0)
				res = this.from - o.from;
			return res;
		}

		public String toString() {
			return "(" + from + "," + to + "," + len + ")";
		}
	}

	static ArrayList<Edge> edgeInfo;
	static int[][] edgeMap;
	static int cnt;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		bMap = new boolean[N][M];
		edgeInfo = new ArrayList<Edge>();

		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 섬 체크하기
		cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				if (map[i][j] == 1)
					bfs(i, j);
		}

		int V = cnt;
		parents = new int[V + 1];
		Arrays.fill(parents, -1);
		// 다리를 만들자
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (bMap[i][j]) {
					makeBridge(i, j);
				}
			}
		}
		// 최소길이로 정렬하자
		Collections.sort(edgeInfo);

		int res = 0;
		// 유니온으로 합치자
		for (Edge e : edgeInfo) {
			if (find(e.from) != find(e.to)) {
				res += e.len;
				union(e.from, e.to);
			}
		}

		int temp = 0;
		for (int i = 1; i < parents.length; i++) {
			if (parents[i] == -1)
				temp++;
		}

		System.out.println(temp == 2 ? res : -1);
		br.close();
	}

	public static void bfs(int sx, int sy) { // ->이걸로 맵의 섬정보를 추출했엄
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { sx, sy });
		bMap[sx][sy] = true;
		map[sx][sy] = ++cnt;
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int nx = 0, ny = 0;
			for (int i = 0; i < 4; i++) {
				nx = temp[0] + dx[i];
				ny = temp[1] + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 1 && !bMap[nx][ny]) {
					bMap[nx][ny] = true;
					map[nx][ny] = cnt;
					queue.add(new int[] { nx, ny });
				}
			}
		}
	}

	// 섬 위치에서 다리 만들기
	private static void makeBridge(int sx, int sy) {
		int bridgeLength = 0;
		int nx = 0, ny = 0;
		int tx = 0, ty = 0; // 도착지점 좌표
		// 4방 탐색
		for (int i = 0; i < 4; i++) {
			tx = 0;
			ty = 0;
			nx = sx + dx[i];
			ny = sy + dy[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
				// 이걸 찾았다면 이 방향으로 끝까지 출발
				bridgeLength = 1;
				tx = nx;
				ty = ny;
				while (true) {
					tx += dx[i];
					ty += dy[i];
					if (tx >= 0 && tx < N && ty >= 0 && ty < M) {
						// 일단 경계에서 한칸씩 안쪽까지 가능이고 다른 섬을 만나면 break;
						if (map[tx][ty] == 0)
							bridgeLength++;
						else {
							if (bridgeLength > 1)
								edgeInfo.add(new Edge(map[sx][sy], map[tx][ty], bridgeLength));
							break;
						}
					} else {
						bridgeLength = 1;
						break; // 경계 안쪽이 아니면 바로끝
					}
				}
			}
		}
	}

	// union find
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot) {
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}

	private static int find(int a) {
		if (parents[a] < 0)
			return a;
		return parents[a] = find(parents[a]);
	}
}

