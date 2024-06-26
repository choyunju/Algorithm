//no. 1167
import java.util.*;
import java.io.*;

class Main {
	public static ArrayList<Node>[] nodes;
	public static boolean visited[];
	public static int length[];
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(reader.readLine());
		nodes = new ArrayList[V+1];
		visited = new boolean[V+1];
		length = new int[V+1];
		for(int i=1; i<=V; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for(int i=0; i<V; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			while(b != -1) {
				int l = Integer.parseInt(token.nextToken());
				nodes[a].add(new Node(b, l));
				b = Integer.parseInt(token.nextToken());
			}
		}
		BFS(new Node(1, 0));
		int max = 1;
		for(int i=2; i<=V; i++) {
			if(length[max] < length[i]) {
				max = i;
			}
		}
		length = new int[V+1];
		visited = new boolean[V+1];
		BFS(new Node(max, 0));
		Arrays.sort(length);
		System.out.println(length[V]);
		
	}
	
	public static void BFS(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		visited[node.node] = true;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			for(Node n : nodes[now.node]) {
				if(!visited[n.node]) {
					queue.add(n);
					visited[n.node] = true;
					length[n.node] =  length[now.node] + n.value; 
				}
			}
		}
		
	}
}

class Node {
	int node;
	int value;
	Node(int n, int v) {
		this.node = n;
		this.value = v;
	}
}