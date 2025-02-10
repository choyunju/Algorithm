import java.util.*;
import java.io.*;

class Main {
	static int N;
	static int[] num;
	static int[] answer;
	static boolean[] visited;
	static StringBuilder builder;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		builder = new StringBuilder();
		N = Integer.parseInt(reader.readLine());
		num = new int[N];
		answer = new int[N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			num[i] = i+1;
		}
		
		permutation(0);
	}
	
	static void permutation(int depth) {
		if(depth == N) {
			for(int n : answer) {
				builder.append(n + " ");
			}
			System.out.println(builder);
			builder = new StringBuilder();
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				answer[depth] = i+1;
				permutation(depth+1);
				visited[i] = false;
			}
		}
	}
}