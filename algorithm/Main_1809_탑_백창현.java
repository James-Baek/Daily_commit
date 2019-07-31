
import java.util.*;
import java.io.*;

public class Main_1809_탑_백창현 {
	public static void main(String args[]) throws Exception{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack=new Stack<Integer>(); 
		Stack<Integer> index=new Stack<Integer>(); 
		int N = Integer.parseInt(br.readLine());
		int[] arr=new int[N]; 
		int[] arr2=new int[N]; 
		
		String[] input = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		stack.push(arr[N-1]); 
		index.push(N-1); 
			
		for(int i=N-1;i>0;i--){ 
			if(arr[i]<arr[i-1]){ 
				while(stack.size()!=0 && stack.peek()<arr[i-1]){ 
					arr2[index.peek()]=i; 
					stack.pop(); 
					index.pop(); 
				} 
				stack.push(arr[i-1]); 
				index.push(i-1); 
			} 
			else{ 
				stack.push(arr[i-1]); 
				index.push(i-1); 
			} 
		} 
		for(int i=0;i<N;i++) 
		System.out.print(arr2[i]+" "); 
	} 
} 

