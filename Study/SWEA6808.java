package Study;

import java.util.*;

public class SWEA6808{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int ans = 0;
        
        sc.nextLine();

        for(int testCase = 1; testCase <= T; testCase++){
            String[] temp_num = sc.nextLine().split(" ");
            int[] num = new int[temp_num.length];
    
            for(int i = 0; i < temp_num.length; i++){
                num[i] = Integer.parseInt(temp_num[i]);
            }
    
            System.out.printf("#%d %d\n", testCase, ans);
        }
 

    }

}