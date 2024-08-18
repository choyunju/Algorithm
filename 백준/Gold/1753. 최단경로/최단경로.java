//no.56 - 1753
import java.util.*;
import java.io.*;

class Main {
	static ArrayList<Node>[] list;
	static int[] distance;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		StringBuilder builder = new StringBuilder();
		int V = Integer.parseInt(token.nextToken());
		int E = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(reader.readLine());
		list = new ArrayList[V+1];
		distance = new int[V+1];
		visited = new boolean[V+1];
		for(int i=1; i<=V; i++) {
			list[i] = new ArrayList<>();
			
		}
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0;
		
		for(int i=0; i<E; i++) {
			token = new StringTokenizer(reader.readLine());
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			int w = Integer.parseInt(token.nextToken());
		
			list[u].add(new Node(v, w));
		}
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(K, 0));
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			if(visited[now.n]) {
				continue;
			}
			visited[now.n] = true;
			for(Node node : list[now.n]) {
				if(distance[node.n] > distance[now.n] + node.v) {
					distance[node.n] = distance[now.n] + node.v;
					queue.add(new Node(node.n, distance[node.n]));
				}
			}
		}
		
		for(int i=1; i<=V; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else {
				System.out.println(distance[i]);
			}
		}
	
	}
}

class Node implements Comparable<Node>{
	int n;
	int v;
	
	public Node(int n, int v) {
		this.n = n;
		this.v = v;
	}
	
	public int compareTo(Node n) {
		return this.v - n.v;
	}
}