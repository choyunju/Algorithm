//no.70 - 1991
import java.io.*;
import java.util.*;

class Main {
	static char[][] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		tree = new char[26][2];
		for(int i=0; i<N; i++) {
			String[] temp = reader.readLine().split(" ");
			int index = temp[0].charAt(0)-'A';
			char left = temp[1].charAt(0);
			char right = temp[2].charAt(0);
			tree[index][0] = left;
			tree[index][1] = right;
		}
		preOrder('A');
		System.out.println();
		inOrder('A');
		System.out.println();
		postOrder('A');
	}
	
	public static void preOrder(char now) {
		if(now == '.') {
			return;
		}
		System.out.print(now);
		preOrder(tree[now-'A'][0]);
		preOrder(tree[now-'A'][1]);
	}
	
	public static void inOrder(char now) {
		if(now == '.') {
			return;
		}
		inOrder(tree[now-'A'][0]);			
		System.out.print(now);
		inOrder(tree[now-'A'][1]);
	}
	
	public static void postOrder(char now) {
		if(now == '.') {
			return;
		}
		postOrder(tree[now-'A'][0]);
		postOrder(tree[now-'A'][1]);
		System.out.print(now);
	}
}