//no. 2023
import java.io.*;
import java.util.*;

class Main {
	public static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		DFS(1,2);
		DFS(1,3);
		DFS(1,5);
		DFS(1,7);
	}
	
	public static boolean isPrime(int num) {
		//소수가 아닌 경우
		if(num < 2) {return false;}
		
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num % i == 0) { return false; }
		}
		
		return true;
	}

	public static void DFS(int digit, int n) {
		if(digit == N) {
			if(isPrime(n)) {
				System.out.println(n);
				return;
			}
		}
		
		for(int i=0; i<10; i++) {
			if(i % 2 == 0) {continue;}
			else {
				int num = 10 * n + i;
				if(isPrime(num)) {
					DFS(digit+1, num);
				}
			}
		}
	}
}