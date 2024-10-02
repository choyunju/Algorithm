//no.7 - 1935
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		Stack<Double> stack  = new Stack<>();
		long[] num = new long[N];
		char[] s = reader.readLine().toCharArray();
		for(int i=0; i<N; i++) {
			num[i] = Long.parseLong(reader.readLine()); 
		}
	
		for(int i=0; i<s.length; i++) {
			double result = 0;
			if(s[i] >= 'A' && s[i] <= 'Z') {
				stack.add((double)num[s[i]-65]);
			} else if(s[i] == '+'){
				double a = stack.pop();
				double b = stack.pop();
				result = b + a;
				stack.add(result);
			} else if(s[i] == '-') {
				double a = stack.pop();
				double b = stack.pop();
				result = b - a;
				stack.add(result);
			} else if(s[i] == '*') {
				double a = stack.pop();
				double b = stack.pop();
				result = b * a;
				stack.add(result);
			} else if(s[i] == '/') {
				double a = stack.pop();
				double b = stack.pop();
				result = b / a;
				stack.add(result);
			}
		}

		System.out.printf("%.2f", stack.pop());
	}
}