//문제 27
import java.util.*;
import java.io.*;

public class Main {
	static int[][] miro;
	static int[] dx = {0, 1, 0, -1}; //좌우
	static int[] dy = {1, 0, -1, 0}; //상하
	static boolean[][] visited;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		miro = new int[N][M];
		visited = new boolean[N][M];
		//미로 2차원 배열 채우기
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(reader.readLine());
			String line = token.nextToken();
			for(int j=0; j<M; j++) {
				miro[i][j] = Integer.parseInt(line.substring(j, j+1));
			}
		}
		BFS(0,0);
		System.out.println(miro[N-1][M-1]);
	}
	public static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int k=0; k<4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if(x>=0 && y>=0 && x<N && y<M) {
					if(visited[x][y]==false && miro[x][y] != 0) {
						visited[x][y] = true;
						miro[x][y] = miro[now[0]][now[1]] + 1; //깊이를 +1 해준다.
						queue.offer(new int[] {x, y});
					}
				}
			}
			
		}
		
	}
}