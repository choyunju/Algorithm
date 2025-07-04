import java.io.*;
import java.util.*;

class Main {
	static ArrayList<Integer>[] list;
	static int[][] map;
	static int N;

	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		list = new ArrayList[N];
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
	
			for(int j=0; j<N; j++) {
				int node = Integer.parseInt(token.nextToken());
				if(node != 0) {
					list[i].add(j);
					map[i][j] = 1;
				}
			}
		}
	
		for(int i=0; i<N; i++) {
			BFS(i);
		}
		
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				builder.append(map[i][j] + " ");
			}
			builder.append("\n");
		}
		System.out.println(builder);
	}
	
	public static void BFS(int node) {
		boolean[] visited = new boolean[N];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int next : list[now]) {
				if(!visited[next]) {
					visited[next] = true;
					queue.add(next);
					map[node][next] = 1;
				}
			}
		}
	}
}