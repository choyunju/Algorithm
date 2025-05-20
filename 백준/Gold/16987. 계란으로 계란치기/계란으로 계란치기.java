import java.io.*;
import java.util.*;

class Egg {
	int s, w;
	
	public Egg(int s, int w) {
		this.s = s;
		this.w = w;
	}
}

class Main {
	static int N;
	static int totalCnt=0;
	static Egg[] eggs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		eggs = new Egg[N];
	
		for(int i=0; i<N; i++) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(token.nextToken());
			int w = Integer.parseInt(token.nextToken());
			eggs[i] = new Egg(s, w);
		}
		
		simulate(0, 0);
		System.out.println(totalCnt);
	}
	
	public static void simulate(int now, int cnt) {
		if(cnt==N-1 || now == N) {
			totalCnt = Math.max(totalCnt, cnt);
			return;
		}
		if(eggs[now].s <= 0) {
			simulate(now+1, cnt);
		} else {
			for(int i=0; i<N; i++) {
				if(i==now) {
					continue;
				}
				if(eggs[i].s > 0) {
					eggs[i].s -= eggs[now].w;
					eggs[now].s -= eggs[i].w;
					simulate(now+1, cnt+(eggs[i].s <= 0 ? 1 : 0) + (eggs[now].s <= 0 ? 1 : 0));
					eggs[i].s += eggs[now].w;
					eggs[now].s += eggs[i].w;
				}
			}
		}
		
	}
}