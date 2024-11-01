import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<N; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			for(int j=0; j<N; j++) {
				int a = Integer.parseInt(token.nextToken());
				queue.add(a);
			}
		}
		
		for(int i=0; i<N-1; i++) {
			queue.poll();
		}
		System.out.println(queue.poll());
	}
}