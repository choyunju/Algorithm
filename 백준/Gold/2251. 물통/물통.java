//no.49 - 2251
import java.util.*;
import java.io.*;

class Main {
	static int[] sender = {0, 0, 1, 1, 2, 2};
	static int[] receiver = {1, 2, 0, 2, 0, 1};
	static boolean[] result;
	static boolean[][] visited;
	static int[] now;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		StringBuilder builder = new StringBuilder();
		now = new int[3];
		now[0] = Integer.parseInt(token.nextToken());
		now[1] = Integer.parseInt(token.nextToken());
		now[2] = Integer.parseInt(token.nextToken());
		
		result = new boolean[201];
		visited = new boolean[201][201];
		BFS();
		for(int i=0; i<result.length; i++) {
			if(result[i] == true) {
				builder.append(i + " ");
			}
		}
		System.out.println(builder);
	}
	
	public static void BFS() {
		Queue<AB> queue = new LinkedList<>();
		queue.add(new AB(0,0));
		visited[0][0] = true;
		result[now[2]] = true;
		
		while(!queue.isEmpty()) {
			AB q = queue.poll();
			int A = q.A;
			int B = q.B;
			int C = now[2] - A - B;
			
			for(int i=0; i<6; i++) {
				int[] next = {A, B, C};
				next[receiver[i]] += next[sender[i]];
				next[sender[i]] = 0;
				if(next[receiver[i]] > now[receiver[i]]) {
					next[sender[i]] = next[receiver[i]] - now[receiver[i]];
					next[receiver[i]] = now[receiver[i]];
				}
				if(!visited[next[0]][next[1]]) {
					queue.add(new AB(next[0], next[1]));
					visited[next[0]][next[1]] = true;
					if(next[0] == 0) {
						result[next[2]] = true;
					}
				}
			}
		}
	}
}

class AB{
	int A;
	int B;
	public AB(int A, int B) {
		this.A = A;
		this.B = B;
	}
}
