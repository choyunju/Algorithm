//문제39 - 1747
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[] A = new int[10000001];
		for(int i=1; i<A.length; i++) {
			A[i] = i;
		}
		A[1] = 0;
		//소수 구하기
		for(int i=2; i<Math.sqrt(A.length); i++) {
			if(A[i] == 0) {
				continue;
			}
			for(int j=i+i; j<A.length; j=j+i) {
				A[j] = 0;
			}
		}
		
		int i = N;
		
		while(true) {
			if(A[i] != 0) {
				if(isPalindrom(A[i])) {
					System.out.println(A[i]);
					break;
				}
			}
			i++;
		}	
	}

	public static boolean isPalindrom(int number) {
		char[] c = String.valueOf(number).toCharArray();
		int s = 0;
		int e = c.length-1;
		while(s<e) {
			if(c[s] != c[e]) {
				return false;
			}
			s++;
			e--;
		}
		return true;
	}
}