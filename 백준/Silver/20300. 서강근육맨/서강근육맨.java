import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		long[] arr = new long[N];
		StringTokenizer token = new StringTokenizer(reader.readLine());

		for(int i=0; i<N; i++) {
			long m = Long.parseLong(token.nextToken());
			arr[i] = m;
		}
		
		Arrays.sort(arr);
		
		long max = 0;
		if(N%2==0) {
			for(int i=0; i<N/2; i++) {
				max = Math.max(max, arr[i] + arr[N-i-1]);
			}
		} else {
			max = arr[N-1];
			for(int i=0; i<N/2; i++) {
				max = Math.max(max, arr[i] + arr[N-i-2]);
			}
		}
		System.out.println(max);
	}
}