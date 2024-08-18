//no.1948
import java.util.*;
import java.io.*;

class Main {
	static ArrayList<City>[] list;
	static ArrayList<City>[] rlist;
	static int[] time;
	static int[] indegree;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int M = Integer.parseInt(reader.readLine());
		list = new ArrayList[N+1];
		rlist = new ArrayList[N+1];
		time = new int[N+1];
		indegree = new int[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
			rlist[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			int t = Integer.parseInt(token.nextToken());
			
			list[a].add(new City(b, t));
			rlist[b].add(new City(a, t));
			indegree[b]++;
		}
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int start = Integer.parseInt(token.nextToken());
		int end = Integer.parseInt(token.nextToken());
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(City city : list[now]) {
				indegree[city.n]--;
				time[city.n] = Math.max(time[city.n], time[now] + city.time);
				if(indegree[city.n] == 0) {
					queue.add(city.n);
				}
			}
		}
		int count = 0;
		boolean[] visited = new boolean[N+1];
		queue = new LinkedList<>();
		queue.add(end);
		visited[end] = true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(City city : rlist[now]) {
				if(time[city.n] + city.time == time[now]) {
					count++;
					if(!visited[city.n]) {
						visited[city.n] = true;
						queue.add(city.n);
					}
				}
				
			}
		}
		System.out.println(time[end]);
		System.out.println(count);
	}
}

class City {
	int n;
	int time;
	
	public City(int n, int time) {
		this.n = n;
		this.time = time;
	}
}