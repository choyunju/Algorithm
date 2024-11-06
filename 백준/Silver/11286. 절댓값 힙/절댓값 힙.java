import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		StringBuilder builder = new StringBuilder();
		PriorityQueue<Num> queue = new PriorityQueue<>();
	
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(reader.readLine());
			int v = x;
			if(x == 0) {
				if(queue.isEmpty()) {
					builder.append("0\n");
				} else {
					builder.append(queue.poll().x+"\n");
				}
			} else {
				if(x<0) {
					v = (-1) * x;
				}
				queue.add(new Num(x, v));
			}
		}
		System.out.println(builder);
	}
}

class Num implements Comparable<Num> {
	int x, v;
	
	@Override
	public int compareTo(Num o) {
		if(this.v == o.v) {
			return this.x - o.x;
		}
		return this.v - o.v;
	}
	
	public Num(int x, int v) {
		this.x = x;  //원래 숫자
		this.v = v;  // 절댓값 숫자
	}
	
}