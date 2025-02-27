import java.io.*;
import java.util.*;

class Node {
	int num;
	int left;
	int right;
	int column;
	
	public Node(int num, int left, int right) {
		this.num = num;
		this.left = left;
		this.right = right;
	}
}

class Main {
	static Node[] tree;
	static boolean[] visited;
	static int column = 1;
	static ArrayList<Node>[] level;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		tree = new Node[N+1];
		visited = new boolean[N+1];
		int[] parents = new int[N+1];
		for(int i=0; i<N; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int num = Integer.parseInt(token.nextToken());
			int left = Integer.parseInt(token.nextToken());
			int right = Integer.parseInt(token.nextToken());
			if(left != -1) {
				parents[left] = num;
			} else {
				left = 0;
			}
			if(right != -1) {
				parents[right] = num;
			} else {
				right = 0;
			}
			tree[num] = new Node(num, left, right);
		}
		
		//루트노드 구하기
		int root = 0;
		for(int i=1; i<=N; i++) {
			if(parents[i] == 0) {
				root = i;
			}
		}
		
		//중위순회를 통한 Column 구하기
		inOrder(tree[root]);
		
		//row 구하기
		int depth = 1;
		level = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			level[i] = new ArrayList<>();
		}
		DFS(tree[root], depth);
		
		int max = 0;
		StringBuilder builder = new StringBuilder();
		for(int i=1; i<=N; i++) {
			if(level[i].size() >= 1) {
				int a = level[i].get(0).column;
				int b = level[i].get(level[i].size()-1).column;
				int diff = b - a + 1;
				if(max < diff) {
					builder = new StringBuilder();
					max = diff;
					builder.append(i + " ");
					builder.append(max);
				}
			}
		}
		System.out.println(builder);
	}
	
	public static void DFS(Node node, int depth) {
		if(node == null) {
			return;
		}
		visited[node.num] = true;
		level[depth].add(node);
		depth++;
		
		if(!visited[node.left]) {
			DFS(tree[node.left], depth);
		}
		if(!visited[node.right]) {
			DFS(tree[node.right], depth);
		}
		
	}
	
	public static void inOrder(Node node) {
		if(node == null) {
			return;
		}
		inOrder(tree[node.left]);
		node.column = column;
		column++;
		inOrder(tree[node.right]);
	}
}