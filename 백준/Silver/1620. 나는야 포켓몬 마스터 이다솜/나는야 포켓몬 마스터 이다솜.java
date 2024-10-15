//no.00 - 1620
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		StringBuilder builder = new StringBuilder();
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		HashMap<String, String> hashmap = new HashMap<>();
		
		for(int i=1; i<=N; i++) {
			String s = reader.readLine();
			
			hashmap.put(s, Integer.toString(i));
			hashmap.put(Integer.toString(i), s);
		}
		for(int i=0; i<M; i++) {
			String q = reader.readLine();
			String result = hashmap.get(q);
			builder.append(result+"\n");
		}
		System.out.println(builder);
	}
}