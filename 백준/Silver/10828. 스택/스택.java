//no. 10828
import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(reader.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			String s = token.nextToken();
			if(s.equals("push")) {
				int a = Integer.parseInt(token.nextToken());
				stack.add(a);
			} else if(s.equals("pop")) {
				if(stack.isEmpty()) {
					builder.append("-1\n");
				} else {
					builder.append(stack.pop()+"\n");
				}
			} else if(s.equals("size")) {
				builder.append(stack.size() + "\n");
			} else if(s.equals("empty")) {
				if(stack.isEmpty()) {
					builder.append("1\n");
				} else {
					builder.append("0\n");
				}
			} else if(s.equals("top")) {
				if(stack.isEmpty()) {
					builder.append("-1\n");
				} else {
					builder.append(stack.peek() + "\n");
				}
			}
		}
		System.out.println(builder);
	}
}