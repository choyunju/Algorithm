import java.io.*;
import java.util.*;

class Main {
	static boolean[] visited;
	static int[] arr;
	static ArrayList<Integer> list;
	static int root;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		arr = new int[N+1];
		list = new ArrayList<>();
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		
		for(int i=1; i<=N; i++) {
			visited[i] = true;
			root = i;
			DFS(i);
			visited = new boolean[N+1];
		}
		System.out.println(list.size());
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void DFS(int index) {
		int n = arr[index];
		//n이 첫 시작인 root와 동일하게 될 경우 사이클이 생성된다.
		if(n == root) {
			list.add(root);
		}
		
		if(!visited[n]) {
			visited[n] = true;
			DFS(n);
		}
	}
}