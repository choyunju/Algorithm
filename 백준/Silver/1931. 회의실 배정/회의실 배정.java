//no. 1931
import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		PriorityQueue<Presentation> queue = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(token.nextToken());
			int e = Integer.parseInt(token.nextToken());
			
			queue.add(new Presentation(s, e));
		}
		int count = 0;
		int time = 0;
		while(!queue.isEmpty()) {
			Presentation t = queue.poll();
			if(time <= t.startTime) {
				count++;
				time = t.endTime;
			}
		}
		System.out.println(count);
	}
}
 
class Presentation implements Comparable<Presentation> {
	int startTime;
	int endTime;
	
	Presentation(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	@Override
	public int compareTo(Presentation p1) {
		if(this.endTime == p1.endTime) {
			return this.startTime - p1.startTime;
		}
		return this.endTime - p1.endTime;
	}
}