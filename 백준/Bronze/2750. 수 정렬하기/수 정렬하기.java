//문제15 - 2750
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		StringBuilder result = new StringBuilder();
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(reader.readLine());
		}
		
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<N-1; j++) {
				if(A[j] > A[j+1]) {
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			result.append(A[i]).append("\n");
		}
		System.out.println(result);
	}
}