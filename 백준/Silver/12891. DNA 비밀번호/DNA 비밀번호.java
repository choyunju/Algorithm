import java.io.*;
import java.util.*;

public class Main {
	static int checkArr[];
	static int myArr[];
	static int check;
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int S = Integer.parseInt(token.nextToken());
		int P = Integer.parseInt(token.nextToken());
		
		int result = 0;
		char[] dna = new char[S];
		checkArr = new int[4];
		myArr = new int[4];
		check = 0;
		dna = reader.readLine().toCharArray();
		token = new StringTokenizer(reader.readLine());
		for(int i=0; i<4; i++) {
			checkArr[i] = Integer.parseInt(token.nextToken());
			if(checkArr[i] == 0) {
				check++;
			}
		}
		
		//처음 P길이 문자열 처리
		for(int i=0; i<P; i++) {
			Add(dna[i]);
		}
		
		if(check == 4) {
			result++;
		}
	
		//슬라이딩 윈도우
		for(int i=P; i<S; i++) {
			int j = i - P;
			Add(dna[i]);
			Remove(dna[j]);
			if(check==4) {
				result++;
			}			
		}
		
		System.out.print(result);
	}
	
	static void Add(char c) {
		switch(c) {
		case 'A' :
			myArr[0]++;
			if(myArr[0] == checkArr[0]) {
				check++;
			}
			break;
		case 'C' :
			myArr[1]++;
			if(myArr[1] == checkArr[1]) {
				check++;
			}
			break;
		case 'G' :
			myArr[2]++;
			if(myArr[2] == checkArr[2]) {
				check++;
			}
			break;
		case 'T' :
			myArr[3]++;
			if(myArr[3] == checkArr[3]) {
				check++;
			}
			break;
		}
	}
	
	static void Remove(char c) {
		switch(c) {
		case 'A' :
			if(myArr[0] == checkArr[0]) {
				check--;
			}
			myArr[0]--;
			break;
		case 'C' :
			if(myArr[1] == checkArr[1]) {
				check--;
			}
			myArr[1]--;
			break;
		case 'G' :
			if(myArr[2] == checkArr[2]) {
				check--;
			}
			myArr[2]--;
			break;
		case 'T' :
			if(myArr[3] == checkArr[3]) {
				check--;
			}
			myArr[3]--;
			break;
		}
	}
}