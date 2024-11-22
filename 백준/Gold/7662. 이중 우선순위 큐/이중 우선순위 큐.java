import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int T = Integer.parseInt(reader.readLine());
		for(int i=0; i<T; i++) {
			int K = Integer.parseInt(reader.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<>();
			PriorityQueue<Integer> queue = new PriorityQueue<>();
			for(int j=0; j<K; j++) {
				StringTokenizer token = new StringTokenizer(reader.readLine());
				String s = token.nextToken();
				int n = Integer.parseInt(token.nextToken());
				if(s.equals("I")) {
					map.put(n, map.getOrDefault(n, 0) +1);
				} else if(s.equals("D")) {
					if(map.isEmpty()) {
						continue;
					} 
					int key = n == 1 ? map.lastKey() : map.firstKey();
					int cnt = map.get(key);
					
					if(cnt == 1) {
						map.remove(key);
					} else {
						map.put(key, cnt-1);
					}
				}
			}
			if(map.isEmpty()) {
				builder.append("EMPTY\n");
			} else {
				builder.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
			}
		}
		System.out.println(builder);
	}
}