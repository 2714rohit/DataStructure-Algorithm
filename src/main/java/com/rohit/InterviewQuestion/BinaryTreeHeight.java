package com.rohit.InterviewQuestion;

/**
 * ServiceNow 2nd round
 * @author 2714r
 *
 */
public class BinaryTreeHeight {
	
	
	/**
	 * Node root
	 * height of the tree, root will be at zero
	 * 
	 * 
	 *               5
	 *            3    4
	 *          1   
	 *        5
	 *          6
	 */
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(4);
		
		root.left.left = new Node(1);
		root.left.left.left = new Node(5);
		root.left.left.left.right = new Node(6);
		
		System.out.println(getHeightOfTree(root));
	}
	
	public static int getHeightOfTree(Node root) {
		if(root==null)
			return 0;
		
		if(root.left==null && root.right==null)
			return 0;
		
		int l_height = 0;
		int r_height = 0;
		if(root.left!=null)
			l_height = getHeightOfTree(root.left);
		if(root.right!=null)
			r_height = getHeightOfTree(root.right);
		
		return Math.max(l_height, r_height)+1;
	}
}


class Node{
	Node left;
	Node right;
	int val;
	Node(int val){
		this.val = val;
		left = null;
		right = null;
	}
	
}
