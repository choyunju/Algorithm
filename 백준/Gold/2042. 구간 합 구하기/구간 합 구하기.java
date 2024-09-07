//no.71 - 2042
import java.io.*;
import java.util.*;

class Main {
	static long[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		StringBuilder builder = new StringBuilder();
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		int length=0;
		int num = N;
		while(num != 0) {
			num /= 2;
			length++;
		}
		int treeSize = (int)Math.pow(2, length+1);
		tree = new long[treeSize];
		int start = treeSize/2;
		for(int i=start; i<start+N; i++) {
			tree[i] = Long.parseLong(reader.readLine());
		}
		setTree(treeSize-1);
		
		for(int i=0; i<M+K; i++) {
			token = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			long c = Long.parseLong(token.nextToken());
			if(a == 1) {
				b = start + b - 1;
				changeTree(b, c);
			}else if(a == 2) {
				b = start + b - 1;
				c = start + c - 1;
				builder.append(getSum(b, (int)c) + "\n");
			}
		}
		System.out.println(builder);
	}
	
	public static void setTree(int i) {
		while(i>1) {
			tree[i/2] += tree[i];
			i--;
		}
	}
	
	public static void changeTree(int i, long v) {
		long diff = v - tree[i];
		while(i>0) {
			tree[i] += diff;
			i = i/2;
		}
	}
	
	public static long getSum(int s, int e) {
		long sum = 0;
		while(s<=e) {
			if(s%2 == 1) {
				sum += tree[s];
				s++;
			} 
			if(e%2 == 0) {
				sum += tree[e];
				e--;
			}
			s /= 2;
			e /= 2;
		}
		return sum;
	}
}