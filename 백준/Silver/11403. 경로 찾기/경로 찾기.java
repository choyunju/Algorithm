//문제 62 - 11403
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(reader.readLine());
		int[][] D = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			for(int j=1; j<=N; j++) {
				D[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		
		for(int k=1; k<=N; k++) {
			for(int s=1; s<=N; s++) {
				for(int e=1; e<=N; e++) {
					if(D[s][k] == 1 && D[k][e] == 1) {
						D[s][e] = 1;
					}	
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				writer.write(D[i][j] + " ");
			}
			writer.write("\n");
		}
		writer.flush();
	}
}