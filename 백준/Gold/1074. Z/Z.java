import java.io.*;
import java.util.*;

class Main {
	static int N, r, c;
	static int count=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(token.nextToken());
		r = Integer.parseInt(token.nextToken());
		c = Integer.parseInt(token.nextToken());
		int length = (int)Math.pow(2, N);
		
		findCount(length, r, c);
		System.out.println(count);
	}
	
	public static void findCount(int length, int r, int c) {
		if(length == 1) {
			return;
		}
		
		if(r<length/2 && c<length/2) {
			findCount(length/2, r, c);
		} else if(r<length/2 && c>=length/2) {
			count+= (length * length/4);
			findCount(length/2, r, c-length/2);
		} else if(r>=length/2 && c<length/2) {
			count+= (length * length/4)*2;
			findCount(length/2, r-length/2, c);
		} else {
			count+= (length * length/4)*3;
			findCount(length/2, r-length/2, c-length/2);
		}
	}
}