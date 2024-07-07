//no. 1541
import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] formula = reader.readLine().split("-");
		
		for(int i=0; i<formula.length; i++) {
			String[] add = formula[i].split("\\+");
			int temp = 0;
			for(int j=0; j<add.length; j++) {
				temp += Integer.parseInt(add[j]);
			}
			formula[i] = Integer.toString(temp);
		}
		int ans = 0;
		for(int i=0; i<formula.length; i++) {
		
			if(i==0) {
				ans = Integer.parseInt(formula[i]);
			}
			else {
				ans -= Integer.parseInt(formula[i]);
			}
		}
		System.out.println(ans);
	}
}