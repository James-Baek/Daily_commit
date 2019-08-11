package ssafy;
import java.util.*;

public class SWEA3752 {
    static int[] arr;
    static int count;
    static int N;
    static int max;
    
	public static void func(int i, int[] v) {
        if(i>=N) {
            for (int j = 0; j <= max; j++) {
                if(v[j]==1) {
                    count+=1;
                }
            }
        }
        else {
            int temp[] = new int[max+1];
            for (int j = 0; j <=max; j++) {
                if(v[j]==1) {
                    temp[j] = 1;
                    temp[j+arr[i]]=1;
                }
            }
            func(i+1,temp);
        }
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N];
			count = 0;
			max = 0;
			
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				max +=arr[i];
			}

			int[] num = new int[max+1];
			num[0] = 1;
			func(0,num);
			
			System.out.printf("#%d %d\n", t, count);
		}
	}

}
