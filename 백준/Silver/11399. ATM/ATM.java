//no.11399
import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int N = Integer.parseInt(reader.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int[] time = new int[N];
		StringTokenizer token = new StringTokenizer(reader.readLine());
		for(int i=0; i<N; i++) {
			queue.add(Integer.parseInt(token.nextToken()));
		}
		for(int i=0; i<N; i++) {
			sum += queue.poll();
			time[i] = sum;
		}
		int result = 0;
		for(int i=0; i<N; i++) {
			result += time[i];
		}
		System.out.println(result);
	}
}