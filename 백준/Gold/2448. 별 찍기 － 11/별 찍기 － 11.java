import java.io.*;
import java.util.*;

class Main {
	static char[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());
		arr = new char[N][2*N-1];
		for(int i=0; i<N; i++) {
			Arrays.fill(arr[i], ' ');
		}
		
		makeStar(0, N-1, N);
		for(int i=0; i<N; i++) {
			for(int j=0; j<2*N-1; j++) {
				builder.append(arr[i][j]);
			}
			builder.append("\n");
		}
		System.out.println(builder);
	}
	
	public static void makeStar(int x, int y, int N) {
		if(N==3) {
			arr[x][y] = '*';
			arr[x+1][y-1] = '*';
			arr[x+1][y+1] = '*';
			arr[x+2][y-2] = arr[x+2][y-1] = arr[x+2][y] = arr[x+2][y+1] = arr[x+2][y+2] = '*';
		} else {
			int size = N/2;
			makeStar(x, y, size);
			makeStar(x+size, y-size, size);
			makeStar(x+size, y+size, size);
		}
	}
}