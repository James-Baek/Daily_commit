import java.util.*;

import sun.security.util.Length;

public class samsungbus{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; ++i){
            int N = sc.nextInt();
            ArrayList<Integer> bus1 = new ArrayList<Integer>();
            ArrayList<Integer> bus2 = new ArrayList<Integer>();
            ArrayList<Integer> station = new ArrayList<Integer>();

            for(int j = 0; j < N; ++j){
                int a = sc.nextInt();
                int b = sc.nextInt();
                bus1.add(a);
                bus2.add(b);
            }

            int P = sc.nextInt();

            for(int k = 0; k < P; ++k){
                int c = sc.nextInt();
                int cnt = 0;
                for(int q = 0; q < N; ++q){
                    int x = bus1.get(q);
                    int y = bus2.get(q);
                    if(c >= x && c <= y){
                        cnt++;
                    }
                }
                station.add(cnt);
            }
            System.out.print("#"+(i+1));
            for(int p = 0; p < station.size(); ++p){
                System.out.print(" "+station.get(p));
            }
        }
    }
}