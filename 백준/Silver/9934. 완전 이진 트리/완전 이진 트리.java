import java.util.*;
import java.io.*;

class Main {
	static int N;
	static List<ArrayList<Integer>> list;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		N = Integer.parseInt(reader.readLine());
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		arr = new int[(int) Math.pow(2, N)-1];
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		
		list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(new ArrayList<>());
		}
		search(0, arr.length-1, 0);
		
		for(int i=0; i<N; i++) {
			for(int n : list.get(i)) {
				builder.append(n + " ");
			}
			builder.append("\n");
		}
		System.out.println(builder);
	}
	
	static void search(int start, int end, int depth) {
		if(depth == N) {
			return;
		}
		int mid = (start + end) / 2;
		
		list.get(depth).add(arr[mid]);
		
		search(start, mid-1, depth+1);
		search(mid+1, end, depth+1);
		
	}
}