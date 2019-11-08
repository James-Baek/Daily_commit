package com.ssafy.step1.tree;

public class BinaryTreTest {

	public static void main(String[] args) {
		int size = 10;
		BinaryTree tree = new BinaryTree(size);
		for(int i = 0; i < size; i++) {
			tree.add((char)(65+i));
		}
		tree.printByPreOrder();
		tree.printByInOrder();
		tree.printByPostOrder();
		tree.printByLevelOrder();
	}

}
