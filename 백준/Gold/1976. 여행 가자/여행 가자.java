//no.51 - 1976
import java.io.*;
import java.util.*;

class Main {
	static int[] city;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int M = Integer.parseInt(reader.readLine());
		city = new int[N+1];
		for(int i=0; i<=N; i++) {
			city[i] = i;
		}
		
		for(int i=1; i<=N; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			for(int j=1; j<=N; j++) {
				int a = Integer.parseInt(token.nextToken());
				if(a == 1) {
					union(i, j);
				}
			}
		}
		int[] route = new int[M];
		StringTokenizer token = new StringTokenizer(reader.readLine());
		for(int i=0; i<M; i++) {
			route[i] = Integer.parseInt(token.nextToken());
		}
		int index = find(route[0]);
		for(int i=1; i<M; i++) {
			if(index != find(route[i])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		
	}
	
	public static void union(int start, int end) {
		start = find(start);
		end = find(end);
		if(start != end) {
			city[end] = start;
		}
	}
	
	public static int find(int a) {
		if(city[a] == a) {
			return a;
		} else {
			return find(city[a]);
		}
	}
}