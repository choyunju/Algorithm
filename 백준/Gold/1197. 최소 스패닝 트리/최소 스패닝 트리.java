// no.64 - 1197
import java.io.*;
import java.util.*;

public class Main {
	static PriorityQueue<Edge> queue;
	static int[] A;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int V = Integer.parseInt(token.nextToken());
		int E = Integer.parseInt(token.nextToken());
		queue = new PriorityQueue<>();;
		A = new int[V+1];
		for(int i=1; i<=V; i++) {
			A[i] = i;
		}
		
		for(int i=0; i<E; i++) {
			token = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(token.nextToken());
			int e = Integer.parseInt(token.nextToken());
			int w = Integer.parseInt(token.nextToken());
			queue.add(new Edge(s, e, w));
		}
		
		int useEdge = 0;
		int result = 0;
		while(useEdge < V-1) {
			Edge edge = queue.poll();
			if(find(edge.s) != find(edge.e)) {
				union(edge.s, edge.e);
				result += edge.w;
				useEdge++;
			}
		}
		System.out.println(result);
	}
	
	public static void union(int s, int e) {
		s = find(s);
		e = find(e);
		if(s != e) {
			A[e] = s;
		}
	}
	
	public static int find(int a) {
		if(a == A[a]) {
			return a;
		}
		else {
			return find(A[a]);
		}
	}
}

class Edge implements Comparable<Edge>{
	int s;
	int e;
	int w;
	public Edge(int s, int e, int w) {
		this.s = s;
		this.e = e;
		this.w = w;
	}
	public int compareTo(Edge o) {
		return this.w - o.w;
	}
}