import java.io.*;
import java.util.*;

class Main {
	static char[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());
		
		arr = new char[N][N];
		
		star(0, 0, N, false);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				builder.append(arr[i][j]);
			}
			builder.append("\n");
		}
		System.out.println(builder);
	}
	
	public static void star(int x, int y, int N, boolean blank) {
		if(blank) {
			for(int i=x; i<x+N; i++) {
				for(int j=y; j<y+N; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
		
		if(N==1) {
			arr[x][y] = '*';
			return;
		}
		
		int size = N/3;
		int count = 0;
		for(int i=x; i<x+N; i+=size) {
			for(int j=y; j<y+N; j+=size) {
				count++;
				if(count == 5) {
					star(i, j, size, true);
				} else {
					star(i, j, size, false);
				}
			}
		}
	}
}