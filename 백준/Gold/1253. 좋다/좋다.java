//no. 1253
import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[] num = new int[N];
		StringTokenizer token = new StringTokenizer(reader.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(token.nextToken());
		}
		Arrays.sort(num);
		int result = 0;
		
		for(int i=0; i<N; i++) {
			int target = num[i];
			int start = 0; int end = N-1;
			while(start<end) {
				int sum = num[start] + num[end];
				if(sum < target) {
					start++;
				}
				else if(sum == target) {
					if(start!=i && end!=i) {
						result++;
						break;
					}
					else if(start == i) {
						start++;
					}
					else {
						end--;
					}
					
				}
				else if(sum > target){
					end--;
				}
			}
		}
		System.out.println(result);
	}
}