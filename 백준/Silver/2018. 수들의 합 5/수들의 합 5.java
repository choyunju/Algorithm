import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		
		long result = 1;
		int start = 1; int end = 1;
		long sum = 1;
		
		while(start <= end && end<N) {
			if(sum >= N) {
				if(sum == N) {
					result++;
				}
				sum -= start;
				start++;
			}
			else {
				end++;
				sum += end;
			}
		}
		
		System.out.println(result);
	}
}