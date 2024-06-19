//no. 1920
import java.util.*;
import java.io.*;

class Main {
	public static int[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());
		list = new int[N];
		StringTokenizer token = new StringTokenizer(reader.readLine());
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(token.nextToken());
		}
		
		Arrays.sort(list);
		
		int M = Integer.parseInt(reader.readLine());
		token = new StringTokenizer(reader.readLine());
		for(int i=0; i<M; i++) {
			int n = Integer.parseInt(token.nextToken());
			int result = binary_search(n, 0, list.length-1);
			builder.append(result + "\n");
		}
		System.out.println(builder);
	}
	
	public static int binary_search(int key, int low, int high) {
		
		while(low <= high) {
			int mid = (low + high)/2;
			if(key == list[mid]) {
				return 1;
			}
			else if(key < list[mid]) {
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		
		return 0;
	}
}