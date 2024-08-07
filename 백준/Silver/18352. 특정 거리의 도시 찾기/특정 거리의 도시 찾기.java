//문제 46 - 18352
import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] A;
	static boolean[] visited;
	static int[] distance;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		int X = Integer.parseInt(token.nextToken());
		A = new ArrayList[N+1];
		visited = new boolean[N+1];
		distance = new int[N+1];
		for(int i =1; i<=N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			A[a].add(b);  //단방향
		}
		BFS(X);
		int result = 0;
		for(int i=1; i<=N; i++) {
			if(distance[i] == K) {
				System.out.println(i);
			}
			else {
				result++;
			}
		}
		if(result == N) {
			System.out.println(-1);
		}
	}
	
	public static void BFS(int node) { //최단경로를 보장하는 BFS 사용
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			for(int i : A[n]) {
				if(!visited[i]) {
					visited[i] = true;
					queue.add(i);
					distance[i] = distance[n] + 1;
				}
			}
		}
	}
}