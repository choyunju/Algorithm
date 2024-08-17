//no.53 - 2252
import java.io.*;
import java.util.*;

class Main {
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int[] indegree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		StringBuilder builder = new StringBuilder();
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		indegree = new int[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			list[a].add(b);
			indegree[b]++;
		}
		int start = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) {
				queue.add(i);
			}
		}
	
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			builder.append(now + " ");
			for(int n : list[now]) {
				indegree[n]--;
				if(indegree[n] == 0) {
					queue.add(n);
				}
			}
		}
		
		System.out.println(builder);
	}
	
}