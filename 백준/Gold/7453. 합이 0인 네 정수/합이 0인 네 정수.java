import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N];
		int[] D = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			A[i] = Integer.parseInt(token.nextToken());
			B[i] = Integer.parseInt(token.nextToken());
			C[i] = Integer.parseInt(token.nextToken());
			D[i] = Integer.parseInt(token.nextToken());
		}
		
		int[] ab = new int[N*N];
		int[] cd = new int[N*N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				ab[i*N+j] = A[i] + B[j];
				cd[i*N+j] = C[i] + D[j];
			}
		}
		
		Arrays.sort(ab);
		Arrays.sort(cd);
		
		int left = 0;
		int right = N*N-1;
		long cnt = 0;
		
		while(left<N*N && right>=0) {
			int sum = ab[left] + cd[right];
			if(sum > 0) {
				right--;
			} else if(sum < 0) {
				left++;
			} else {
				long leftCnt=1;
				long rightCnt=1;
				while(left+1<N*N && ab[left]==ab[left+1]) {
					leftCnt++;
					left++;
				}
				
				while(right-1>=0 && cd[right]==cd[right-1]) {
					rightCnt++;
					right--;
				}
				
				cnt += leftCnt * rightCnt;
				left++;
				right--;
			}
		}
		
		System.out.println(cnt);
	}
}