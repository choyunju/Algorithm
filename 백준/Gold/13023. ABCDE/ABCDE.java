//no. 13023
import java.util.*;
import java.io.*;

class Main {
	public static boolean visited[];
	public static int friends[];
	public static int arrive;
	public static ArrayList<Integer>[] list;
	public static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		list = new ArrayList[N];
		visited = new boolean[N];
		friends = new int[N];
		count=0;
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=0; i<N; i++) {
			if(arrive == 0) {
				DFS(i, 1);
			}
		}
		System.out.println(arrive);
	}
	
	public static void DFS(int node, int depth) {
		if(depth == 5) {
			arrive = 1;
			return;
		}

		visited[node] = true;
		
		for(int n : list[node]) {
			if(!visited[n]) {
				DFS(n, depth+1);
			}
		}
		visited[node] = false;
	}
}