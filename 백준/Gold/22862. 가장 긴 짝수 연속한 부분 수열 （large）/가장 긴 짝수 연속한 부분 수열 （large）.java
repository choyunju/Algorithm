import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		int[] arr = new int[N];
		
		token = new StringTokenizer(reader.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		
		int[] count = new int[2]; //0=짝수, 1=홀수
		int max = 0;
		int[] total = new int[N];
		int start = 0;
		int end = 0;
		while(start<N && end<N) {
			int num = arr[end];
			//짝수일 경우
			if(num%2 == 0) {
				count[0]++;
				end++;
			} else {
				if(count[1] < K) {
					count[1]++;
					end++;
				} else {
					if(max < count[0]) {
						max = count[0];
					}
					if(arr[start]%2 == 0) {
						count[0]--;
					} else {
						count[1]--;
					}
					start++;
				}
			}
		}
		
		if(max < count[0]) {
			max = count[0];
		}
		System.out.println(max);
	}
}