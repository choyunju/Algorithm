//no.59 - 11657
import java.util.*;
import java.io.*;

class Main {
	static Edge[] list;
	static long[] distance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		list = new Edge[M];
		distance = new long[N+1];
		
		
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(token.nextToken());
			int e = Integer.parseInt(token.nextToken());
			int t = Integer.parseInt(token.nextToken());
			list[i] = new Edge(s, e, t);
		}
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<M; j++) {
				Edge edge = list[j];
				if((distance[edge.s] != Integer.MAX_VALUE) && (distance[edge.e] > distance[edge.s] + edge.t)) {
					distance[edge.e] = distance[edge.s] + edge.t; 
				}
			}
		}
		
		boolean minus = false;
		for(int i=0; i<M; i++) {
			Edge edge = list[i];
			if(distance[edge.s] != Integer.MAX_VALUE && distance[edge.e] > distance[edge.s]+ edge.t ) {
				minus = true;
			}
		}
		
		if(minus) {
			System.out.println("-1");
		}
		else {
			for(int i=2; i<=N; i++) {
				if(distance[i] != Integer.MAX_VALUE) {
					System.out.println(distance[i]);
				}else {
					System.out.println("-1");
				}
			}
		}
	}
}

class Edge {
	int s, e, t;
	public Edge(int s, int e, int t) {
		this.s = s;
		this.e = e;
		this.t = t;
	}
}