//문제17 - 1427
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		int[] A = new int[s.length()];
		for(int i=0; i<s.length(); i++) {
			A[i] = Integer.parseInt(s.substring(i, i+1));
		}
		
		for(int i=0; i<s.length(); i++) {
			int max = i;
			for(int j=i+1; j<s.length(); j++) {
				if(A[j] > A[max]) {
					max = j;  //max 값 찾기
				}
			}
			if(A[i] < A[max]) {
				int temp = A[i];
				A[i] = A[max];
				A[max] = temp;
			}	
		}
		for(int i=0; i<s.length(); i++) {
			System.out.print(A[i]);
		}
	}
}