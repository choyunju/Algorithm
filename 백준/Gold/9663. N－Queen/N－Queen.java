import java.io.*;
import java.util.*;

class Main {
	static int N;
	static boolean[][] arr;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		arr = new boolean[N][N];
		
		n_queen(0, 0);
		System.out.println(count);
	}
	
	public static void n_queen(int r, int queen) {
		if(r==N) {
			if(queen == N) {
				count++;
			}
			return;
		} 
		else {
			boolean flag = false;
			for(int i=0; i<N; i++) {
				if(possible(r, i)) {
					flag = true;
					arr[r][i] = true;
					n_queen(r+1, queen+1);
					arr[r][i] = false;
				}
			}
//			if(!flag) {
//				n_queen(r+1, queen);	
//			}
		}
	}
	
	public static boolean possible(int r, int c) {
		//같은 행에 queen이 있는지 확인
		for(int i=0; i<N; i++) {
			if(arr[r][i] == true) {
				return false;
			}
		}
		
		//같은 열에 queen이 있는지 확인
		for(int i=0; i<N; i++) {
			if(arr[i][c] == true) {
				return false;
			}
		}
		
		//대각선에 queen이 있는지 확인
		int leftC = c-1;
		int rightC = c+1;
		for(int i=r-1; i>=0; i--) {
			if(leftC >= 0) {
				if(arr[i][leftC] == true) {
					return false;
				}
			}
			if(rightC <N) {
				if(arr[i][rightC] == true) {
					return false;
				}
			}
			leftC--;
			rightC++;
		}
		
		return true;
	}
	
	public static void attack(int r, int c) {
		//같은 행 false
		for(int i=0; i<N; i++) {
			arr[r][i] = true;
		}
		
		//같은 열 false
		for(int i=0; i<N; i++) {
			arr[i][c] = true;
		}
		
		//대각선 false
		int rightC = c;
		int leftC = c;
		while(r<N) {
			if(rightC < N) {
				arr[r][rightC] = true;
				rightC++;
			}
			if(leftC >= 0) {
				arr[r][leftC] = true;
				leftC--;
			}
			r++;
		}
	}
}