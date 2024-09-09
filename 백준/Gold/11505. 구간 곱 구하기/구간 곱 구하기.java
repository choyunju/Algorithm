//no.73 - 11505
import java.io.*;
import java.util.*;

class Main {
	static long[] tree;
	static int MOD = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		StringBuilder builder = new StringBuilder();
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		int index = N;
		int length=0;
		while(index>0) {
			length++;
			index /= 2;
		}
		int treeSize = (int)Math.pow(2, length+1);
		int start = treeSize/2;
		tree = new long[treeSize];
		Arrays.fill(tree, 1);
		for(int i=start; i<start+N; i++) {
			long a = Long.parseLong(reader.readLine());
			tree[i] = a;
		}
		setTree(treeSize-1);
		for(int i=0; i<M+K; i++) {
			token = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			long c = Long.parseLong(token.nextToken());
			if(a==1) {
				b = start + b -1;
				changeTree(b, c);
			} else if(a==2) {
				b = start + b -1;
				c = start + c -1;
				long result = getMul(b, (int)c);
				builder.append(result + "\n");
			}
		}
		System.out.println(builder);
	}
	
	public static long getMul(int s, int e) {
		long mul = 1;
		while(s<=e) {
			if(s%2 == 1) {
				mul = mul * tree[s] % MOD;
				s++;
			}
			if(e%2 == 0) {
				mul = mul * tree[e] % MOD;
				e--;
			}
			s /= 2;
			e /= 2;
		}
		return mul;
	}
	
	public static void changeTree(int index, long c) {
		tree[index] = c;
		while(index>1) {
			index /= 2;
			tree[index] = tree[index*2]%MOD * tree[index*2+1]%MOD;
		}
	}
	
	public static void setTree(int index) {
		while(index>0) {
			tree[index/2] = tree[index/2] * tree[index] % MOD;
			index--;
		}
	}
}