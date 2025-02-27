import java.io.*;
import java.util.*;

class Main {
	static ArrayList<Integer>[] tree;
	static int[][] parentList;
	static boolean[] visited;
	static int a, b;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		StringBuilder builder = new StringBuilder();
		for(int j=0; j<T; j++) {
			int N = Integer.parseInt(reader.readLine());
			tree = new ArrayList[N+1];
			for(int i=1; i<=N; i++) {
				tree[i] = new ArrayList<>();
			}
			parentList = new int[N+1][2];
			visited = new boolean[N+1];
			StringTokenizer token;
			for(int i=0; i<N-1; i++) {
				token = new StringTokenizer(reader.readLine());
				int parent = Integer.parseInt(token.nextToken());
				int child = Integer.parseInt(token.nextToken());
				tree[parent].add(child);
				tree[child].add(parent);
				parentList[child][0] = parent;
			}
			token = new StringTokenizer(reader.readLine());
			int n1 = Integer.parseInt(token.nextToken());
			int n2 = Integer.parseInt(token.nextToken());
			
			//루트 찾기
			int root = 0;
			for(int i=1; i<=N; i++) {
				if(parentList[i][0] == 0) {
					root = i;
				}
			}
			
			//깊이 설정하기
			int depth = 1;
			DFS(root, depth);
			if(parentList[n1][1] == parentList[n2][1]) {
				int result = findParent(n1, n2);
				builder.append(result).append("\n");
			} else {
				//깊이 맞추기
				setDepth(n1, n2);
				if(a == b) {
					builder.append(a).append("\n");
				} else {
					int result = findParent(a, b);
					builder.append(result).append("\n");
				}
			}			
		}
		System.out.println(builder);
	}
	
	public static void setDepth(int n1, int n2) {
		if(parentList[n1][1] == parentList[n2][1]) {
			a = n1;
			b = n2;
			return;
		} else if(parentList[n1][1] < parentList[n2][1]) {
			n2 = parentList[n2][0];
			setDepth(n1, n2);
		} else {
			n1 = parentList[n1][0];
			setDepth(n1, n2);
		}
	}
	
	public static int findParent(int a, int b) {
		if(parentList[a][0] == parentList[b][0]) {
			return parentList[a][0];
		} else {
			return findParent(parentList[a][0], parentList[b][0]);
		}
	}
	
	public static void DFS(int node, int depth) {
		visited[node] = true;
		parentList[node][1] = depth;
		depth++;
		for(int next : tree[node]) {
			if(!visited[next]) {
				DFS(next, depth);
			}
		}
	}
	

}