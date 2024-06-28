import java.util.*;

import javax.swing.InputMap;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int one = 0;
		boolean zero = false;
		
		PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minus = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(reader.readLine());
			if( n>1 ) {
				plus.add(n);
			}
			else if(n == 1) {
				one++;
			}
			else if(n==0) {
				zero = true;
			}
			else {
				minus.add(n);
			}
		}
		int sum = 0;
	
		while(plus.size()>1) {
			int a = plus.poll();
			int b = plus.poll();
			sum += a * b;	
		}
		if(plus.size()==1) {
			sum += plus.poll();
		}
		
		sum += one;
		while(minus.size() > 1)  {
			int a = minus.poll();
			int b = minus.poll();
			sum += a * b;
		}
		
		if(minus.size() == 1 && !zero) {
			sum += minus.poll();
		}
		else if(minus.size()==1 && zero) {
			sum += 0;
		}
		System.out.println(sum);
	}
}