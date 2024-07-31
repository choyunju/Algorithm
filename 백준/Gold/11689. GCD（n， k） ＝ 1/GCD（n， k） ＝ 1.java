//11689
import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(reader.readLine());
		long result = N;
		
		for(long i=2; i<=Math.sqrt(N); i++) {
			if(N%i == 0) {
				result = result - result/i;
				while(N%i == 0) {
					N /= i;
				}
			}
		}
		if(N > 1) {
			result = result - result/N;
		}
		System.out.println(result);
	}
}