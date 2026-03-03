import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] leds = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			leds[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			solution(leds, n, s, num);
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			sb.append(leds[i]).append(' ');
            if(i % 20 == 0) sb.append('\n');
		}
		System.out.println(sb);
	}
	
	static void solution(int[] leds, int n, int st, int num) {
		if(st == 1) {
			for(int i = num; i <= n; i += num) {
				if(leds[i] == 1) leds[i] = 0;
				else leds[i] = 1;
			}
		}
		else {
			int lt = num;
			int rt = num;
			
			while(lt >= 1 && rt <= n) {
				if(leds[lt] != leds[rt]) {
					lt++;
					rt--;
					break;
				}
				if(lt == 1 || rt == n) break;
				lt--;
				rt++;
			}
			
			for(int i = lt; i <= rt; i++) {
				if(leds[i] == 1) leds[i] = 0;
				else leds[i] = 1;
			}
		}
	}
}
