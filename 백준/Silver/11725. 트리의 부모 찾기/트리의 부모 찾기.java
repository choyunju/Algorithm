//문제 67 - 11725
import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(reader.readLine());  //노드의 개수
		tree = new ArrayList[N+1];
		visited = new boolean[N+1];
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i=1; i<N; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			//양방향 에지
			tree[a].add(b);
			tree[b].add(a);
		}
		
		DFS(1);  //루트노드부터 시작
		for(int i=2; i<=N; i++) {
			writer.write(parent[i] + "\n");
		}
		writer.flush();
	}
	
	public static void DFS(int s) {
		visited[s] = true;
		for(int n : tree[s]) {
			if(!visited[n]) {
				parent[n] = s;
				DFS(n);
			}
		}
	}
}