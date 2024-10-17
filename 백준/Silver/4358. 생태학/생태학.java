//no.02 - 4358
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = 0;
		HashMap<String, Integer> hashMap = new HashMap<>();
		String s = reader.readLine();
		while(true) {
			total++;
			hashMap.put(s, hashMap.getOrDefault(s, 0)+1);
			s = reader.readLine();
			if(s == null || s.length() == 0) {
				break;
			}
		}
		List<String> list = new ArrayList<>(hashMap.keySet());
		Collections.sort(list);
		StringBuilder builder = new StringBuilder();
		for(String tree : list) {
			int count = hashMap.get(tree) * 100;
			builder.append(tree + " " + String.format("%.4f", (double)count / (double)total) + "\n");
		}
		System.out.println(builder);
	}
}