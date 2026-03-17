import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			Map<String, Integer> map = new HashMap<>();
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				map.put(st.nextToken(), 1);
			}
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				if(map.containsKey(st.nextElement())) cnt++;
			}
			sb.append('#').append(tc).append(' ').append(cnt).append('\n');
		}
		System.out.println(sb);
	}
}
