//no. 17298
import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int[] num = new int[N];
		int[] answer = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(token.nextToken());
		}
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<N; i++) {
			while(!stack.isEmpty() && num[stack.peek()] < num[i]) {
				int index = stack.pop();
				answer[index] = num[i];
			}
			stack.add(i);
		}
		for(int i=0; i<N; i++) {
			if(answer[i] == 0) {
				builder.append("-1 ");
			}
			else {
				builder.append(answer[i] + " ");
			}
		}
		System.out.println(builder);
	}
}