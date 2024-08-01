//문제 42 - 1934
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(reader.readLine());
		for(int i=0; i<T; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			int result = (a*b)/GCD(a,b);
			writer.write(result+"\n");
		}
		writer.flush();
	}
	public static int GCD(int a, int b) {
		if(a == 0) {
			return b;
		}
		else {
			int remainder = b % a;
			return GCD(remainder, a);
		}
	}
}