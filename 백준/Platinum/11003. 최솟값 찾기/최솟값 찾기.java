//no. 11003
import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(token.nextToken());
		int L = Integer.parseInt(token.nextToken());
		Deque<int[]> q = new ArrayDeque<>();
		token = new StringTokenizer(reader.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(token.nextToken());
			while(!q.isEmpty() && q.peekLast()[0] > num) {
				q.pollLast();
			}
			q.offer(new int[] {num, i});
			
			if(q.peek()[1] < i-(L-1)) {
				q.poll();
			}
			writer.write(q.peek()[0] + " ");
		}
		writer.flush();
	}
}