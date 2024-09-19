//no. 1158
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		StringBuilder builder = new StringBuilder();
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		builder.append("<");
		while(queue.size()!=1) {
			for(int i=0; i<K-1; i++) {
				queue.add(queue.poll());
			}
			builder.append(queue.poll()+", ");
		}
		builder.append(queue.poll()+">");
		System.out.println(builder);
	}
}