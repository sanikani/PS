import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int K;
	static char[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = br.readLine().toCharArray();
			
			sb.append('#').append(tc).append(' ').append(solution()).append('\n');
		}
		System.out.println(sb);
	}

	private static int solution() {
		Set<Integer> set = new HashSet<>();
		int len = N / 4;
		
		for(int s = 0; s < len; s++) {
			for(int i = 0; i < 4; i++) {
				int idx = s + i * len;
				StringBuilder num = new StringBuilder();
				
				for(int l = 0; l < len; l++) {
					int nIdx = (idx + l) % N;
					num.append(arr[nIdx]);
				}
				
				set.add(Integer.parseInt(num.toString(), 16));
			}
		}
		List<Integer> list = new ArrayList<>(set);
		list.sort((a, b) -> Integer.compare(b, a));
		
		return list.get(K - 1);
	}
}
