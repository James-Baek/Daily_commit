package baekjoon;
import java.io.IOException;
import java.util.Scanner;

public class Main_14889_스타트와링크_백창현{
	static int ans,N;
	static int[][] map;
	static boolean[] team;
	public static void search(int cnt,int index)
	{
		if(cnt==N/2)
		{
			int team1,team2;
			team1=0;
			team2=0;

			for(int i=0;i<N-1;i++)
			{
				for(int j=i+1;j<N;j++)
				{
					if(team[i]==true&&team[j]==true)
					{
						team1+=map[i][j];
						team1+=map[j][i];
					}
					else if(team[i]==false&&team[j]==false)
					{
						team2+=map[i][j];
						team2+=map[j][i];
					}
				}
			}
			ans = ans < Math.abs(team1-team2) ? ans : Math.abs(team1-team2);
			return;
		}
		for(int i=index;i<N;i++)
		{
			if(team[i]==false)
			{
				team[i]=true;
				search(cnt+1,i+1);
				team[i]=false;
			}
		}
		
		
	}
	public static void main(String[] args) throws Exception, IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ans = Integer.MAX_VALUE;
		map = new int[N][N];
		team = new boolean[N];
		for(int i=0;i<N;i++)
		{
			team[i]=false;
			for(int j=0;j<N;j++)
			{
				map[i][j]=sc.nextInt();
			}
		}
		search(0,0);
		System.out.println(ans);
	}

}
