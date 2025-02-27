import java.io.*;
import java.util.*;

class Node {
	int num;
	int edge;
	
	public Node(int num, int edge) {
		this.num = num;
		this.edge = edge;
	}
}

class Main {
	static ArrayList<Node>[] tree;
	static int[] edges;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		tree = new ArrayList[N+1];
		edges = new int[N+1];
		visited = new boolean[N+1];
		// N이 1인 경우일 때 NullPointer 에러가 발생하므로 tree[0]도 ArrayList 초기화해준다.
		for(int i=0; i<=N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		// 간선의 크기가 가장 큰 자식 노드
		int maxNode = 0;
		int maxEdge = 0;
		for(int i=0; i<N-1; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int parent = Integer.parseInt(token.nextToken());
			int child = Integer.parseInt(token.nextToken());
			int edge = Integer.parseInt(token.nextToken());
			tree[parent].add(new Node(child, edge));
			tree[child].add(new Node(parent, edge));
			if(maxEdge < edge) {
				maxEdge = edge;
				maxNode = child;
			}
		}
		
		setEdges(maxNode);
		int max = 0;
		int maxIndex = 0;
		for(int i=1; i<=N; i++) {
			if(max < edges[i]) {
				max = edges[i];
				maxIndex = i;
			}
		}
		Arrays.fill(visited, false);
		Arrays.fill(edges, 0);
		setEdges(maxIndex);
		int totalMax = 0;
		for(int i=1; i<=N; i++) {
			if(totalMax < edges[i]) {
				totalMax = edges[i];
			}
		}
		System.out.println(totalMax);
		
	}
	
	public static void setEdges(int node) {
		visited[node] = true;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(Node next : tree[now]) {
				if(!visited[next.num]) {
					visited[next.num] = true; 
					
					edges[next.num] = edges[now] + next.edge;
					queue.add(next.num);
				}
			}
		}
	}
}