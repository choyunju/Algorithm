//문제30 - 2343
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		
		int[] n = new int[N];
		token = new StringTokenizer(reader.readLine());
		
		int start = 0;
		int end = 0;
		for(int i=0; i<N; i++) {
			n[i] = Integer.parseInt(token.nextToken());
			if(start < n[i]) {
				start = n[i];
			}
			end += n[i];
		
		}
		
		
		while(start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;
			int count = 0;
			for(int i=0; i<N; i++) {
				if(sum + n[i] > mid) {
					count++;
					sum = 0;
				}
				sum += n[i];
			}
			if(sum != 0) {
				count++;
			}
			if(count <= M) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		System.out.println(start);
	}
}