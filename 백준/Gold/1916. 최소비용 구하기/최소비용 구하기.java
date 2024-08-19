//no.57 - 1916
import java.util.*;
import java.io.*;

class Main {
	static ArrayList<Node>[] list;
	static boolean[] visited;
	static int[] distance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int M = Integer.parseInt(reader.readLine());
		
		list = new ArrayList[N+1];
		distance = new int[N+1];
		visited = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		Arrays.fill(distance, Integer.MAX_VALUE);
		for(int i=0; i<M; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(token.nextToken());
			int e = Integer.parseInt(token.nextToken());
			int t = Integer.parseInt(token.nextToken());
			
			list[s].add(new Node(e, t));
		}
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int start = Integer.parseInt(token.nextToken());
		int end = Integer.parseInt(token.nextToken());
		distance[start] = 0;
		
		Dijkstra(start);
		
		System.out.println(distance[end]);
	}
	
	public static void Dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			if(visited[now.node]) {
				continue;
			}
			visited[now.node] = true;
			
			for(Node node : list[now.node]) {
				if(distance[node.node] > distance[now.node] + node.value) {
					distance[node.node] = distance[now.node]+ node.value; 
					queue.add(new Node(node.node, distance[node.node]));
				}
			}
		}
	}
}

class Node implements Comparable<Node>{
	int node;
	int value;
	
	public Node(int node, int value) {
		this.node = node;
		this.value = value;
	}
	
	public int compareTo(Node node) {
		return this.value - node.value;
	}
	
}