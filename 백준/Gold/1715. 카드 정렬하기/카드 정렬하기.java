//no. 1715
import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			queue.add(Integer.parseInt(reader.readLine()));
		}
		int count = 0;
		if(queue.size() == 1) {
			System.out.println(count);
		}
		else {
			while(queue.size() >= 2) {
				int a = queue.poll();
				int b = queue.poll();
				int c = a + b;
				count += c;
				if(queue.isEmpty()) {
					break;
				}
				queue.add(c);
			}
			
			System.out.println(count);
		}
	}
}