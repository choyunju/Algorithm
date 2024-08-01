//1850
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args ) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		StringBuilder builder = new StringBuilder();
		long a = Long.parseLong(token.nextToken());
		long b = Long.parseLong(token.nextToken());
		
		long result = MOD(a, b);
		while(result>0) {
			builder.append("1");
			result--;
		}
		System.out.println(builder);
		
	}
	
	public static long MOD(long a, long b) {
		long remainder = a % b;
		if(remainder == 0) {
			return b;
		}
		else {
			return MOD(b, remainder);
		}
	}
}