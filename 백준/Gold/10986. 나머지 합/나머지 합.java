import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		long[] arr = new long[N];
		long[] sum = new long[N];
		long[] cnt = new long[M];
		long result=0;
		token = new StringTokenizer(reader.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(token.nextToken());	
		}
		sum[0] = arr[0];
		for(int i=1; i<N; i++) {
			sum[i] = sum[i-1] + arr[i];
		}
		
		for(int i=0; i<N; i++) {
			sum[i] %= M;
			cnt[(int)sum[i]]++;
		}
		
		for(int i=0; i<M; i++) {
			if(i==0) {
				result += cnt[i];
			}
			if(cnt[i] >= 2) {
				result = result + cnt[i]*(cnt[i]-1)/2;
			}
		}
		System.out.println(result);
	}
}