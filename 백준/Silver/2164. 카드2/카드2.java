//no.4 - 2164
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		while(queue.size()!=1) {
			queue.poll();
			queue.add(queue.poll());
		}
		
		System.out.println(queue.poll());
	}
}