package com.rohit.ds_algo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LRU {
	Node root;
	Node lastNode;
	List<Node> lru = new LinkedList();
	int n = 4;
	HashMap<Integer, Node> map = new HashMap();
	public static void main(String[] args) {
		
	}
	
	// null<-1<=>2<=>3->null
	private int get(int val) {
		if(map.containsKey(val)) {
			if(root.val!=val) {
				Node node = map.get(val);
				
				Node next = node.right;
				Node prev = node.left;
				
				prev.right = next;
				
				if(next!=null) {
					next.left = prev;
				}
			}
			return val;
		}
		else return -1;
	}
	
	/**
	 * Add data to cache, check if already exist then bring to front of list
	 * do it O(1)
	 */
	private void put(int val){
		if(map.containsKey(val)) {
			
			if(root.val!=val) {
				Node node = map.get(val);
				node.left.right = node.right;
				if(node.right!=null) {
					node.right.left = node.left;
				}
				
				node.left = null;
				node.right = null;
				
				node.right = root;
				root.left = node;
				root = node;
			}
		}else {
			if(root==null) {
				root = new Node(val);
				lastNode = root;
			}else {
				Node node = new Node(val);
				node.right = root;
				node.left=null;
				root=node;
				
				if(map.size()==n) {
					map.remove(lastNode.val);
					Node tmp = lastNode.left;
					tmp.right = null;
					lastNode.left = null;
					lastNode = tmp;
				}
				map.put(val, node);
				
			}
		}
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
