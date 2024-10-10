//no.13 - 22942
import java.io.*;
import java.util.*;

class Main {
	static boolean flag = false;
	static class Checker implements Comparable<Checker> {
		int no;
		int dot;
		
		public Checker(int no, int dot) {
			this.no = no;
			this.dot = dot;
		}

		@Override
		public int compareTo(Checker o) {
			if(this.dot == o.dot) {
				flag = true;
			}
			return this.dot - o.dot;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		PriorityQueue<Checker> pq = new PriorityQueue<>();
		Stack<Integer> stack = new Stack<>();

		for(int i=0; i<N; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(token.nextToken());
			int r = Integer.parseInt(token.nextToken());
			pq.add(new Checker(i, x-r));
			pq.add(new Checker(i, x+r));
		}
		
		if(flag) {
			System.out.println("NO");
			return;
		}
		
		while(!pq.isEmpty()) {
			if(stack.isEmpty()) {
				stack.push(pq.poll().no);
			} else {
				int no = pq.poll().no;
				if(stack.peek() == no) {
					stack.pop();
				} else {
					stack.push(no);
				}
			}
		}
		if(stack.isEmpty()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
