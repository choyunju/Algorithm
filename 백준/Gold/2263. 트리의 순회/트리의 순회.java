import java.util.*;
import java.io.*;

public class Main {
	static int[] inOrder;
	static int[] inOrder_idx;
	static int[] postOrder;
	static int root;
	static int N;
	static StringBuilder builder;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		builder = new StringBuilder();
		N = Integer.parseInt(reader.readLine());
		inOrder = new int[N+1];
		inOrder_idx = new int[N+1];
		postOrder = new int[N+1];
		
		StringTokenizer token = new StringTokenizer(reader.readLine());
		for(int i=1; i<=N; i++) {
			inOrder[i] = Integer.parseInt(token.nextToken());
		}
		token = new StringTokenizer(reader.readLine());
		for(int i=1; i<=N; i++) {
			postOrder[i] = Integer.parseInt(token.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			inOrder_idx[inOrder[i]] = i;
		}
		findPreOrder(1, N, 1, N);
		
		System.out.println(builder);
	}
	
	public static void findPreOrder(int in_start, int in_end, int post_start, int post_end) {
		if(in_start > in_end || post_start > post_end) {
			return;
		}
		int root = postOrder[post_end];
		builder.append(root + " ");
		
		int rootIdx = inOrder_idx[root];
		int left = rootIdx - in_start;
		
		findPreOrder(in_start, rootIdx-1, post_start, post_start + left -1);
		findPreOrder(rootIdx+1, in_end, post_start + left, post_end-1);
	}
}