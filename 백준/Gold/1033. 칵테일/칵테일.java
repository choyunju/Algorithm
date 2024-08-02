//1033
import java.util.*;
import java.io.*;

class Main {
	static ArrayList<Node>[] list;
	static boolean[] visited;
	static long l;
	static long[] D;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		l=1;
		list = new ArrayList[N];
		D = new long[N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			int p = Integer.parseInt(token.nextToken());
			int q = Integer.parseInt(token.nextToken());
			list[a].add(new Node(b,p,q));
			list[b].add(new Node(a,q,p));
			l = l * (p*q/gcd(p, q));
		}
		D[0] = l;
		DFS(0);
		long mgcd = D[0];
		for(int i=1; i<N; i++) {
			mgcd = gcd(mgcd, D[i]);
		}
		for(int i=0; i<N; i++) {
			System.out.print(D[i]/mgcd + " ");
		}
	}
	
	public static long gcd(long a, long b) {
		if(b==0) {
			return a;
		}
		else {
			return gcd(b, a%b);
		}
	}
	
	public static void DFS(int node) {
		visited[node] = true;
		for(Node n : list[node]) {
			if(visited[n.b] != true) {
				D[n.b] = D[node] * n.q / n.p; 
				DFS(n.b);
			}
		}
	}
}

class Node {
	int b;
	int p;
	int q;
	
	public Node(int b, int p, int q) {
		this.b = b;
		this.p = p;
		this.q = q;
	}
}