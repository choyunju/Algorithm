import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		
		StringBuilder out = new StringBuilder();
		Queue<String> queue = new LinkedList<>();
		// 뒤의 원소를 접근하기 위한 변수
		String back="";
		for(int i=0; i<n; i++) {
			
			String[] s = reader.readLine().split(" ");
			String cmd = s[0];
	
			if(cmd.equals("push")) {
				queue.add(s[1]);
				back = s[1];
			}
			else if(cmd.equals("front")) {
				if(queue.isEmpty()) {
					out.append("-1");
				}
				else {
					out.append(queue.peek());
				}
				out.append("\n");
			}
			else if(cmd.equals("back")) {
				if(queue.isEmpty()) {
					out.append("-1");
				}
				else {
					out.append(back);
				}
				out.append("\n");
			}
			else if(cmd.equals("size")) {
				out.append(queue.size()).append("\n");
			}
			else if(cmd.equals("pop")) {
				if(queue.isEmpty()) {
					out.append("-1").append("\n");
				}
				else {
					out.append(queue.poll()).append("\n");
				}
			}
			else if(cmd.equals("empty")) {
				if(queue.isEmpty()) {
					out.append("1").append("\n");
				}
				else {
					out.append("0").append("\n");
				}
			}
		}
		System.out.println(out);
	}
}
