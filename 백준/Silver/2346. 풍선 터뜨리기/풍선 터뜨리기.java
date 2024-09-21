//no.6 - 2346
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());
		StringTokenizer token = new StringTokenizer(reader.readLine());
		Deque<Balloon> deque = new ArrayDeque<>();
	
		for(int i=1; i<=N; i++) {
			int num = Integer.parseInt(token.nextToken());
			deque.add(new Balloon(i, num));
		}
		Balloon balloon = deque.poll();
		int move = balloon.num;
		builder.append(balloon.index + " ");
		while(!deque.isEmpty()) {
			if(move > 0) {
				for(int i=1; i<move; i++) {
					deque.add(deque.poll());
				}
				balloon = deque.poll();
				move = balloon.num;
				builder.append(balloon.index+" ");
			}
			else {
				for(int i=1; i<-move; i++) {
					deque.addFirst(deque.pollLast());
				}
				balloon = deque.pollLast();
				move = balloon.num;
				builder.append(balloon.index+" ");
			}
		}
		System.out.println(builder);
	}
}

class Balloon {
	int index;
	int num;
	
	public Balloon(int index, int num) {
		this.index = index;
		this.num = num;
	}
}