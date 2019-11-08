package com.ssafy.step2.tree.linked;

import java.util.Scanner;

public class LinkedBinaryTreeTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int edgeCnt = sc.nextInt() - 1;
		LinkedBinaryTree tree = new LinkedBinaryTree();
		while(edgeCnt-- > 0 ) {
			tree.add(sc.nextInt(), sc.nextInt());
		}
		tree.printByPreOrder();
		tree.printByInOrder();
		tree.printByPostOrder();
		tree.printByLevelOrder();
	}

}
