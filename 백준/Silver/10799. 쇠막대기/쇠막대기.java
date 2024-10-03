//no.10 - 10799
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack = new Stack<>();
		String[] s = reader.readLine().split("");
		int count = 0;
		int result = 0;

		for(int i=0; i<s.length-1; i++) {
			String g = s[i];
			int post = i-1;
			int next = i+1;
			if(g.equals("(")) {
				if(!s[next].equals(")")) {
					count++;
					result++;
				}
				stack.add(g);
			} else if(g.equals(")")) {
				if(s[post].equals(")")) {
					count--;
				} else if(s[post].equals("(")) {
					result = result + count;
				}
				stack.pop();
			}
		}
		System.out.println(result);
	}
}