import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int A = Integer.parseInt(token.nextToken());
		String[] B = token.nextToken().split("");
		
		String numString = "";
		for(int i=0; i<B.length; i++) {
			numString += B[i];
		}
		
		int num = Integer.parseInt(numString);
		int count = 1;
		
		while(num > A) {
			// 짝수인 경우
			if(num%2 == 0) {
				count++;
				num = num/2;
				B = Integer.toString(num).split("");
			} 
			// 홀수인 경우
			else if(B[B.length-1].equals("1")){
				numString = "";
				for(int i=0; i<B.length-1; i++) {
					numString += B[i]; 
				}
				count++;
				num = Integer.parseInt(numString);
				B = Integer.toString(num).split("");
			}
			else {
				break;
			}
		}
		
		if(num == A) {
			System.out.println(count);
		} else {
			System.out.println(-1);
		}
	}
}