package WS;

import java.util.Scanner;
 
public class Solution1240{
    public static int change(String txt) {
 
        switch(txt){
        case "0001101" : //0
            return 0;
        case "0011001" : //1
            return 1;
        case "0010011" : //2
            return 2;
        case "0111101" : //3
            return 3;
        case "0100011" : //4
            return 4;
        case "0110001" : //5
            return 5;
        case "0101111" : //6
            return 6;
        case "0111011" : //7
            return 7;
        case "0110111" : //8
            return 8;
        case "0001011" : //9
            return 9;
        }
        return 0;
    }
     
    public static int[] Find(String txt) {
        int temp[] = new int[3];
        String original = txt;
        int sum = 0;
        int oddsum = 0;
        int num = 0;
         
        for(int i = 0; i < 56; i = i + 7) {
            if(i % 2 == 0) {
                oddsum = oddsum + change(original.substring(i, i+7));
            }else {
                num = change(original.substring(i, i+7));
                sum = sum + num;
            }
        }
        sum = sum + (oddsum*3);
        temp[0] = oddsum;
        temp[1] = sum;
        temp[2] = num;
         
        return temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for(int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            int cnt = 0;
             
            for(int k = 0; k < n; k++) {
                String txts = sc.nextLine();
                for(int j = m; j >= 0; j--) {
                    if(cnt != 0) break;
                     
                    int temp = txts.charAt(j-1)-48;
                    if(temp == 1) {
                        int[] numlist = Find(txts.substring(j-56, j));
                        if(numlist[1] % 10 == 0) {
                            System.out.printf("#%d %d\n",t, (numlist[1]-(numlist[0]*2)));
                            cnt++;
                            break;
                        }else {
                            System.out.printf("#%d %d\n",t, 0);
                            cnt++;
                            break;
                        }
                    }
                }
            }
             
        }
         
    }
}