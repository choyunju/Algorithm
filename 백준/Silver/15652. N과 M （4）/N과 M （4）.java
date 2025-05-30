import java.io.*;
import java.util.*;

class Main {
	static int N, M;
	static StringBuilder builder = new StringBuilder();
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		arr = new int[M];
		
		backTracking(1, 0);
		System.out.println(builder);
	}
	
	public static void backTracking(int n, int index) {
		if(index == M) {
		
			for(int i=0; i<M; i++) {
				builder.append(arr[i] + " ");
			}
			builder.append("\n");
			return;
		}
		
		for(int i=n; i<=N; i++) {
			arr[index] = i;
			backTracking(i, index+1);
		}
		
	}
}