import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//끝나는 시간 기준으로 정렬
		//끝나는 시간이 같다면 시작하는 시간 
		Arrays.sort(arr, (a, b) -> {
			if(a[1] == b[1]) return a[0] - b[0];
			return a[1] - b[1];
		});
		
		System.out.println(solution(N, arr));
	}

	private static int solution(int n, int[][] arr) {
		int end = -1;
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			if(arr[i][0] >= end) {
				cnt++;
				end = arr[i][1];
			}
		}
		return cnt;
	}
}
