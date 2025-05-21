import java.io.*;
import java.util.*;

class Main {
	static int N, K;
	static String[] words;
	static int max;
	static boolean[] alphabets = new boolean[26];
	static boolean[] usableAlphabet = new boolean[26];
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());
		words = new String[N];
		for(int i=0; i<N; i++) {
			words[i] = reader.readLine();
			
		}
		 
		//'a', 'c', 'i', 'n', 't' 는 항상 배워야함
		if(K<5) {
			System.out.println(0);
		} else if(K==26) {
			System.out.println(N);
		} else {
			getUsableAlphabet();
			getMaxWords(0, 5);
			System.out.println(max);
		}
		
	}
	
	public static void getUsableAlphabet() {
		alphabets['a'-'a'] = true;
		alphabets['c'-'a'] = true;
		alphabets['i'-'a'] = true;
		alphabets['n'-'a'] = true;
		alphabets['t'-'a'] = true;
	}
	
	public static void getMaxWords(int alpha, int count) {
		if(count == K) {
			int cnt = 0;
			for(int i=0; i<N; i++) {
				boolean flag = false;
				char[] word = words[i].toCharArray();
				for(int j=4; j<word.length-4; j++) {
					if(!alphabets[word[j]-97]) {
						flag = true;
						break;
					}
				}
				if(!flag) {
					cnt++;
				}
			}
			max = Math.max(max, cnt);
		}
		else {
			for(int i=alpha; i<26; i++) {
				if(!alphabets[i]) {
					alphabets[i] = true;
					getMaxWords(i, count+1);
					alphabets[i] = false;
				}
			}
		}
	}
}