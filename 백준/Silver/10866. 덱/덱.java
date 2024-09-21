//no.5 - 10866
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int N  = Integer.parseInt(reader.readLine());
		Deque<Integer> deque = new LinkedList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			String s = token.nextToken();
			if(s.equals("push_front")) {
				int a = Integer.parseInt(token.nextToken());
				deque.addFirst(a);
			} else if(s.equals("push_back")) {
				int a = Integer.parseInt(token.nextToken());
				deque.addLast(a);
			} else if(s.equals("pop_front")) {
				if(deque.isEmpty()) {
					builder.append("-1\n");
				} else {
					builder.append(deque.pollFirst() + "\n");
				}
			} else if(s.equals("pop_back")) {
				if(deque.isEmpty()) {
					builder.append("-1\n");
				} else {
					builder.append(deque.pollLast() + "\n");
				}
			} else if(s.equals("size")) {
				builder.append(deque.size()+"\n");
			} else if(s.equals("empty")) {
				if(deque.isEmpty()) {
					builder.append("1\n");
				} else {
					builder.append("0\n");
				}
			} else if(s.equals("front")) {
				if(deque.isEmpty()) {
					builder.append("-1\n");
				} else {
					builder.append(deque.peekFirst() + "\n");
				}
			} else if(s.equals("back")) {
				if(deque.isEmpty()) {
					builder.append("-1\n");
				} else {
					builder.append(deque.peekLast() + "\n");
				}
			}
		}
		System.out.println(builder);
	}
}