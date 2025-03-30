import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = reader.readLine().toCharArray();
		
		//R의 총 개수
		int rCount = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 'R') {
				rCount++;
			}
		}
		
		int left = 0;
		int right = arr.length - 1;
		int rK = 0;
		int lK = 0;
		int max = rCount;
		while(left <= right) {
			if(lK < rK) {
				if(arr[left] == 'K') {
					lK++;
					left++;
				} else if(arr[left] == 'R') {
					max = Math.max(max, Math.min(lK, rK) * 2 + rCount);
					left++;
					rCount--;
				}
			} else {
				if(arr[right] == 'K') {
					rK++;
					right--;
				} else {
					max = Math.max(max, Math.min(lK, rK) * 2 + rCount);
					rCount--;
					right--;
				}
			}
		}
		System.out.println(max);
		
	}
}