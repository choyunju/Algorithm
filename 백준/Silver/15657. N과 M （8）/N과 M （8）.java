import java.io.*;
import java.util.*;

class Main {
	static int N, M;
	static int[] arr;
	static int[] result;
	static StringBuilder builder = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(reader.readLine());
		arr = new int[N];
		result = new int[M];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		Arrays.sort(arr);
		backTracking(0, 0);
		System.out.println(builder);
	}
	
	public static void backTracking(int n, int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				builder.append(result[i] + " ");
			}
			builder.append("\n");
			return;
		}
		for(int i=n; i<N; i++) {
			result[depth] = arr[i];
			backTracking(i, depth+1);
		}
	}
}