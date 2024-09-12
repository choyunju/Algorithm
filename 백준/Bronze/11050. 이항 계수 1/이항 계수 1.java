//no.76 - 11050
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		
		int a = 1;
		int b = 1;
		for(int i=0; i<K; i++) {
			a = a*(N-i);
		}
		for(int i=0; i<K; i++) {
			b = b*(K-i);
		}
		System.out.println(a/b);
	}
}