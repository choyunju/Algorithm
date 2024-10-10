//no.12 - 2493
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());
		StringTokenizer token = new StringTokenizer(reader.readLine());
		Stack<Top> stack = new Stack<>();
		for(int i=1; i<=N; i++) {
			int h = Integer.parseInt(token.nextToken());
			if(stack.isEmpty()) {
				builder.append(0 + " ");
				stack.add(new Top(i, h));
			} else {
				while(true) {
					Top top = stack.peek();
					if(top.height > h) {
						builder.append(top.num + " ");
						stack.add(new Top(i, h));
						break;
					} else {
						stack.pop();
					}
					
					if(stack.isEmpty()) {
						builder.append(0+" ");
						stack.add(new Top(i, h));
						break;
					}
				}
			}
		}
		System.out.println(builder);
	}
}

class Top {
	int num;
	int height;
	
	public Top(int num, int height) {
		this.num = num;
		this.height = height;
	}
}