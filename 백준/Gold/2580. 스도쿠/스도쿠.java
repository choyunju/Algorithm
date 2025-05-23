import java.io.*;
import java.util.*;

class Main {
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9][9];
		
		for(int i=0; i<9; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			for(int j=0; j<9; j++) {
				int n = Integer.parseInt(token.nextToken());
				arr[i][j] = n;
			}
		}
		
		sudoku(0, 0);
	}
	
	public static void sudoku(int r, int c) {
		
		//행의 끝까지 올 경우
		if(c==9) {
			sudoku(r+1, 0);
			return;
		}
		
		if(r==9) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		//빈칸인 경우
		if(arr[r][c] == 0) {
			
			for(int i=1; i<=9; i++) {
				if(possibleNum(r, c, i)) {
					
					arr[r][c] = i;
					sudoku(r, c+1);
					arr[r][c]=0;
				}
				
			}	
			return;
		}
		sudoku(r, c+1);
	}
	
	public static boolean possibleNum(int r, int c, int n) {
		//같은 행에 있는 숫자들 중 겹치는 숫자 검사
		for(int i=0; i<9; i++) {
			if(arr[r][i] == n) {
				return false;
			}
		}
		
		//같은 열에 있는 숫자들중 겹치는 숫자 검사
		for(int i=0; i<9; i++) {
			if(arr[i][c] == n) {
				return false;
			}
		}
		
		//3*3 블록 학인
		int set_row = (r/3)*3; 
		int set_col = (c/3)*3;
		for(int i=set_row; i<set_row+3; i++) {
			for(int j=set_col; j<set_col+3; j++) {
				 if(arr[i][j] == n) {
					 return false;
				 }
			}
		}
		return true;
	}
}