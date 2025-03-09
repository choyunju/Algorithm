import java.io.*;
import java.util.*;

class Main {
	static StringBuilder builder;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		builder = new StringBuilder();
		flag = false;
		String[] s = reader.readLine().split("");
		Queue<String> queue = new LinkedList<>();
		for(int i=0; i<s.length; i++) {
			queue.add(s[i]);
		}
		int poly=0;
		while(!queue.isEmpty()) {
			String board = queue.poll();
			if(board.equals("X")) {
				poly++;
			} else if(board.equals(".")) {
				change(poly);
				builder.append(".");
				poly = 0;
			}
		}
		if(poly != 0) {
			change(poly);
		}
		if(flag) {
			System.out.println(-1);
		} else {
			System.out.println(builder);
		}
		
	}	
	
	public static void change(int poly) {
		while(poly >0) {
			if(poly%4 == 0) {
				for(int i=0; i<poly/4; i++) {
					builder.append("AAAA");
				}
				poly = 0;
			} else {
				if(poly > 4) {
					builder.append("AAAA");
					poly -= 4;
				} else {
					if(poly % 2 == 0) {
						builder.append("BB");
						poly -= 2;
					} else {
						flag = true;
						break;
					}
				}
			}
		}		
	}
}