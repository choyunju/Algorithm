//no.66 - 1414
import java.io.*;
import java.util.*;

class Main {
	static char[] cp;
	static int sum;
	static PriorityQueue<Edge> queue;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		queue = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			cp = reader.readLine().toCharArray();
			
			for(int j=0; j<N; j++) {
				int temp = 0;
				if(cp[j] >= 'a' && cp[j] <='z') {
					temp = cp[j] - 'a' + 1;
				} else if(cp[j] >= 'A' && cp[j] <= 'Z') {
					temp = cp[j] - 'A' + 27;
				}
				
				sum += temp;
				if(i!=j && temp!=0) {
					queue.add(new Edge(i, j, temp));
				}
			}
		}
		parent = new int[N];
		for(int i=0; i<N; i++) {
			parent[i] = i;
		}
		
		int useEdge = 0;
		int result = 0;
		while(!queue.isEmpty()) {
			Edge edge = queue.poll();
			if(find(edge.e) != find(edge.s)) {
				union(edge.s, edge.e);
				result += edge.v;
				useEdge++;
			}
		}
		if(useEdge == N-1) {
			System.out.println(sum - result);
		}
		else {
			System.out.println("-1");
		}
		
	}
	
	public static int find(int n) {
		if(parent[n] == n) {
			return n;
		} else {
			return find(parent[n]);
		}
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			parent[a] = b;
		}
	}
}

class Edge implements Comparable<Edge> {
	int s, e, v;
	
	public Edge(int s, int e, int v) {
		this.s = s;
		this.e = e;
		this.v = v;
	}
	
	public int compareTo(Edge e) {
		return this.v - e.v;
	}
}