import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int count = 0;
		while(N>0) {
			if(N%5==0) { // 5의 배수는 무조건 5원으로만 나눠주는 것이 가장 최소의 경우
				count = N/5;
				N=0;
				
			} else if(N>10) {
				N -= 5;
				count++;
			} else if(N<10) {
				if(N%2==0) {
					count = count + (N/2);
					N=0;
					
				} else {
					N -= 5;
					count++;
				}
			}
		}
		if(N==0) {
			System.out.println(count);
		} else {
			System.out.println(-1);
		}
		
		
	}
}