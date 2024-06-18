//no 1517
import java.util.*;
import java.io.*;

class Main {
	public static int[] sorted;
	public static long result;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int[] A = new int[N];
		sorted = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(token.nextToken());
		}
		
		merge_sort(A, 0, N-1);
		
		System.out.println(result);
	}
	
	public static void merge_sort(int[] A, int left, int right) {
		if(left == right) {
			return;
		}
		int mid = (left+right)/2;
		merge_sort(A, left, mid);
		merge_sort(A, mid+1, right);
		merge(A, left, mid, right);
	}
	
	public static void merge(int[] A, int left, int mid, int right) {
		int l = left;
		int r = mid+1;
		int idx = left;
		
		while(l<=mid && r<=right) {
			if(A[l] <= A[r]) {
				sorted[idx] = A[l];
				idx++;
				l++;
			} else {
				sorted[idx] = A[r];
				result += r-idx;
				idx++;
				r++;
			}
		}
		
		if(l > mid) {
			while(r<=right) {
				sorted[idx] = A[r];
				idx++;
				r++;
			}
		} else {
			while(l <= mid) {
				sorted[idx] = A[l];
				idx++;
				l++;
			}
		}
		
		for(int i=left; i<=right; i++) {
			A[i] = sorted[i];
		}
	}
}