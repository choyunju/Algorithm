//문제26 - 1260
import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer> list[];
	static boolean[] visited;
	static StringBuilder dfs_result;
	static StringBuilder bfs_result;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int V = Integer.parseInt(token.nextToken());
		dfs_result = new StringBuilder();
		bfs_result = new StringBuilder();
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
			visited[i] = false;
		}
		
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for(int i=1; i<=N; i++) {
			Collections.sort(list[i]);
		}
		
		DFS(V);
		System.out.println(dfs_result);
		visited = new boolean[N+1];
		BFS(V);
		System.out.println(bfs_result);
	}
	public static void DFS(int node) {
		if(visited[node]) {
			return;
		}
		visited[node] = true;
		dfs_result.append(node).append(" ");
		for(int i : list[node]) {
			if(!visited[i]) {
				DFS(i);
			}
		}
	}
	
	public static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		while(!queue.isEmpty()) {
			node = queue.remove();
			
			bfs_result.append(node).append(" ");
			
			for(int i : list[node]) {
				if(!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}