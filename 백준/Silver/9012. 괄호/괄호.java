//no. 9012
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int N = Integer.parseInt(reader.readLine());
		for(int i=0; i<N; i++) {
			Stack<String> stack = new Stack<>();
			String[] s = reader.readLine().split("");
			for(int j=0; j<s.length; j++) {
				if(s[j].equals("(")) {
					stack.add(s[j]);
				} else {
					if(stack.isEmpty()) {
						builder.append("NO\n");
						break;
					} else {
						stack.pop();
					}
				}
				if(j==(s.length-1) && stack.isEmpty()) {
					builder.append("YES\n");
				} else if(j==s.length-1 && !stack.isEmpty()) {
					builder.append("NO\n");
				}
			}
		}
		System.out.println(builder);
	}
}