//no.74 - 11437
import java.util.*;
import java.io.*;

class Main {
	static int[][] parent;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int[] depth;
	static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		depth = new int[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<N-1; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		int tmp = 1;
		K=0;
		while(tmp <= N) {
			tmp <<= 1;
			K++;
		}
		parent = new int[K][N+1];
		DFS(1, 0);  //depth, parent 구하기
		for(int i=1; i<K; i++) {
			for(int j=1; j<=N; j++) {
				parent[i][j] = parent[i-1][parent[i-1][j]];
			}
		}
		int M = Integer.parseInt(reader.readLine());
		for(int i=0; i<M; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			int result = LCA(a, b);
			builder.append(result+"\n");
		}
		System.out.println(builder);
	}
	
	public static int LCA(int a, int b) {
		if(depth[a]>depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		for(int i=K; i>=0; i--) {
			if(Math.pow(2, i) <= depth[b] - depth[a]) {
				b = parent[i][b];
			}
		}
		
		if(a == b) {
			return a;
		}
		
		for(int i=K-1; i>=0; i--) {
			if(parent[i][a] != parent[i][b]) {
				a = parent[i][a];
				b = parent[i][b];
			}
		}
		return parent[0][a];
	}
	
	public static void DFS(int n, int d) {
		visited[n] = true;
		depth[n] = d;
		
		for(int now : list[n]) {
			if(!visited[now]) {
				parent[0][now] = n;
				DFS(now, d+1);
			}
		}
	}
}