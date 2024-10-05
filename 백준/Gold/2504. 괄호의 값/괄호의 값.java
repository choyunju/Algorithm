//no.11 - 2504
import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		Stack<Character> stack = new Stack<>();
		boolean flag = true;
		
		int cnt = 1;
		int result = 0;
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if(c == '(') {
				stack.add(c);
				cnt *= 2;
			
			} else if(c == '[') {
				stack.add(c);
				cnt *= 3;
			
			}
			else {
				if(c == ')') {
					if(stack.isEmpty() || stack.peek() != '(') {
						flag = false;
						break;
					}
					if(s.charAt(i-1) == '(') {
						result += cnt;
					}
					stack.pop();
					cnt /= 2;
				} 
				else if(c == ']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						flag = false;
						break;
					}
					if(s.charAt(i-1) == '[') {
						result += cnt;
					}
					stack.pop();
					cnt /= 3;
				}
			}
		}
		if(!stack.isEmpty() || !flag) {
			System.out.println(0);
		} else {
			System.out.println(result);
		}
	}
}