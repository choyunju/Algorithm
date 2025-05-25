import java.io.*;
import java.util.*;

class Main {
	static int N;
	static int M;
	static boolean[] visited;
	static int[] arr;
	static StringBuilder builder = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		visited = new boolean[N+1];
		arr = new int[M];
		backTracking(0);
		System.out.println(builder);
	}
	
	static void backTracking(int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				builder.append(arr[i] + " ");
			}
			builder.append("\n");
			return;
		}
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				arr[depth] = i;
				visited[i] = true;
				backTracking(depth+1);
				visited[i] = false;
			}
		}
	}
}