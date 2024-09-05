//문제 69 - 14425
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		tNode root = new tNode();
		
		for(int i=0; i<N; i++) {
			String s = reader.readLine();
			tNode now = root;
			for(int j=0; j<s.length(); j++) {
				char c = s.charAt(j);
				//해당 문자열을 배열의 index로 사용하기 위해 -'a'
				if(now.next[c-'a'] == null) {
					now.next[c-'a'] = new tNode(); //비어있다면 tNode 생성
				}
				now = now.next[c-'a'];
				if(j == s.length()-1) {
					now.isleaf = true;
				}
			}
		}
		int count = 0;  //포함되어 있는 문자열의 개수
		for(int i=0; i<M; i++) {
			String s = reader.readLine();
			tNode now = root;
			for(int j=0; j<s.length(); j++) {
				char c = s.charAt(j);
				if(now.next[c-'a'] != null) {
					now = now.next[c-'a'];
				}
				else if(now.next[c-'a'] == null) {
					break;
				}
				if(j == s.length()-1 && now.isleaf) {
					count++;
				}
				
			}
		}
		System.out.println(count);
	}
}

class tNode {
	tNode[] next = new tNode[26];
	boolean isleaf;  //문자열의 마지막 유무를 표시하기 위헤
}