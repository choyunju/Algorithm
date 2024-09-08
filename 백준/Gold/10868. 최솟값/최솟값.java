//no.72 - 10868
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
		int length = 0;
		int index = N;
		while(index>0) {
			length++;
			index/=2;
		}
		int treeSize = (int)Math.pow(2, length+1);
		tree = new long[treeSize];
		Arrays.fill(tree, Long.MAX_VALUE);
		int start = treeSize/2;
		
		for(int i=start; i<start+N; i++) {
			long a = Long.parseLong(reader.readLine());
			tree[i] = a;
		}
		setTree(treeSize-1);
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			a = start + a -1;
			b = start + b -1;
			builder.append(getMin(a, b) + "\n");
		}
		System.out.println(builder);
	}
	
	public static long getMin(int a, int b) {
		long min = Long.MAX_VALUE;
		while(a<=b) {
			if(a%2==1) {
				min = Math.min(min, tree[a]);
				a++;
			}
			if(b%2==0) {
				min = Math.min(min, tree[b]);
				b--;
			}
			a/=2;
			b/=2;
		}
		return min;
	}
	
	public static void setTree(int index) {
		while(index>0) {
			tree[index/2] = Math.min(tree[index], tree[index-1]);
			index -= 2;
		}
	}
}