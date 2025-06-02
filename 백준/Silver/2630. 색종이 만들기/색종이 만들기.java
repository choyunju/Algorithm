import java.io.*;
import java.util.*;

class Main {
	static int[][] map;
	static int[][] color;
	static int whiteCnt = 0;
	static int blueCnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		map = new int[N][N];
		color = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		
		int startRow = 0;
		int endRow = N-1;
		int startCol = 0;
		int endCol = N-1;
		divide(startRow, endRow, startCol, endCol);
		System.out.println(whiteCnt);
		System.out.println(blueCnt);
	}
	
	public static void divide(int startR, int endR, int startC, int endC) {
		if(startR == endR || startC == endC) {
			if(map[startR][startC] == 0) {
				whiteCnt++;
				return;
			} else {
				blueCnt++;
				return;
			}
		}
		
		int midRow = (startR + endR)/2;
		int midCol = (startC + endC)/2;
		boolean flag = false;
		for(int i=startR; i<=endR; i++) {
			for(int j=startC; j<=endC; j++) {
				// 색상이 다르면 분할
				if(map[i][j] != map[startR][startC]) {
					flag = true;
				
				}
			}
		}
		
		if(flag) {
			divide(startR, midRow, startC, midCol);
			divide(startR, midRow, midCol+1, endC);
			divide(midRow+1, endR, startC, midCol);
			divide(midRow+1, endR, midCol+1, endC);
		} else {
			if(map[startR][startC] == 0) {
				whiteCnt++;
				return;
			} else {
				blueCnt++;
				return;
			}
		}
		
		
		
	}
}