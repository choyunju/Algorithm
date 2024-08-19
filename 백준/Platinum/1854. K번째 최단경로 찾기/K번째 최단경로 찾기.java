//no.58 - 1854
import java.io.*;
import java.util.*;

class Main {
	static ArrayList<Node>[] list;
	static PriorityQueue<Integer>[] distance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		
		list = new ArrayList[N+1];
		distance = new PriorityQueue[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
			distance[i] = new PriorityQueue<>(Collections.reverseOrder());
		}
		
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			int t = Integer.parseInt(token.nextToken());
			list[start].add(new Node(end, t));
		}
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(1, 0));
		distance[1].add(0);
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			for(Node node : list[now.node]) {
				int d = now.value + node.value;
				
				if(distance[node.node].size() < K) {
					distance[node.node].add(d);
					queue.add(new Node(node.node, d));
				}
				else if(distance[node.node].peek() > d) {
					distance[node.node].poll();
					distance[node.node].add(d);
					queue.add(new Node(node.node, d));
				}
			}
		}
		for(int i=1; i<=N; i++) {
			if(distance[i].size() == K) {
				System.out.println(distance[i].peek());
			}
			else {
				System.out.println("-1");
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