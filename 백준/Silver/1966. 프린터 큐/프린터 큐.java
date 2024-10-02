////no.8 - 1966
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int caseNum = Integer.parseInt(reader.readLine());
		
		for(int i=0; i<caseNum; i++) {
			LinkedList<int[]> queue = new LinkedList<>();
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int N = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());
			token = new StringTokenizer(reader.readLine());
			for(int j=0; j<N; j++) {
				int value = Integer.parseInt(token.nextToken());
				queue.add(new int[] {j, value});
			}
			
			int count = 0;
			
			while(!queue.isEmpty()) {
				int[] front = queue.poll();
				boolean isMax = true;
				
				for(int j=0; j<queue.size(); j++) {
					if(front[1] < queue.get(j)[1]) {
						queue.add(front);
						for(int k=0; k<j; k++) {
							queue.add(queue.poll());
						}
						isMax = false;
						break;
					}
				}
				
				if(!isMax) {
					continue;
				}
				count++;
				if(front[0] == M) {
					break;
				}
			}
			builder.append(count+"\n");
		}
		System.out.println(builder);
	}
}
