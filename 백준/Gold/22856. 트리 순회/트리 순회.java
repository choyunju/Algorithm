import java.io.*;
import java.util.*;

class Node {
	int left;
	int right;
	
	public Node(int left, int right) {
		this.left = left;
		this.right = right;
	}
}

class Main {
	static Node[] tree;
	static Stack<Integer> inOrderList;
	static ArrayList<Integer> similarInOrderList;
	static boolean[] visited;
	static int count, lastNode, N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		
		tree= new Node[N+1];
		inOrderList = new Stack<>();
		similarInOrderList = new ArrayList<>();
		visited = new boolean[N+1];
		
		
		for(int i=1; i<=N; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int node = Integer.parseInt(token.nextToken());
			int left = Integer.parseInt(token.nextToken());
			int right = Integer.parseInt(token.nextToken());
			tree[node] = new Node(left, right);
		}
		
		inOrder(1);  // 중위순회
		lastNode = inOrderList.pop();  // 중위순회의 마지막 노드
		similarInOrder(1);
	}
	
	public static void inOrder(int node) {
		Node now = tree[node];
	        
	    if (now.left != -1) {
	    	inOrder(now.left);
	    }
	    inOrderList.add(node);
	    if (now.right != -1) {
	        inOrder(now.right);
	    }
	}
	
	public static void similarInOrder(int node) {
		similarInOrderList.add(node);
		if(!visited[node]) {
			visited[node] = true;
			count++;
		}
		
		Node now = tree[node];
		if(now.left != -1) {
			similarInOrder(now.left);
			similarInOrderList.add(node);
		}
		
		if(now.right != -1) {
			similarInOrder(now.right);
			similarInOrderList.add(node);
		}
		if(count==N && node==lastNode) {
			System.out.println(similarInOrderList.size()-1);
			System.exit(0);
		}
	}
}