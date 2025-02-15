import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[] s = reader.readLine().toCharArray();
		
		int total = 0;  //잘려진 조각의 총 개수
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<s.length-1; i++) {
			if(s[i] == '(') {
				if(s[i+1] == '(') {
					total++;

				}
				stack.add(s[i]);
			} else {
				stack.pop();
				if(s[i-1] == '(') {
					total += stack.size();
				}
			}
		}
		System.out.println(total);
	}
}