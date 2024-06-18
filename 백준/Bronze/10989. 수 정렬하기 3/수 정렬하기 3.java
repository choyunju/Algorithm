//문제22 - 10989
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(reader.readLine());
		
		int[] arr = new int[10001];
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(reader.readLine());
			arr[num]++;
		}
		
		for(int i=0; i<arr.length; i++) {
			while(arr[i] > 0) {
				arr[i]--;
				writer.write(i + "\n");
			}
		}
		writer.flush();
	}
}