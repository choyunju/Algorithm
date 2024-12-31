import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());
		TreeSet<Question> treeSet = new TreeSet<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(token.nextToken());
			int l = Integer.parseInt(token.nextToken());
			treeSet.add(new Question(n, l));
			map.put(n, l);
		}
		int M = Integer.parseInt(reader.readLine());
		for(int i=0; i<M; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			String s = token.nextToken();
			
			if(s.equals("add")) {
				int n = Integer.parseInt(token.nextToken());
				int l = Integer.parseInt(token.nextToken());
				treeSet.add(new Question(n,l));
				map.put(n, l);
			} else if(s.equals("recommend")) {
				int a = Integer.parseInt(token.nextToken());
				if(a == 1) {
					builder.append(treeSet.last().number+"\n");
				} else {
					builder.append(treeSet.first().number+"\n");
				}
			} else if(s.equals("solved")) {
				int n = Integer.parseInt(token.nextToken());
				int l = map.get(n);
				treeSet.remove(new Question(n, l));
			}
		}
		System.out.println(builder);
	}
}

class Question implements Comparable<Question> {
	int number;
	int level;
	
	public Question(int number, int level) {
		this.number = number;
		this.level = level;
	}
	
	@Override
	public int compareTo(Question o) {
		if(this.level == o.level) {
			return this.number - o.number;
		} else {
			return this.level - o.level;
		}
	}
}