import java.util.*;
import java.io.*;

class Main {
	public static class Problem implements Comparable<Problem> {
		int idx;
		int level;
		
		public Problem(int idx, int level) {
			this.idx = idx;
			this.level = level;
		}
		
		@Override
		public int compareTo(Problem o) {
			if(this.level == o.level) {
				return this.idx - o.idx;
			}
			return this.level - o.level;
		}
	}
	
	
	public static class Problem2 {
		int level;
		int alg;
		
		public Problem2(int level, int alg) {
			this.level = level;
			this.alg = alg;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		
		TreeSet<Problem> tree = new TreeSet<>();
		HashMap<Integer, Problem2> map = new HashMap<>();
		ArrayList<TreeSet<Problem>> alg_list = new ArrayList<>();
		
		for(int i=0; i<101; i++) {
			alg_list.add(new TreeSet<>());
		}
		
		for(int i=0; i<N; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int num = Integer.parseInt(token.nextToken());
			int level = Integer.parseInt(token.nextToken());
			int alg = Integer.parseInt(token.nextToken());
			tree.add(new Problem(num, level));
			alg_list.get(alg).add(new Problem(num, level));
			map.put(num, new Problem2(level, alg));
		}
		
		int M = Integer.parseInt(reader.readLine());
		StringBuilder builder = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			String command = token.nextToken();
			
			if(command.equals("recommend")) {
				int alg = Integer.parseInt(token.nextToken());
				int x = Integer.parseInt(token.nextToken());
				
				if(x==1) {
					builder.append(alg_list.get(alg).last().idx).append("\n");
				} else if(x==-1){
					builder.append(alg_list.get(alg).first().idx).append("\n");
				}
			} 
			
			if(command.equals("recommend2")) {
				int x = Integer.parseInt(token.nextToken());
				if(x==1) {
					builder.append(tree.last().idx).append("\n");
				} else if(x==-1){
					builder.append(tree.first().idx).append("\n");
				}
			}
			
			if(command.equals("recommend3")) {
				int x = Integer.parseInt(token.nextToken());
				int condition = Integer.parseInt(token.nextToken());
				
				if(x==1) {
					Problem temp = tree.higher(new Problem(0, condition));
					if(temp == null ) {
						builder.append("-1\n");
					} else {
						builder.append(temp.idx + "\n");
					}
				} else if(x==-1) {
					Problem temp = tree.lower(new Problem(0, condition));
					if(temp == null) {
						builder.append("-1\n");
					} else {
						builder.append(temp.idx + "\n");
					}
				}
			}
			
			if(command.equals("add")) {
				int num = Integer.parseInt(token.nextToken());
				int level = Integer.parseInt(token.nextToken());
				int alg = Integer.parseInt(token.nextToken());
				
				tree.add(new Problem(num, level));
				alg_list.get(alg).add(new Problem(num, level));
				map.put(num, new Problem2(level, alg));
			}
			
			if(command.equals("solved")) {
				int num = Integer.parseInt(token.nextToken());
				int level = map.get(num).level;
				int alg = map.get(num).alg;
				
				tree.remove(new Problem(num, level));
				alg_list.get(alg).remove(new Problem(num, level));
				map.remove(num);
			}
		}
		System.out.println(builder);
	}
}

