//no.50 - 1717
import java.io.*;
import java.util.*;

class Main{
	static int[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		StringBuilder builder = new StringBuilder();
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		num = new int[N+1];
		for(int i=0; i<=N; i++) {
			num[i] = i;
		}
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(reader.readLine());
			int op = Integer.parseInt(token.nextToken());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			if(op == 0) {
				union(a, b);
			}
			else if(op == 1) {
				if(find(a) == find(b)) {
					builder.append("YES\n");
				} else {
					builder.append("NO\n");
				}
			}
		}
		System.out.println(builder);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		num[b] = a;
	}
	
	public static int find(int a) {
		if(num[a] == a) {
			return a;
		}
		else {
			return find(num[a]);
		}
	}
}