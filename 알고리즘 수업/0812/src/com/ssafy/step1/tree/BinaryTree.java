package com.ssafy.step1.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	private Object[] nodes;
	private int lastIndex;
	private final int SIZE;
	private final int MAX_LEVEL;	// 트리의 레벨, 트리의 높이
	
	public BinaryTree(int size) {
		this.SIZE = size;
		this.nodes = new Object[size+1];
		this.MAX_LEVEL = (int)Math.ceil(Math.log(size+1)/Math.log(2))-1;
	}
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	public void add(Object e) {
		if(isFull()) throw new RuntimeException("트리 크리각 꽉 찼습니다.");
		nodes[++lastIndex] = e;
	}

	
	//전위순회
	public void printByPreOrder() {
		printByPreOrder(1);
		System.out.println();
	}
	private void printByPreOrder(int index) {
		if(index<=lastIndex) {
			// VLR
			System.out.print(nodes[index]+" "); // V : 현재노드 방문처리
			printByPreOrder(index*2); // L : 왼쪽자식노드 방문
			printByPreOrder(index*2+1); // R : 오른쪽자식노드 방문
		}

	}
	
	// 중위순회
	public void printByInOrder() {
		printByInOrder(1);
		System.out.println();
	}
	private void printByInOrder(int index) {
		if(index<=lastIndex) {
			// LVR
			printByInOrder(index*2); // L : 왼쪽자식노드 방문
			System.out.print(nodes[index]+" "); // V : 현재노드 방문처리
			printByInOrder(index*2+1); // R : 오른쪽자식노드 방문
		}

	}
	
	// 후위순회
	public void printByPostOrder() {
		printByPostOrder(1);
		System.out.println();
	}
	private void printByPostOrder(int index) {
		if(index<=lastIndex) {
			// LVR
			printByPostOrder(index*2); // L : 왼쪽자식노드 방문
			printByPostOrder(index*2+1); // R : 오른쪽자식노드 방문
			System.out.print(nodes[index]+" "); // V : 현재노드 방문처리
		}

	}
	
	// 레벨순회	
	public void printByLevelOrder() {
		int start = 0, end = 0;
		for(int i = 0; i <= MAX_LEVEL; ++i) {
			start = (int)Math.pow(2, i);
			end = (int)Math.pow(2, i+1)-1;
			for(int j = start; j <= lastIndex && j<=end; ++j) {
				System.out.print(nodes[j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
