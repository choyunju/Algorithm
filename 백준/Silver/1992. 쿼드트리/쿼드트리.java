import java.io.*;
import java.util.*;

class Main {
	static int N;
	static int map[][];
	static StringBuilder builder = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			String[] s = reader.readLine().split("");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		int startR = 0;
		int endR = N-1;
		int startC = 0;
		int endC = N-1;
		
		divide(startR, endR, startC, endC);
		System.out.println(builder);
	}
	
	public static void divide(int startR, int endR, int startC, int endC) {
		boolean flag = false;
		
		for(int i=startR; i<=endR; i++) {
			for(int j=startC; j<=endC; j++) {
				if(map[startR][startC] != map[i][j]) {
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
		
		if(flag) {
			int midR = (startR+endR)/2;
			int midC = (startC+endC)/2;
			builder.append("(");
			divide(startR, midR, startC, midC);
			divide(startR, midR, midC+1, endC);
			divide(midR+1, endR, startC, midC);
			divide(midR+1, endR, midC+1, endC);
			builder.append(")");
		} else {
			builder.append(map[startR][startC]);
			return;
		}
	}
}