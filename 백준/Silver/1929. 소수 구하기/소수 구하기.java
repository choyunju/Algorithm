//문제37 - 1929
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int M = Integer.parseInt(token.nextToken());
		int N = Integer.parseInt(token.nextToken());
		int[] A = new int[N+1];
		for(int i=1; i<=N; i++) {
			A[i] = i;
		}
		A[1] = 0;  //1은 소수가 아니므로 제외
		//2부터 시작
		
		for(int i=2; i<=N; i++) {
			if(A[i] != 0) {
				int n = 2;
				int index = i * n;
				while(index <= N) {
					A[index] = 0;
					n++;
					index = i * n;
				}
			}
		}
		for(int i=M; i<=N; i++) {
			if(A[i] != 0) {
				writer.write(A[i] + "\n");
			}
		}
		writer.flush();
	}
}