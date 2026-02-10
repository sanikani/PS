import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] price;
	static int[] month;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			price = new int[4];
			month = new int[13];
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			min = Math.min(min, price[3]);
			dfs(1, 0);
			sb.append('#').append(test_case).append(' ').append(min).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int m, int total) {
		if(m >= 13) {
			min = Math.min(min, total);
			return;
		}
		
		if(total > price[3]) return;
		if(month[m] == 0) {
			dfs(m+1, total);
		}
		int dailyPrice = price[0] * month[m];
		if(dailyPrice > price[1]) {
			dfs(m+1, total + price[1]);
		}else {
			dfs(m+1, total + price[0]*month[m]);
		}
		
		dfs(m+3, total + price[2]);
	}
}
