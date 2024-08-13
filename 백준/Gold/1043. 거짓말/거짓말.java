//문제52 - 1043
import java.util.*;
import java.io.*;

public class Main {
	static int[] person;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken());
		int[] know = new int[n];
		for(int i=0; i<n; i++) {
			know[i] = Integer.parseInt(token.nextToken());
		}
		ArrayList<Integer>[] party = new ArrayList[M];
		for(int i=0; i<M; i++) {
			party[i] = new ArrayList<>();
			token = new StringTokenizer(reader.readLine());
			int num = Integer.parseInt(token.nextToken());
			for(int k=0; k<num; k++) {
				party[i].add(Integer.parseInt(token.nextToken()));
			}
			
		}
		person = new int[N+1];
		for(int i=1; i<=N; i++) {
			person[i] = i;
		}
		//각 파티의 사람들을 하나의 집합으로 만들기
		for(int i=0; i<M; i++) {
			int first = party[i].get(0);
			for(int j=1; j<party[i].size(); j++) {
				union(first, party[i].get(j));
			}
		}
		
		int result = 0;
		for(int i=0; i<M; i++) {
			boolean isPossible = true;
			int p = party[i].get(0);
			for(int j=0; j<know.length; j++) {
				if(find(p) == find(know[j])) {
					isPossible = false;
					break;
				}
				
			}
			if(isPossible) {
				result++;
			}
		}
		System.out.println(result);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			person[b] = a;
		}
	}
	
	public static int find(int a) {
		if(person[a] == a) {
			return a;
		}
		else {
			return find(person[a]);
		}
	}
}