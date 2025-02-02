import java.util.*;
import java.io.*;

class Main {
	static boolean[] visited;
	static StringBuilder builder;
	static ArrayList<Node>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		builder = new StringBuilder();
		
		int N = Integer.parseInt(reader.readLine());
		visited = new boolean[N];
		list = new ArrayList[N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int node = (int)(token.nextToken().charAt(0)) - 65;
			int left = (int)(token.nextToken().charAt(0)) - 65;
			int right = (int)(token.nextToken().charAt(0)) - 65;
			
			list[node].add(new Node(left, right));
		}
		
		preOrder(0);
		System.out.println(builder);
		
		builder = new StringBuilder();
		visited = new boolean[N];
		inOrder(0);
		System.out.println(builder);
		
		builder = new StringBuilder();
		visited = new boolean[N];
		postOrder(0);
		System.out.println(builder);
	}
	
	static void preOrder(int node) {
		visited[node] = true;
		builder.append((char)(node + 65));
		
		for(Node next : list[node]) {
			int left = next.left;
			int right = next.right;
			if(left != -19 && !visited[left]) {
				preOrder(left);
			}
			if(right != -19 && !visited[right]) {
				preOrder(right);
			}
		}
	}
	
	public static void inOrder(int node) {
		visited[node] = true;
		for(Node next : list[node]) {
			int left = next.left;
			int right = next.right;
			if(left != -19 && !visited[left]) {
				inOrder(left);
			}
			builder.append((char)(node+65));
			if(right != -19 && !visited[right]) {
				inOrder(right);
			}
		}
	}
	
	public static void postOrder(int node) {
		visited[node] = true;
		for(Node next : list[node]) {
			int left = next.left;
			int right = next.right;
			if(left != -19 && !visited[left]) {
				postOrder(left);
			}
			if(right != -19 && !visited[right]) {
				postOrder(right);
			}
			builder.append((char)(node+65));
		}
		
	}
}

class Node {
	int left;
	int right;
	
	public Node(int left, int right) {
		this.left = left;
		this.right = right;
	}
}