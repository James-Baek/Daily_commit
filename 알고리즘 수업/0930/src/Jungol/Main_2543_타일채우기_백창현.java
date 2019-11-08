package Jungol;

import java.util.Scanner;

public class Main_2543_타일채우기_백창현 {
	static int n,x,y;
	static int[][] map;
	public static void tile(int sx, int sy, int ex, int ey, int hx, int hy, int hc)
	{
	    int mx=(sx+ex)/2,my=(sy+ey)/2;
	    if(sx==ex)
	    {
	    	map[sx][sy]=hc;
	        return;
	    }
	    if(hx>=sx&&hx<=mx&&hy>=sy&&hy<=my)
	    {
	    	map[mx+1][my]=1;
	    	map[mx][my+1]=1;
	    	map[mx+1][my+1]=1;
	        tile(sx,sy,mx,my,hx,hy,hc);
	        tile(mx+1,sy,ex,my,mx+1,my,1);
	        tile(sx,my+1,mx,ey,mx,my+1,1);
	        tile(mx+1,my+1,ex,ey,mx+1,my+1,1);
	    }
	    else if(hx>=mx+1&&hx<=ex&&hy>=sy&&hy<=my)
	    {
	    	map[mx][my]=2;
	    	map[mx+1][my]=2;
	    	map[mx+1][my+1]=2;
	        tile(sx,sy,mx,my,mx,my,3);
	        tile(mx+1,sy,ex,my,hx,hy,hc);
	        tile(sx,my+1,mx,ey,mx,my+1,3);
	        tile(mx+1,my+1,ex,ey,mx+1,my+1,3);
	    }
	    else if(hx>=sx&&hx<=mx&&hy>=my+1&&hy<=ey)
	    {
	    	map[mx][my]=3;
	    	map[mx][my+1]=3;
	    	map[mx+1][my+1]=3;
	        tile(sx,sy,mx,my,mx,my,2);
	        tile(mx+1,sy,ex,my,mx+1,my,2);
	        tile(sx,my+1,mx,ey,hx,hy,hc);
	        tile(mx+1,my+1,ex,ey,mx+1,my+1,2);
	    }
	    else if(hx>=mx+1&&hx<=ex&&hy>=my+1&&hy<=ey)
	    {
	    	map[mx][my]=4;
	    	map[mx+1][my]=4;
	    	map[mx][my+1]=4;
	        tile(sx,sy,mx,my,mx,my,4);
	        tile(mx+1,sy,ex,my,mx+1,my,4);
	        tile(sx,my+1,mx,ey,mx,my+1,4);
	        tile(mx+1,my+1,ex,ey,hx,hy,hc);
	    }
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		map = new int[n+1][n+1];
	    
		tile(1,1,n,n,x+1,y+1,0);
	    
	    for(int i=1; i <= n; i++){
	        for(int j=1 ; j <= n ;j++) {
	        	System.out.print(map[i][j]+" ");
	        }
	        System.out.println();
	    }
		
	}

}
