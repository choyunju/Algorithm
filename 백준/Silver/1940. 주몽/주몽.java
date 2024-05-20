import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int M = Integer.parseInt(reader.readLine());
		int[] num = new int[N];
		StringTokenizer token = new StringTokenizer(reader.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(token.nextToken());
		}

		int result = 0;
		Arrays.sort(num);
		for(int i=0; i<N-1; i++) {
			int end = i+1;
			while(end<N) {
				int sum = num[i] + num[end];
				if(sum == M) {
					result++;
					break;
				}
				else {
					end++;
				}
			}
		}
		System.out.println(result);
		
	}
}