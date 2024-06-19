//문제23 - 11724
import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] A;
	static Stack<Integer> stack;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		
		A = new ArrayList[N+1];
		stack = new Stack<>();
		visited = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			A[i] = new ArrayList<>();
			visited[i] = false;
		}
		
		//인접 리스트 만들기
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(reader.readLine());
			int n1 = Integer.parseInt(token.nextToken());
			int n2 = Integer.parseInt(token.nextToken());
			A[n1].add(n2);
			A[n2].add(n1);
		}
		
		for(int i=0; i<A[1].size(); i++) {
			stack.push(A[1].get(i));
		}
		int count = 0;
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				DFS(i);
				count++;
			}			
		}
		System.out.println(count);
	}
		
	public static void DFS(int node) {
		//방문한 노드일 경우 return
		if(visited[node]) {
			return;
		}
		visited[node] = true;
		for(int i : A[node]) {
			if(visited[i] == false) {
				DFS(i);
			}
		}
	}
}