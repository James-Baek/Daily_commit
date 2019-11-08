
public class dfstest {
	public static void dfs(int cnt) {
		if(cnt == 0) return;
		System.out.println(cnt);
		dfs(cnt-1);
	}
	public static void main(String[] args) {
		dfs(10000);
	}

}
// 11403 스택