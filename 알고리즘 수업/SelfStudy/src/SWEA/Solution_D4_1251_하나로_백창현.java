package SWEA;

import java.util.Arrays;
import java.util.Scanner;
   
public class Solution_D4_1251_하나로_백창현 {
    private static int n;
    private static double e;
    private static int[] x, y;
    private static long[][] Graph;
    private static long[] Weight;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
           
        for(int t = 1; t <= T; t++) {
            n = sc.nextInt();
            x = new int[n];
            y = new int[n];
            for(int i = 0; i < n; i++) x[i] = sc.nextInt();
            for(int i = 0; i < n; i++) y[i] = sc.nextInt();
            e = sc.nextDouble();
               
            Graph = new long[n][n];
            Weight = new long[n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == j) continue;
                    long a = x[i]-x[j];
                    long b = y[i]-y[j];
                    long cost = a*a + b*b;
                    Graph[i][j] = cost;
                }
            }
            System.out.printf("#%d %d\n", t, prim());
        }
    }
    public static long prim() {
        for(int i = 0; i < n; i++) Weight[i] = -1;
        Weight[0] = 0;
        for(int k = 1; k < n; k++) {
            long minWeight = Long.MAX_VALUE;
            int minVertax = 0;
            for(int i = 0; i < n; i++) {
                if(Weight[i] < 0) continue;
                for(int j = 0; j < n; j++) {
                    if(Weight[j] >= 0) continue;
                    if(Graph[i][j] < minWeight && Graph[i][j] != 0) {
                        minVertax = j;
                        minWeight = Graph[i][j];
                    }
                }
            }
            Weight[minVertax] = minWeight;
        }
        long sumCost = 0;
        for(int i = 0; i < n; i++) sumCost += Weight[i];
        return Math.round((long)sumCost*e);
    }
}