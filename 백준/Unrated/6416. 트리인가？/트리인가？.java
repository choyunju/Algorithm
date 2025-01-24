import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		int count = 1;
		StringBuilder builder = new StringBuilder();
		while(true) {
			HashMap<Integer, Integer> hashMap = new HashMap<>();
			int edge = 0;
			while(true) {
				int u = scanner.nextInt();
				int v = scanner.nextInt();
				if(u==0 && v==0) {
					break;
				} else if(u==-1 && v==-1) {
					return;
				}
				hashMap.put(u, hashMap.getOrDefault(u, 0));
				hashMap.put(v, hashMap.getOrDefault(v, 0) + 1);
				edge++;
			}
			int root = 0;
			boolean isTree = true;
			Set<Integer> keySet = hashMap.keySet();
			for(int key : keySet) {
				if(hashMap.get(key) == 0) {
					root++;
				}
				else if(hashMap.get(key) > 1) {
					isTree = false;
					break;
				}
			}
			if(hashMap.isEmpty()) {
				System.out.println("Case " + count + " is a tree.");
			} else if(isTree && hashMap.size() -1 == edge && root == 1) {
				System.out.println("Case " + count + " is a tree.");
			} else {
				System.out.println("Case " + count + " is not a tree.");
			}
			count++;	
		}
	}
}