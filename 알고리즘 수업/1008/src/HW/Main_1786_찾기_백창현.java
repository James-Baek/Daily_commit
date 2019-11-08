package HW;

import java.util.ArrayList;
import java.util.Scanner;

class Main_1786_찾기_백창현 { 
	static ArrayList<Integer> ans;
    public static void KMPSearch(String pat, String txt) { 
        int M = pat.length(); 
        int N = txt.length(); 
  
        int lps[] = new int[M]; 
        int j = 0; 

        computeLPSArray(pat, M, lps); 
  
        int i = 0;
        while (i < N) { 
            if (pat.charAt(j) == txt.charAt(i)) { 
                j++; 
                i++; 
            } 
            if (j == M) { 
            	ans.add(i-j+1);
                j = lps[j - 1]; 
            } 
            else if (i < N && pat.charAt(j) != txt.charAt(i)) { 
                if (j != 0) 
                    j = lps[j - 1]; 
                else
                    i = i + 1; 
            } 
        } 
    } 
  
    public static void computeLPSArray(String pat, int M, int lps[]) { 
        int len = 0; 
        int i = 1; 
        lps[0] = 0; 

        while (i < M) { 
            if (pat.charAt(i) == pat.charAt(len)) { 
                len++; 
                lps[i] = len; 
                i++; 
            } 
            else {
                if (len != 0) { 
                    len = lps[len - 1]; 
                } 
                else { 
                    lps[i] = len; 
                    i++; 
                } 
            } 
        } 
    } 

    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	String txt = sc.nextLine();
    	String target = sc.nextLine();
        ans = new ArrayList<Integer>();
        KMPSearch(target, txt); 
        System.out.println(ans.size());
        for(int temp : ans) {
        	System.out.println(temp);
        }
    } 
} 
