//문제 32 - 11047
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		int[] coin = new int[N];
		int count = 0;
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(reader.readLine());
			coin[i] = Integer.parseInt(token.nextToken());
		}
		
		while(K!=0) {
			for(int i=N-1; i>=0; i--) {
				int n = K/coin[i];
				if(n < 0) {
					break;
				}
				else {
					K = K - (coin[i] * n);
					count += n;
				}
			}
		}
		System.out.println(count);
	}
}