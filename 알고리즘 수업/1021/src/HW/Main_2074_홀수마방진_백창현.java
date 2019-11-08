package HW;
import java.util.Scanner;

public class Main_2074_홀수마방진_백창현 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 0;
        int y = n/2;
        int end = n * n;
         
        int[][] arr = new int[n][n];
         
        for(int i = 1; i <= end; i++) {
            arr[x][y] = i;
            if(i % n == 0) {
                x++;
            }else {
                x--;
                y--;
                if(x < 0) x = n-1;
                if(y < 0) y = n-1;
            }
        }
         
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}
