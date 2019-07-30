package ssafy;
import java.util.*;
import java.io.*;

public class top2 {

	static Scanner sc=new Scanner(System.in); 
	
	public static void main(String args[]) throws Exception{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack=new Stack<Integer>(); 
		Stack<Integer> index=new Stack<Integer>(); 
		int num = Integer.parseInt(br.readLine());
		int[] arr=new int[num]; 
		int[] arr2=new int[num]; 
		
		String[] input = br.readLine().split(" ");
		for(int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(input[i]);

		}

		stack.push(arr[num-1]); 
		index.push(num-1); 
			
		for(int i=num-1;i>0;i--){ 
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
		for(int i=0;i<num;i++) 
		System.out.print(arr2[i]+" "); 
	} 
} 

