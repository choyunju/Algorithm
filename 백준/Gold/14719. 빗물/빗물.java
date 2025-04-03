import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		int H = Integer.parseInt(token.nextToken());
		int W = Integer.parseInt(token.nextToken());
		int[] block = new int[W+1];
		int[] result = new int[W+1];
		
		token = new StringTokenizer(reader.readLine());
		for(int i=1; i<=W; i++) {
			block[i] = Integer.parseInt(token.nextToken());
		}
		for(int i=1; i<=W; i++) {
			result[i] = block[i];
		}
		
		for(int i=2; i<W; i++) {
			int start = i-1;
			int end = i+1;
			int now = i;
			while(1<=start && end<=W) {
				if(block[now] >= block[start]) {
					start--;
				}
				else if(block[now] >= block[end]) {
					end++;
				}
				else if(block[now] < block[start] && block[now] < block[end]) {
					break;
				}
			}
			
			if(1<=start && end<=W) {
				int min = Math.min(block[start], block[end]);
				for(int j=start+1; j<end; j++) {
					result[j] = min;
				}
				i = end-1;
			}
			
		}
		
		int sum = 0;
		for(int i=1; i<=W; i++) {
//			System.out.print(result[i] + " ");
			if(result[i] > block[i]) {
				sum += result[i] - block[i];
			}
		}
		System.out.println(sum);
		
	}
}