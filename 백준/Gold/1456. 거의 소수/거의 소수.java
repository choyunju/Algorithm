import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		long A = scanner.nextLong();
		long B = scanner.nextLong();
		long[] N = new long[10000001];
		
		for(int i=1; i<=10000000; i++) {
			N[i] = i;
		}
		//소수 구하기
		N[1] = 0;
		for(int i=2; i<=Math.sqrt(N.length); i++) {
			if(N[i] == 0) {
				continue;
			}
			for(int j = i + i; j<N.length; j=j+i) {  //배수 지우기
				N[j] = 0;
			}
		}
		
		int count = 0;
		for(int i=2; i<10000001; i++) {
			if(N[i] != 0) {
				long temp = N[i];
				while((double)N[i] <= (double)B/(double)temp) {
					if((double)N[i] >= (double)A/(double)temp) {
						count++;
					}
					temp = temp * N[i];
				}
			}
		}
		System.out.println(count);
	}
}