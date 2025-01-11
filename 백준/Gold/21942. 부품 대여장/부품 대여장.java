import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(token.nextToken());
		String[] L = token.nextToken().split("/|:");
		int ld = Integer.parseInt(L[0]);
		int lh = Integer.parseInt(L[1]);
		int lm = Integer.parseInt(L[2]);
		int range = ld*24*60 + lh*60 + lm;
		int F = Integer.parseInt(token.nextToken());
		
		HashMap<String, String> map = new HashMap<>();
		HashMap<String, Long> fine = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(reader.readLine());
			String date = token.nextToken();
			String time = token.nextToken();
			String item = token.nextToken();
			String user = token.nextToken();
			String id = item + "_" + user;
			
			
			if(map.containsKey(id)) {
				String date1 = map.get(id);
				String date2 = date + " " + time;
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				long d1 = format.parse(date1).getTime();
				long d2 = format.parse(date2).getTime();
				long diff = ((d2-d1)/(1000*60));
				
				if(range < diff) {
					if(fine.containsKey(user)) {
						fine.put(user, fine.get(user) + (diff-range)*F);
					} else {
						fine.put(user, (diff-range)*F);
					}
				}
				map.remove(id);
			} else {
				map.put(id, date + " " + time);
			}
		}
		List<String> list = new ArrayList<>(fine.keySet());
		list.sort((s1, s2) -> s1.compareTo(s2));
		if(fine.size() <= 0) {
			System.out.println(-1);
		} else {
			StringBuilder builder = new StringBuilder();
			for(String key : list) {
				builder.append(key + " " + fine.get(key)).append("\n");
			}
			System.out.println(builder);
		}
	}
}