package com.ssafy.swea1;
import java.util.Scanner;
import java.io.FileInputStream;

/*
����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
�̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
*/
class Solution1
{
	static int T;
	public static void main(String args[]) throws Exception
	{
//		System.setIn(new FileInputStream("res/input.txt"));
	
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
//		String s = sc.nextLine();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int cnt = 0; // count
			char[] chs = sc.next().toCharArray(); // �� line�� char array�� �޾ƿ���
			char current = '0'; // �ʱⰪ
			for(char ch:chs) { // ������ ���ڿ� ���� ���¸� check
				if(ch != current) { // 
					cnt++; // count ++
					current = ch; // �� ���� �񱳸� ���� current ������ ����
				}
			}
			
			
			System.out.println("#" + test_case + " " + cnt);
			
		}
			
	}
}