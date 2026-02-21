import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		System.out.println(solution(C, R, K));
	}

	private static String solution(int C, int R, int K) {
		if (C*R < K) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		int[] dc = {0, 1, 0, -1};
		int[] dr = {1, 0, -1, 0};
		
		int c = C - 1;
		int r = R;
		int nc = 0;
		int nr = 0;
		
		int cnt = 0;
		int idx = 0;
		while(c != 0 || r != 0) {
			if (idx%2==0) {
				cnt+=r;
				if(idx == 0) nc++;
				if (cnt >= K) {
					int len = Math.abs(cnt - r - K);
					nc += dc[idx%4]*len;
					nr += dr[idx%4]*len;
					return sb.append(nc).append(" ").append(nr).toString();
				}
				nc += dc[idx%4]*r;
				nr += dr[idx%4]*r;
				r--;
			}else {
				cnt+=c;
				if (cnt >= K) {
					int len = Math.abs(cnt - c - K);
					nc += dc[idx%4]*len;
					nr += dr[idx%4]*len;
					return sb.append(nc).append(" ").append(nr).toString();
				}
				nc += dc[idx%4]*c;
				nr += dr[idx%4]*c;
				c--;
			}
			
			idx++;
		}
		
		return "0";
	}
}
