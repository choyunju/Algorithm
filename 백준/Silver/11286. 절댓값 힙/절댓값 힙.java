import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(reader.readLine());
		
		//우선순위 큐는 기본적으로 정수형에 대해 오름차순 정렬
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) > Math.abs(o2)) {
					return 1;
				}
				else if(Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}
				else {
					return -1;
				}
			}
		});
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(reader.readLine());
			if(num != 0) {
				queue.add(num);
			}
			else {
				if(queue.isEmpty()) {
					sb.append("0" + "\n");
				}
				else {
					sb.append(queue.poll() + "\n");
				}
			}
		}
		System.out.println(sb);
	}
}
