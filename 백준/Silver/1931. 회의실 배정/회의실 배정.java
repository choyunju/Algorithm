//문제35 - 1931
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int count = 0;  //가능한 회의의 개수
		int[][] A = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			A[i][0] = start;
			A[i][1] = end;
		}
		Arrays.sort(A, new Comparator<int[]>() {
			@Override
			public int compare(int[] s, int[] e) {
				if(s[1] == e[1]) {  //종료시간이 같으면 시작시간이 빠른 것이 먼저
					return s[0] - e[0];
				}
				return s[1] - e[1];  //종료시간이 빠른 것이 먼저
			}
		});
		int endTime = -1;
		for(int i=0; i<N; i++) {
			if(A[i][0] >= endTime) {
				endTime = A[i][1];
				count++;
			}
		}
		System.out.println(count);
	}
}