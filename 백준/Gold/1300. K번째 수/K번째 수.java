//문제31 - 1300
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int K = Integer.parseInt(reader.readLine());
		
		int start = 1;
		int end = K;
		int ans = 0;
		while(start <= end) {
			int mid = (start + end)/2;
			int count = 0; //mid보다 작은 수의 개수
			for(int i=1; i<=N; i++) {
				int n = Math.min(mid/i, N);
				count += n;
			}
			if(count < K) {
				start = mid + 1;
			}
			else {
				ans = mid;
				end = mid -1;
			}
		}
		System.out.println(ans);
	}
}