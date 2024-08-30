//no.65 - 17472
import java.util.*;
import java.io.*;

class Main {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int[][] map;
	static boolean[][] visited;
	static int N, M, sNum;
	static ArrayList<int[]> island;  //하나의 섬에 대한 정보 저장(r, c 저장)
	static ArrayList<ArrayList<int[]>> sumList;  //전체 섬에 대한 정보 저장
	static PriorityQueue<Edge> queue;  //모든 다리(에지)들을 저장하는 큐
	static int[] parent;  //union, find를 하기 위한 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(reader.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(token.nextToken());  //map 정보 저장하기
			}
		}
		
		sNum = 1;  //처음 섬의 번호는 1부터 시작
		sumList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					BFS(i, j);  //BFS를 통해 섬 구분하기
					sNum++;
					sumList.add(island);  //하나의 섬에 대한 정보가 저장되면 전체 섬 리스트에 추가
				}
			}
		}
		queue = new PriorityQueue<>();
		for(int i=0; i<sumList.size(); i++) {  //섬의 각 지점에서 만들 수 있는 모든 에지 저장하기
			ArrayList<int[]> now = sumList.get(i);
			for(int j=0; j<now.size(); j++) {
				int r = now.get(j)[0];
				int c = now.get(j)[1];
				int nowSum = map[r][c];  //현재 섬의 번호
				for(int d=0; d<4; d++) {  //네 방향 검색하기
					int tempR = dr[d];
					int tempC = dc[d];
					int length = 0;  //다리의 길이
					while(r+tempR>=0 && r+tempR<N && c+tempC>=0 && c+tempC<M) {
						if(map[r+tempR][c+tempC] == nowSum) {  //같은 섬이면 에지 만들기 불가
							break;
						} else if(map[r+tempR][c+tempC] != 0) {  //바다도 아니고 같은 섬도 아닌 경우 모든 다리를 저장하는 큐에 추가
							if(length > 1) {
								queue.add(new Edge(nowSum, map[r+tempR][c+tempC], length));
							}
							break;
						} else {  //바다일 경우 다리 길이 연장
							length++;
						}
						if(tempR<0) tempR--;
						else if(tempR>0) tempR++;
						else if(tempC<0) tempC--;
						else if(tempC>0) tempC++;
					}
				}
			}
		}
		//최소 신장 거리 구하기
		parent = new int[sNum];
		for(int i=1; i<sNum; i++) {
			parent[i] = i;
		}
		int useEdge=0;
		int result=0;
		while(!queue.isEmpty()) {
			Edge edge = queue.poll();
			if(find(edge.s) != find(edge.e)) {
				union(edge.s, edge.e);
				result += edge.v;
				useEdge++;
			}
		}
		if(useEdge == sNum-2) {  //에지는 섬의 개수-1개가 되어야한다. 이때 섬의 개수를 1부터 시작했으니 -2를 했다.
			System.out.println(result);
		} else {
			System.out.println("-1");
		}
	}
	
	public static int find(int n) {
		if(parent[n] == n) {
			return n;
		}
		else {
			return find(parent[n]);
		}
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			parent[b] = a;
		}
	}
	
	public static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		island = new ArrayList<>();
		int[] start = {i ,j};
		island.add(start);
		queue.add(start);
		visited[i][j] = true;
		map[i][j] = sNum;
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			int r = now[0];
			int c = now[1];
			for(int d=0; d<4; d++) {  //네 방향 검색하기
				int tempR = dr[d];
				int tempC = dc[d];
				while(r+tempR>=0 && r+tempR<N && c+tempC>=0 && c+tempC<M) {
					if(!visited[r+tempR][c+tempC] && map[r+tempR][c+tempC] != 0) {  //바다가 아니고 방문하지 않았다면
						sameIsland(r+tempR, c+tempC, queue);  //같은 섬으로 추가
					} else {
						break;
					}
					if(tempR<0) tempR--;
					else if(tempR>0) tempR++;
					else if(tempC<0) tempC--;
					else if(tempC>0) tempC++;
				}
			}
		}
	}
	
	public static void sameIsland(int r, int c, Queue<int[]> queue) {
		map[r][c] = sNum;
		visited[r][c] = true;
		int[] temp = {r,c};
		queue.add(temp);
		island.add(temp);
	}
}

class Edge implements Comparable<Edge> {
	int s, e, v;
	public Edge(int s, int e, int v) {
		this.s = s;
		this.e = e;
		this.v = v;
	}
	
	public int compareTo(Edge e) {
		return this.v - e.v;
	}
}