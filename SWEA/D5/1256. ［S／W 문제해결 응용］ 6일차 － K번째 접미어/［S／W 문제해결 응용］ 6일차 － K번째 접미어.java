import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Solution {
	static int k;
	static String s;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			k = Integer.parseInt(br.readLine());
			s = br.readLine();
			TreeSet<String> set = new TreeSet<>();
			for(int start = 0; start < s.length(); start++){
				set.add(s.substring(start, s.length()));
			}
			
			String result = "none";
			if(set.size() >= k) {
				int idx = 1;
				for(String str : set) {
					if(idx == k) {
						result = str;
						break;
					}
					idx++;
				}
			}
			sb.append('#').append(tc).append(' ').append(result).append('\n');
		}
		System.out.println(sb);
	}
}
