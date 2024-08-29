//no.63 - 1389
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int[][] friends = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) {
					friends[i][j] = 0;
				} else {
					friends[i][j] = 10000001;
				}
			}
		}
		for(int i=1; i<=M; i++) {
			token = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			friends[a][b] = 1;
			friends[b][a] = 1;
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(friends[i][j] > friends[i][k] + friends[k][j]) {
						friends[i][j] = friends[i][k]+friends[k][j];
					}
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		int answer = 0;
		for(int i=1; i<=N; i++) {
			int temp = 0;
			for(int j=1; j<=N; j++) {
				temp += friends[i][j];
			}
			if(min>temp) {
				min = temp;
				answer = i;
			}
		}
		System.out.println(answer);
	}
}