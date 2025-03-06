import java.io.*;
import java.util.*;

class Main {
	static String[] string;
	static StringBuilder builder;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		builder = new StringBuilder();
		string = reader.readLine().split("");
		
		getMax();
		builder.append("\n");
		getMin();
		System.out.println(builder);
		
	}
	
	public static void getMin() {
		int[] num = new int[string.length];
		
		for(int i=0; i<string.length; i++) {
			String s = string[i];
			if(s.equals("M")) {
				num[i] = 1;
				int j = i-1;
				int end = -1;

				while(j>=0) {
					if(num[j] == 5) {
						break;
					} else {
						num[j] = 0;
						end = j;
						j--;
					}
				}
				if(end != -1) {
					num[end] = 1;
					num[i] = 0;
				}
				
			} else if(s.equals("K")) {
				num[i] = 5;
			}
		}
		
		for(int i=0; i<string.length; i++) {
			builder.append(num[i]);
		}
	}
	
	public static void getMax() {
		int[] num = new int[string.length];
		for(int i=0; i<string.length; i++) {
			String s = string[i];
			if(s.equals("M")) {
				num[i] = 1;
			} else if(s.equals("K")) {
				num[i] = 5;
				int end = -1;
				int j = i-1;
				while(j >= 0 && num[j] == 1) {
					num[j] = 0;
					end = j;
					j--;
				}
				if(end != -1) {
					num[i] = 0;
					num[end] = 5;
				}
			}
		}
		for(int i=0; i<num.length; i++) {
			builder.append(num[i]);
		}
	}
}