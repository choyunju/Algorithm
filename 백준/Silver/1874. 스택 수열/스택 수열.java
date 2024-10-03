//no.9 - 1874
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());
		Stack<Integer> stack = new Stack<>();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		
		
//		while(num <=N) {
//			int a = arr[index];
//			if(stack.isEmpty()) {
//				stack.add(num);
//				num++;
//				builder.append("+\n");
//			}
//			if(stack.peek() == a) {
//				stack.pop();
//				index++;
//				builder.append("-\n");
//			} else if(stack.peek() < a) {
//				stack.add(num);
//				num++;
//				builder.append("+\n");
//			} else if(stack.peek() > a) {
//				builder = new StringBuilder();
//				builder.append("NO");
//				break;
//			}
//		}
		
		int num = 1;
		for(int i=0; i<N; i++) {
			int a = arr[i];
			if(stack.isEmpty() && num<=N) {
				stack.add(num);
				num++;
				builder.append("+\n");
			}
			while(stack.peek() < a && num <=N) {
				stack.add(num);
				num++;
				builder.append("+\n");
			}
			if(stack.peek() == a) {
				stack.pop();
				builder.append("-\n");
			} else if(stack.peek() > a) {
				builder = new StringBuilder();
				builder.append("NO");
				break;
			}
		}
		System.out.println(builder);
	}
}