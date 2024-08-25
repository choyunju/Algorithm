//문제 61 - 11404
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(reader.readLine());
		int M = Integer.parseInt(reader.readLine());
		int[][] D = new int[N+1][N+1];
		//최단 거리 배열 초기화
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i == j) {
					D[i][j] = 0;
				}
				else {
					D[i][j] = 10000001;
				}
			}	
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(token.nextToken());
			int e = Integer.parseInt(token.nextToken());
			int c = Integer.parseInt(token.nextToken());
			D[s][e] = Math.min(D[s][e], c);
		}
		
		//최단 거리 배열 업데이트
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					D[i][j] = Math.min(D[i][j], D[i][k]+D[k][j]);
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(D[i][j] == 10000001) {
					writer.write("0 ");
				}
				else {
					writer.write(D[i][j] + " ");
				}
			}
			writer.write("\n");
		}
		writer.flush();
	}
	
}