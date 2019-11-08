package com.ssafy.step2.tree.linked;

public class ExpressionBinaryTreeTest {

	public static void main(String[] args) {
		String postExpression = "AB/C*D*E+";
		ExpressionBinaryTree tree = new ExpressionBinaryTree();
		tree.makeTree(postExpression);
		
		tree.printByPreOrder();
		tree.printByInOrder();
		tree.printByPostOrder();
	}

}
