//no. 2751
import java.io.*;
import java.util.*;

class Main {
	public static int[] sorted;  //정렬된 수를 넣어줄 임시 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		StringBuilder builder = new StringBuilder();
		int[] A = new int[N];
		sorted = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(reader.readLine());
		}
		mergeSort(A, 0, N-1);
		
		for(int i=0; i<N; i++) {
			builder.append(A[i] + "\n");
		}
		System.out.println(builder);
	}
	
	public static void mergeSort(int[] A, int left, int right) {
//		부분 리스트가 1개의 원소만 갖고 있는 경우 
//		=> 더이상 쪼개질 수 없으므로 return
		if(left == right) { return;	}
		
		int mid = (left + right)/2;  //절반 위치
		
		mergeSort(A, left, mid);  //절반 중 왼쪽 부분리스트
		mergeSort(A, mid+1, right);  //절반 중 오른쪽 부분리스트
		
		merge(A, left, mid, right);  //병합 작업
	}
	
	public static void merge(int[] A, int left, int mid, int right) {
		int l = left;  //첫번째 배열 비교 인덱스
		int r = mid + 1;  //두번째 배열 비교 인덱스
		int idx = left;  //sorted에 넣어줄 인덱스
		
		while(l <= mid && r <= right) {
			if(A[l] <= A[r]) {
				sorted[idx] = A[l];
				idx++;
				l++;
			}
			else {
				sorted[idx] = A[r];
				idx++;
				r++;
			}
		}
		/*
		 * 왼쪽 부분리스트가 먼저 모두 sorted에 채워졌을 경우 (l > mid)
		 * = 오른쪽 부분리스트 원소가 아직 남아있는 경우
		 * 오른쪽 부분리스트의 나머지 원소들을 sorted에 채워준다.
		 */
		if(l>mid) {
			while(r <= right) {
				sorted[idx] = A[r];
				idx++;
				r++;
			}
		}
		/*
		 * 오른쪽 부분리스트가 먼저 모두 sorted에 채워졌을 경우 (r > right)
		 * = 왼쪽 부분리스트 원소가 아직 남아있는 경우
		 * 왼쪽 부분리스트의 나머지 원소들을 sorted에 채워준다.
		 */
		else {
			while(l <= mid) {
				sorted[idx] = A[l];
				idx++;
				l++;
			}
		}
		
		//정렬된 sorted를 기존의 배열에 복사하여 옮겨준다.
		for(int i=left; i<=right; i++) {
			A[i] = sorted[i];
		}
	}
}