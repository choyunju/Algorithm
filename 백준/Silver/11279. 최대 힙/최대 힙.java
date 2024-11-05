import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		int N = Integer.parseInt(reader.readLine());
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(reader.readLine());
			if(a==0) {
				if(queue.isEmpty()) {
					builder.append("0\n");
				} else {
					builder.append(queue.poll()+"\n");
				}
				
			} else {
				queue.add(a);
			}
		}
		System.out.println(builder);
	}
}