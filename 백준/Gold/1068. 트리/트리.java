//no.68 - 1068
import java.util.*;
import java.io.*;

class Main {
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	static int result, M;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		tree = new ArrayList[N];
		for(int i=0; i<N; i++) {
			tree[i] = new ArrayList<>();
		}
		visited = new boolean[N];
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int root = 0;
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(token.nextToken());
			if(a != -1) {
				tree[a].add(i);
			} else if(a == -1) {
				root = i;
			}
		}
		M = Integer.parseInt(reader.readLine());
		if(M == root) {
			System.out.println(0);
		} else {
			DFS(root);
			System.out.println(result);
		}
		
		
	}
	
	public static void DFS(int n) {
		visited[n]=true;
		int child = 0;
		for(int now : tree[n]) {
			if(!visited[now] && now!=M) {
				child++;
				DFS(now);
			}
		}
		if(child == 0) {
			result++;
		}
	}
}