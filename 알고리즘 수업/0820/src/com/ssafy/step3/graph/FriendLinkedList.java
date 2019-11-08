package com.ssafy.step3.graph;

import java.util.Scanner;

public class FriendLinkedList {
	static class Node{
		private char name;
		private Node next;
		
		public Node() {}
		public Node(char name, Node next) {
			super();
			this.name = name;
			this.next = next;			
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}
		
	}
	static class LinkedList {
		private static Node root;
		private static int size;
		
		public LinkedList() {
			this.root = root;
			this.size = 0;
		}
		
		public static void add(Node node) {
			if(root == null) {
				root = node;
			}else {
				while(root.next != null) {
					root.next = node;
				}
			}
			size++;
		}
		public static int size() {
			return size;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		LinkedList[] list = new LinkedList[V];
		
		for(int i = 0; i < E; i++) {
			char tempA = sc.next().charAt(0);
			char tempB = sc.next().charAt(0);
			int r = tempA - 'A';
			Node node = new Node(tempB, null);
			list[r].add(node);
		}
		
		for(int i = 0; i < V; i++) {
			System.out.println(list[i].size());
		}
		
	}

}
