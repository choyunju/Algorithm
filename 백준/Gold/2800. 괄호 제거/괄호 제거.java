//no.14 - 2800
import java.io.*;
import java.util.*;

class Main {
	static char[] c;
	static boolean[] isSelected;
	static StringBuilder builder;
	static ArrayList<Garo> list;
	static HashSet<String> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		c = reader.readLine().toCharArray();
		
		Stack<Integer> stack = new Stack<>();
		list = new ArrayList<>();
		for(int i=0; i<c.length; i++) {
			if(c[i] == '(') {
				stack.add(i);
			} else if(c[i] == ')') {
				int start = stack.pop();
				list.add(new Garo(start, i));
			}
		}
		int listSize = list.size();
		isSelected = new boolean[listSize];
		
		subset(0, listSize, 0);
		
		ArrayList<String> result = new ArrayList<>(set);
		
		Collections.sort(result,(x,y) -> x.compareTo(y));
		
		builder = new StringBuilder();
		for(String string : result) {
			builder.append(string + "\n");
		}
		System.out.println(builder);
	}
	
	public static void subset(int idx, int N, int count) {
		if(idx == N) {
			if(count == 0) {
				return;
			}
			make(N);
			return;
		}
		
		isSelected[idx] = true;
		subset(idx+1, N, count+1);
		isSelected[idx] = false;
		subset(idx+1, N, count);
	}
	
	public static void make(int N) {
		builder = new StringBuilder();
		boolean[] temp = new boolean[c.length];
		
		for(int i=0; i<N; i++) {
			if(isSelected[i]) {
				temp[list.get(i).start] = true;
				temp[list.get(i).end] = true;
			}
		}
		
		for(int i=0; i<temp.length; i++) {
			if(!temp[i]) {
				builder.append(c[i]);
			}
		}
		set.add(builder.toString());
	}
}

class Garo {
	int start, end;
	
	public Garo(int start, int end) {
		this.start = start;
		this.end = end;
	}
}