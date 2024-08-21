//no.60 - 1219
import java.util.*;
import java.io.*;

class Main {
	static Edge[] edges;
	static long[] money;
	static long[] distance;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(token.nextToken());
		int start = Integer.parseInt(token.nextToken());
		int end = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		edges = new Edge[M];
		money = new long[N];
		distance = new long[N];
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(token.nextToken());
			int e = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			edges[i] = new Edge(s, e, v);
		}
		token = new StringTokenizer(reader.readLine());
		for(int i=0; i<N; i++) {
			money[i] = Long.parseLong(token.nextToken());
		}
		Arrays.fill(distance, Long.MIN_VALUE);
		distance[start] = money[start];
		for(int i=0; i<=N+100; i++) {
			for(int j=0; j<M; j++) {
				Edge edge = edges[j];
				if(distance[edge.start] == Long.MIN_VALUE ) continue;
				else if(distance[edge.start] == Long.MAX_VALUE) {
					distance[edge.end]= Long.MAX_VALUE; 
				}
				else if( distance[edge.end] < distance[edge.start] - edge.value + money[edge.end] ) {
					distance[edge.end] = distance[edge.start] - edge.value + money[edge.end];  
					if(i >= N-1) {
						distance[edge.end] = Long.MAX_VALUE;
					}
				}
			}
		}
		
		if(distance[end] == Long.MAX_VALUE) {
			System.out.println("Gee");
		}
		else if(distance[end] == Long.MIN_VALUE) {
			System.out.println("gg");
		}
		else {
			System.out.println(distance[end]);
		}
	}
}

class Edge {
	int start, end, value;
	
	public Edge(int start, int end, int value) {
		this.start = start;
		this.end = end;
		this.value = value;
	}
}