import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		
		ArrayList[] list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		StringBuilder builder = new StringBuilder();
		int M = Integer.parseInt(reader.readLine());
		for(int i=0; i<M; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			
			if(a == 2) {
				builder.append("yes").append("\n");
			} else {
				if(list[b].size() >= 2) {
					builder.append("yes\n");
				} else {
					builder.append("no\n");
				}
			}
		}
		
		System.out.println(builder);
	}
}