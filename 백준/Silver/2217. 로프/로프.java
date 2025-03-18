import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[] weight = new int[N];
		for(int i=0; i<N; i++) {
			weight[i] = Integer.parseInt(reader.readLine());
		}
		Arrays.sort(weight);
		
		int maxWeight = weight[N-1];
		int count = 1;

		for(int i=N-2; i>=0; i--) {
			count++;
			int w = weight[i];
			int wn = w * count;
			maxWeight = Math.max(maxWeight, wn);
//			if(maxWeight <= wn) {
//				maxWeight = wn;
//			} else {
//				break;
//			}
		}
		System.out.println(maxWeight);
	}
}