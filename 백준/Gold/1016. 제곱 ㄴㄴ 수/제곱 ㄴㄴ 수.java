//no. 1016
import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		long min = Long.parseLong(token.nextToken());
		long max = Long.parseLong(token.nextToken());
		long result = max-min+1;
		
		boolean[] check = new boolean[(int)result];
		
		for(long i=2; i*i<=max; i++) {
			long pow = i*i;
			long temp = min/pow;
			if(min%pow != 0) {
				temp++;
			}
			for(long j=temp; j*pow<=max; j++) {
				int c = (int)(j*pow-min);
				if(!check[c]) {
					check[c] = true;
					result--;
				}
			}
		}
		
		System.out.println(result);
		
	}
}