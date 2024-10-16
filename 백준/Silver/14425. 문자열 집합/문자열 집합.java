//no.01 - 14425
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		
		HashMap<String, Integer> hashMap = new HashMap<>();
		for(int i=0; i<N; i++) {
			String s = reader.readLine();
			hashMap.put(s, i);
		}
		int result = 0;
		for(int i=0; i<M; i++) {
			String s = reader.readLine();
			if(hashMap.containsKey(s)) {
				result++;
			}
		}
		System.out.println(result);
	}
}