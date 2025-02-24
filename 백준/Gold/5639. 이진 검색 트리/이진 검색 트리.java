import java.io.*;
import java.util.*;


class Node {
	int node;
	Node left;
	Node right;
	
	public Node(int node) {
		this.node = node;
		this.left = null;
		this.right = null;
	}
	
	public void insert(int n) {
		if(n < this.node) {
			if(this.left == null) {
				this.left = new Node(n);
			} else {
				this.left.insert(n);
			}
		} else {
			if(n>this.node) {
				if(this.right == null) {
					this.right = new Node(n);
				} else {
					this.right.insert(n);
				}
			}
		}
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int root = Integer.parseInt(reader.readLine());
		Node rootNode = new Node(root);
		String s;
		
		while((s=reader.readLine()) != null) {
			int n = Integer.parseInt(s);
			
			rootNode.insert(n);
		}
		
		postOrder(rootNode);
	}
	
	public static void postOrder(Node node) {
		if(node == null) {
			return;
		}
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.node);
		
	}
	
	public static void findRoot(ArrayList<Integer> tree) {
		int size = tree.size();
		int mid = size / 2;
		
	}
	
}