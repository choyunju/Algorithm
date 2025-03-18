import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[] tips = new int[N+1];
		for(int i=1; i<=N; i++) {
			tips[i] = Integer.parseInt(reader.readLine());
		}
		
		Arrays.sort(tips);
		long total = 0;
		int num = 1;
		for(int i=N; i>=0; i--) {
			int tip = tips[i] - (num - 1);
			num++;
			if(tip < 0) {
				break; 
			}
			
			total += tip; 
		}
		System.out.println(total);
	}
}