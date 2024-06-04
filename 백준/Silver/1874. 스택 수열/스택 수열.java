import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int numArray[] = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<n; i++) {
			numArray[i] = Integer.parseInt(reader.readLine());
		}
		StringBuilder result = new StringBuilder();
		
		int number = 1;
		boolean b = true;
		for(int i=0; i<n; i++) {
			if(numArray[i] >= number) {
				while(numArray[i] >= number) {
					stack.push(number);
					number++;
					result.append("+\n");
				}
				stack.pop();
				result.append("-\n");
			}
			else {
				int peek = stack.pop();
				if(peek > numArray[i]) {
					System.out.print("NO");
					b = false;
					break;
				}
				else {
					result.append("-\n");
				}
			}
		}
		if(b) {
			System.out.print(result);
		}
		
	}
}