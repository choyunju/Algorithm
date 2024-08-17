//no.54 - 1516
import java.io.*;
import java.util.*;

class Main {
	static ArrayList<Integer>[] list;
	static int[] indegree;
	static int[] time;
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());
		
		list = new ArrayList[N+1];
		indegree = new int[N+1];
		time = new int[N+1];
		result = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<=N; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int t = Integer.parseInt(token.nextToken());
			time[i] = t;
			int num = Integer.parseInt(token.nextToken());
			while(num != -1) {
				list[num].add(i);
				indegree[i]++;
				num = Integer.parseInt(token.nextToken());
			}
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();

			for(int n : list[now]) {
				indegree[n]--;
				result[n] = Math.max(result[n], result[now] + time[now]);
				if(indegree[n] == 0) {
					queue.add(n);
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			builder.append(result[i] + time[i]+ "\n");
		}
		System.out.println(builder);
	}
}


