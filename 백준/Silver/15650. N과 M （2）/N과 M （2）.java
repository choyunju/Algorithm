import java.io.*;
import java.util.*;

class Main {
	static boolean[] visited;
	static int[] arr;
	static int N, M;
	static StringBuilder builder = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		visited = new boolean[N+1];
		arr = new int[M];
		for(int i=1; i<=N; i++) {
			arr[0] = i;
			visited[i] = true;
			backTracking(i, 1);
		}
		System.out.println(builder);
	}
	
	public static void backTracking(int n, int index) {
		if(index == M) {
			for(int i=0; i<M; i++) {
				builder.append(arr[i] + " ");
			}
			builder.append("\n");
			return;
		}
		
		for(int i=n+1; i<=N; i++) {
			if(!visited[i]) {
				arr[index] = i;
				visited[i] = true;
				backTracking(i, index+1);
				visited[i] = false;
			}
		}
	}
}