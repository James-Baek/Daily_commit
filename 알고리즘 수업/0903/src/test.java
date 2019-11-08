
public class test {
		
	public static void dfs(int cnt) {
		int a,b,c,d,e,f,g,h;
		if(cnt == 12000) return;
		System.out.println(cnt);
		dfs(cnt+1);
	}
	
	public static void main(String[] args) {
		
		dfs(0);
	}

}
