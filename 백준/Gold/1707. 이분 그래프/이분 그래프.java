//no.48 - 1707
import java.util.*;
import java.io.*;

class Main {
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int[] check;
	static boolean isEven;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int K = Integer.parseInt(reader.readLine());
		for(int t=0; t<K; t++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int V = Integer.parseInt(token.nextToken());
			int E = Integer.parseInt(token.nextToken());
			
			list = new ArrayList[V+1];
			visited = new boolean[V+1];
			check = new int[V+1];
			isEven = true;
			for(int i=1; i<=V; i++) {
				list[i] = new ArrayList<>();
			}
			for(int i=0; i<E; i++) {
				token = new StringTokenizer(reader.readLine());
				int a = Integer.parseInt(token.nextToken());
				int b = Integer.parseInt(token.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			for(int i=1; i<=V; i++) {
				if(isEven) 
					DFS(i);
				else 
					break;
			}
			if(isEven)
				builder.append("YES\n");
			else 
				builder.append("NO\n");
		}
		System.out.println(builder);
	}
	
	public static void DFS(int node) {
		visited[node] = true;
		for(int n : list[node]) {
			if(!visited[n]) {
				check[n] = (check[node]+1) % 2;
				DFS(n);
			}
			else if(check[n] == check[node]) {
				isEven = false;
			}
		}
	}
}