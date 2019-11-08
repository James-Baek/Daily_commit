package Jungol;

import java.util.Scanner;

public class jungol1291 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		for(int t = 0; t < 10; t++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			
			if(s < 2 || s > 9 || e < 2 || e > 9) {
				sb.append("INPUT ERROR!");
			}else {
				for(int i = 1; i <= 9; i++ ) {
					if(s > e) {
						for(int j = s; j >=e;--j) {
							String ans;
							if(j*i < 10) ans = " "+(j*i);
							else ans = ""+(j*i);
							
							if(j == s) {
								sb.append(j+" * "+i+" = "+ans);
							}else {
								sb.append("   "+j+" * "+i+" = "+ans);
							}
						}
						sb.append("\n");
					}else {
						for(int j = s; j <= e;++j) {
							String ans;
							if(j*i < 10) ans = " "+(j*i);
							else ans = ""+(j*i);
							
							if(j == s) {
								sb.append(j+" * "+i+" = "+ans);
							}else {
								sb.append("   "+j+" * "+i+" = "+ans);
							}
						}
						sb.append("\n");
					}
				}
			}
			System.out.println(sb);
		}
		
	}
}
