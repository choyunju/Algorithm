import java.io.*;
import java.util.*;

class Main {
	static int N, M;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int[] distance;
	static int[] minList;

	static int first, second;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		// 0=첫번째 지점 / 1=두번째 지점 / 2=최단 왕복 시간의 합
		minList = new int[3];
		distance = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		minList[0] = 1;
		minList[1] = 2;
		minList[2] = Integer.MAX_VALUE;
		for(int i=1; i<=N-1; i++) {
			for(int j=i+1; j<=N; j++) {
				int min=0;
				Arrays.fill(distance, Integer.MAX_VALUE);
				visited = new boolean[N+1];
				BFS(i, 0);
				visited = new boolean[N+1];
				BFS(j, 0);
				for(int d=1; d<=N; d++) {
					min += 2 * distance[d];
				}
							
				if(minList[2] == min) {
					if(minList[0] > i) {
						minList[0] = i;
						minList[1] = j;
					} else if(minList[0] == i) {
						minList[1] = Math.min(minList[1], j);
					}
				} else if(minList[2] > min) {
					minList[0] = i;
					minList[1] = j;
					minList[2] = min;
				}
			}
		}
		for(int i=0; i<3; i++) {
			System.out.print(minList[i] + " ");
		}
//		Arrays.fill(distance, Integer.MAX_VALUE);
//		visited = new boolean[N+1];
//		BFS(1, 0);
//		visited = new boolean[N+1];
//		BFS(3, 0);
//		for(int i=1; i<=N; i++) {
//			System.out.println(distance[i]);
//		}
	}
	
	static void BFS(int n, int d) {	
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		visited[n] = true;
		int depth = 0;
		distance[n] = depth;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int next : list[now]) {
				if(!visited[next]) {
					visited[next] = true;
					distance[next] = Math.min(distance[next], distance[now]+1);
					queue.add(next);
				}
			}
		}
	}
}